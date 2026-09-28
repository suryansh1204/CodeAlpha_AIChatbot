import java.util.Set;

/**
 * The core AI processing engine.
 * Uses NLP keyword extraction + intent matching to generate responses.
 */
public class ChatEngine {

    private final NLPProcessor  nlp;
    private final KnowledgeBase kb;

    // Score threshold to accept a match
    private static final double MATCH_THRESHOLD = 0.25;

    public ChatEngine() {
        this.nlp = new NLPProcessor();
        this.kb  = new KnowledgeBase();
    }

    /**
     * Processes user input and returns a response string.
     */
    public String respond(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            return "Please type something! I'm here to help.";
        }

        String normalized = nlp.normalize(userInput);

        // ── 1. Direct math expression check ──────────────────────────────────
        String mathResult = tryMath(normalized);
        if (mathResult != null) return mathResult;

        // ── 2. NLP keyword matching ───────────────────────────────────────────
        Set<String> keywords = nlp.extractKeywords(userInput);

        String  bestIntent    = null;
        double  bestScore     = 0.0;
        Intent  matchedIntent = null;

        for (Intent intent : kb.getIntents()) {
            double score = nlp.matchScore(keywords, intent.getKeywords());
            if (score > bestScore) {
                bestScore     = score;
                bestIntent    = intent.getName();
                matchedIntent = intent;
            }
        }

        // ── 3. Return matched response or fallback ────────────────────────────
        if (matchedIntent != null && bestScore >= MATCH_THRESHOLD) {
            return matchedIntent.getResponse();
        }

        return getFallbackResponse(userInput);
    }

    /**
     * Attempts to evaluate simple arithmetic expressions like "5 + 3" or "10 * 4".
     */
    private String tryMath(String normalized) {
        // Match patterns like: 5 + 3, 10.5 * 2, 100 / 4, 9 - 3
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(
            "(\\d+\\.?\\d*)\\s*([+\\-*/])\\s*(\\d+\\.?\\d*)");
        java.util.regex.Matcher m = p.matcher(normalized);
        if (m.find()) {
            try {
                double a  = Double.parseDouble(m.group(1));
                String op = m.group(2);
                double b  = Double.parseDouble(m.group(3));
                double result = switch (op) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> b != 0 ? a / b : Double.NaN;
                    default  -> Double.NaN;
                };
                if (Double.isNaN(result)) return "Oops! Division by zero is undefined.";
                return String.format("The result of %.2f %s %.2f = %.4f", a, op, b, result);
            } catch (NumberFormatException ignored) {}
        }
        return null;
    }

    /**
     * Returns a fallback response when no intent matches.
     */
    private String getFallbackResponse(String input) {
        String[] fallbacks = {
            "Hmm, I'm not sure I understand. Could you rephrase that?",
            "Interesting question! I'm still learning. Try asking about Java, OOP, or just say 'help'.",
            "I didn't quite catch that. Can you ask in a different way?",
            "That's outside my current knowledge. Try asking about Java, internships, or say 'tell me a joke'!",
            "I'm not sure how to answer that. Type 'help' to see what I can do."
        };
        return fallbacks[(int)(Math.random() * fallbacks.length)];
    }
}
