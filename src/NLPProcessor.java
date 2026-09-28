import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Basic Natural Language Processing (NLP) utility.
 * Handles tokenization, stopword removal, stemming, and keyword extraction.
 */
public class NLPProcessor {

    // Common English stopwords to filter out
    private static final Set<String> STOPWORDS = new HashSet<>(Arrays.asList(
        "i", "me", "my", "we", "our", "you", "your", "he", "she", "it", "they",
        "am", "is", "are", "was", "were", "be", "been", "being",
        "have", "has", "had", "do", "does", "did", "will", "would",
        "can", "could", "shall", "should", "may", "might", "must",
        "a", "an", "the", "and", "but", "or", "if", "in", "on", "at", "to",
        "for", "of", "with", "by", "from", "up", "about", "into", "through",
        "what", "how", "when", "where", "who", "which", "why", "that", "this",
        "there", "here", "so", "then", "than", "also", "just", "very", "too",
        "please", "tell", "me", "know", "want", "like", "need", "get", "let",
        "s", "t", "don", "doesn", "isn", "aren", "wasn", "weren"
    ));

    /**
     * Normalizes text: lowercase, removes punctuation, trims whitespace.
     */
    public String normalize(String text) {
        return text.toLowerCase()
                   .replaceAll("[^a-z0-9\\s]", "")
                   .replaceAll("\\s+", " ")
                   .trim();
    }

    /**
     * Splits normalized text into tokens (words).
     */
    public String[] tokenize(String normalized) {
        return normalized.split("\\s+");
    }

    /**
     * Removes stopwords from a token array.
     */
    public String[] removeStopwords(String[] tokens) {
        return Arrays.stream(tokens)
                     .filter(t -> !STOPWORDS.contains(t) && !t.isEmpty())
                     .toArray(String[]::new);
    }

    /**
     * Simple suffix-stripping stemmer (handles common English suffixes).
     */
    public String stem(String word) {
        if (word.length() <= 3) return word;
        if (word.endsWith("ing"))   return word.substring(0, word.length() - 3);
        if (word.endsWith("tion"))  return word.substring(0, word.length() - 4);
        if (word.endsWith("ness"))  return word.substring(0, word.length() - 4);
        if (word.endsWith("ment"))  return word.substring(0, word.length() - 4);
        if (word.endsWith("able"))  return word.substring(0, word.length() - 4);
        if (word.endsWith("ed"))    return word.substring(0, word.length() - 2);
        if (word.endsWith("er"))    return word.substring(0, word.length() - 2);
        if (word.endsWith("ly"))    return word.substring(0, word.length() - 2);
        if (word.endsWith("es"))    return word.substring(0, word.length() - 2);
        if (word.endsWith("s") && word.length() > 4) return word.substring(0, word.length() - 1);
        return word;
    }

    /**
     * Full pipeline: normalize → tokenize → remove stopwords → stem.
     * Returns a set of processed keywords.
     */
    public Set<String> extractKeywords(String input) {
        String normalized      = normalize(input);
        String[] tokens        = tokenize(normalized);
        String[] filtered      = removeStopwords(tokens);
        Set<String> keywords   = new HashSet<>();
        for (String t : filtered) {
            keywords.add(stem(t));
        }
        return keywords;
    }

    /**
     * Calculates keyword overlap score between user input and a pattern set.
     * Returns a value between 0.0 and 1.0.
     */
    public double matchScore(Set<String> inputKeywords, String[] patterns) {
        if (inputKeywords.isEmpty() || patterns.length == 0) return 0.0;
        int matches = 0;
        for (String pattern : patterns) {
            String stemmed = stem(normalize(pattern));
            if (inputKeywords.contains(stemmed)) matches++;
        }
        return (double) matches / patterns.length;
    }
}
