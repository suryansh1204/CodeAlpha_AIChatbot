import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CodeAlpha Internship — Task 3: Artificial Intelligence Chatbot
 * Console-based AI chatbot using NLP keyword extraction and rule-based intent matching.
 *
 * Features:
 *  - NLP pipeline: normalize → tokenize → stopword removal → stemming
 *  - Intent-based response matching with confidence scoring
 *  - Built-in arithmetic evaluation
 *  - Conversation history
 *  - FAQ coverage: Java, OOP, internship, jokes, motivation, etc.
 */
public class AIChatbotApp {

    private static final Scanner    scanner = new Scanner(System.in);
    private static final ChatEngine engine  = new ChatEngine();
    private static final List<String> history = new ArrayList<>();
    private static       String       userName = "User";

    public static void main(String[] args) {
        printBanner();
        greetUser();
        runChatLoop();
        scanner.close();
    }

    // ─── Setup ───────────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║          KIRA — AI Chatbot | CodeAlpha                ║");
        System.out.println("║    NLP-powered | Rule-based | Java-built               ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }

    private static void greetUser() {
        System.out.print("\n  What's your name? ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) userName = name;
        System.out.println("\n  KIRA: Hello, " + userName + "! I'm Kira, your AI assistant.");
        System.out.println("  KIRA: Type 'help' to see what I can do, or just start chatting!");
        System.out.println("  KIRA: Type 'history' to view chat history, or 'quit' to exit.\n");
    }

    // ─── Main Chat Loop ───────────────────────────────────────────────────────

    private static void runChatLoop() {
        while (true) {
            System.out.print("  " + userName + ": ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            // Special commands
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")
                    || input.equalsIgnoreCase("bye") || input.equalsIgnoreCase("goodbye")) {
                System.out.println("\n  KIRA: Goodbye, " + userName + "! Have a wonderful day! 👋");
                System.out.println("  CodeAlpha Internship Project — Task 3");
                break;
            }

            if (input.equalsIgnoreCase("history")) {
                printHistory();
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                history.clear();
                System.out.println("  KIRA: Chat history cleared!");
                continue;
            }

            // Get AI response
            String response = engine.respond(input);

            // Store in history
            history.add(userName + ": " + input);
            history.add("KIRA: " + response);

            // Display response with typing effect simulation
            System.out.print("  KIRA: ");
            printWithDelay(response);
            System.out.println();
        }
    }

    // ─── Helpers ─────────────────────────────────────────────────────────────

    private static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("  KIRA: No conversation history yet.");
            return;
        }
        System.out.println("\n  ── Conversation History ──────────────────────────────");
        for (String line : history) {
            System.out.println("  " + line);
        }
        System.out.println("  ─────────────────────────────────────────────────────\n");
    }

    /**
     * Simulates a typing effect by printing characters with a small delay.
     */
    private static void printWithDelay(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(15); } catch (InterruptedException ignored) {}
        }
        System.out.flush();
    }
}
