import java.util.ArrayList;
import java.util.List;

/**
 * Stores all chatbot intents (rule-based knowledge base).
 * Each intent maps keywords to canned responses, covering common FAQ topics.
 */
public class KnowledgeBase {

    private final List<Intent> intents = new ArrayList<>();

    public KnowledgeBase() {
        loadIntents();
    }

    private void loadIntents() {

        // ── Greetings ────────────────────────────────────────────────────────
        intents.add(new Intent("greeting",
            new String[]{"hello", "hi", "hey", "howdy", "greetings", "good morning",
                         "good afternoon", "good evening", "what's up", "sup"},
            new String[]{
                "Hello! How can I help you today?",
                "Hi there! What can I do for you?",
                "Hey! I'm your AI assistant. What's on your mind?",
                "Greetings! How may I assist you?"
            }
        ));

        // ── Farewell ─────────────────────────────────────────────────────────
        intents.add(new Intent("farewell",
            new String[]{"bye", "goodbye", "see you", "later", "exit", "quit", "farewell", "take care"},
            new String[]{
                "Goodbye! Have a great day!",
                "See you later! Take care!",
                "Bye! Feel free to come back anytime.",
                "Farewell! It was nice chatting with you."
            }
        ));

        // ── Thanks ───────────────────────────────────────────────────────────
        intents.add(new Intent("thanks",
            new String[]{"thank", "thanks", "thank you", "appreciate", "grateful"},
            new String[]{
                "You're welcome! Happy to help.",
                "My pleasure! Let me know if you need anything else.",
                "Anytime! That's what I'm here for.",
                "Glad I could help!"
            }
        ));

        // ── Bot Identity ─────────────────────────────────────────────────────
        intents.add(new Intent("identity",
            new String[]{"who are you", "what are you", "your name", "introduce", "about you", "what is your name"},
            new String[]{
                "I'm Kira, an AI chatbot built for the CodeAlpha Java Internship! I use NLP techniques to understand your questions.",
                "My name is Kira — a rule-based AI chatbot developed in Java using NLP processing.",
                "I'm Kira, your intelligent Java-powered assistant!"
            }
        ));

        // ── Capabilities ─────────────────────────────────────────────────────
        intents.add(new Intent("capabilities",
            new String[]{"what can you do", "help", "capabilities", "features", "how can you help", "commands"},
            new String[]{
                "I can answer questions about Java, programming, CodeAlpha internship, weather info, jokes, and general FAQs. Just ask!",
                "I'm here to help with: Java questions, programming tips, internship FAQs, jokes, math, and general knowledge.",
                "Try asking me about Java, coding tips, or just say 'tell me a joke'!"
            }
        ));

        // ── Java Programming ─────────────────────────────────────────────────
        intents.add(new Intent("java_basics",
            new String[]{"java", "what is java", "java programming", "java language", "learn java"},
            new String[]{
                "Java is a high-level, object-oriented programming language known for its 'Write Once, Run Anywhere' capability. It's widely used in enterprise applications, Android development, and backend systems.",
                "Java was created by James Gosling at Sun Microsystems (now Oracle) in 1995. It's strongly typed, platform-independent, and uses a JVM to run bytecode.",
                "Java is one of the most popular programming languages in the world! It's great for backend APIs, mobile apps (Android), and enterprise software."
            }
        ));

        intents.add(new Intent("oop",
            new String[]{"oop", "object oriented", "class", "object", "inheritance", "polymorphism", "encapsulation", "abstraction"},
            new String[]{
                "OOP (Object-Oriented Programming) is based on 4 pillars: Encapsulation, Abstraction, Inheritance, and Polymorphism. Java is fully OOP!",
                "In OOP, everything is modeled as objects with state (fields) and behavior (methods). Java classes are blueprints for objects.",
                "Inheritance lets a class extend another. Polymorphism allows one interface to be used for different types. These are core OOP concepts in Java!"
            }
        ));

        intents.add(new Intent("exception_handling",
            new String[]{"exception", "try catch", "error handling", "throw", "finally", "runtime error"},
            new String[]{
                "In Java, exceptions are handled using try-catch-finally blocks. Use 'throw' to manually throw exceptions and 'throws' in method signatures.",
                "Java has checked (must be handled) and unchecked (RuntimeException) exceptions. Always handle exceptions gracefully!",
                "The try-catch block: try { risky code } catch (Exception e) { handle it } finally { always runs }."
            }
        ));

        intents.add(new Intent("collections",
            new String[]{"arraylist", "list", "hashmap", "map", "set", "collections", "linkedlist", "queue", "stack"},
            new String[]{
                "Java Collections Framework provides ArrayList, LinkedList, HashMap, HashSet, and more. ArrayList is a resizable array; HashMap is a key-value store.",
                "Use ArrayList for ordered lists, HashSet for unique elements, and HashMap for key-value pairs. They're all part of java.util!",
                "Collections in Java: List (ordered), Set (unique), Map (key-value). The most used are ArrayList and HashMap."
            }
        ));

        intents.add(new Intent("multithreading",
            new String[]{"thread", "multithreading", "concurrency", "runnable", "synchronized", "parallel"},
            new String[]{
                "Java supports multithreading via the Thread class and Runnable interface. Use synchronized blocks to avoid race conditions.",
                "Multithreading allows multiple threads to run concurrently. Java's java.util.concurrent package provides advanced tools like ExecutorService.",
                "Thread lifecycle: New → Runnable → Running → Blocked/Waiting → Terminated. Use Thread.start() to begin execution."
            }
        ));

        // ── Math Questions ───────────────────────────────────────────────────
        intents.add(new Intent("math",
            new String[]{"calculate", "math", "addition", "subtract", "multiply", "divide", "square root", "power"},
            new String[]{
                "I can do basic math! Try: '5 + 3', '10 * 4', '100 / 5'. Or ask me for a specific calculation.",
                "Math in Java uses standard operators: +, -, *, /, %. For advanced math, Java's Math class provides sqrt(), pow(), abs(), and more.",
                "The Java Math class has useful methods: Math.sqrt(16) = 4.0, Math.pow(2,10) = 1024.0, Math.abs(-5) = 5."
            }
        ));

        // ── Jokes ────────────────────────────────────────────────────────────
        intents.add(new Intent("joke",
            new String[]{"joke", "funny", "laugh", "humor", "tell me a joke", "make me laugh"},
            new String[]{
                "Why do Java developers wear glasses? Because they don't C#! 😄",
                "A SQL query walks into a bar, walks up to two tables and asks... 'Can I join you?' 😂",
                "Why did the programmer quit? Because they didn't get arrays! 🤣",
                "How many programmers does it take to change a light bulb? None — that's a hardware problem! 💡",
                "Why do programmers prefer dark mode? Because light attracts bugs! 🐛"
            }
        ));

        // ── CodeAlpha Internship ─────────────────────────────────────────────
        intents.add(new Intent("internship",
            new String[]{"codealpha", "internship", "certificate", "task", "project", "submission", "linkedin"},
            new String[]{
                "CodeAlpha is a leading software company offering Java internships! You need to complete 2–3 tasks to earn your certificate.",
                "To complete the CodeAlpha internship: complete 2–3 tasks, upload to GitHub (named CodeAlpha_ProjectName), post on LinkedIn, and submit via the form.",
                "The CodeAlpha Java internship covers: Student Grade Tracker, Stock Trading Platform, AI Chatbot, and Hotel Reservation System. Pick 2–3!"
            }
        ));

        // ── Time/Date ────────────────────────────────────────────────────────
        intents.add(new Intent("time",
            new String[]{"time", "what time", "date", "today", "day", "current time"},
            new String[]{
                "I don't have real-time access, but Java's LocalDateTime.now() gives you the current date and time!",
                "For current time in Java: LocalDateTime now = LocalDateTime.now(); System.out.println(now);",
                "Java's java.time package (Java 8+) makes date/time handling very easy! Try LocalDate.now() or LocalTime.now()."
            }
        ));

        // ── Weather ──────────────────────────────────────────────────────────
        intents.add(new Intent("weather",
            new String[]{"weather", "temperature", "forecast", "rain", "sunny", "cloudy", "climate"},
            new String[]{
                "I don't have real-time weather data, but you can fetch it using a weather API like OpenWeatherMap with Java's HttpClient!",
                "To get weather in Java: use HttpClient to call a REST API like OpenWeatherMap, then parse the JSON response with a library like Gson.",
                "I wish I could check the weather for you! Try integrating OpenWeatherMap API — it's free and works great with Java."
            }
        ));

        // ── Positive / Motivation ─────────────────────────────────────────────
        intents.add(new Intent("motivation",
            new String[]{"motivate", "inspire", "quote", "encourage", "motivation", "feeling down", "stressed"},
            new String[]{
                "Keep going! Every expert was once a beginner. Your Java skills are growing with every line of code! 💪",
                "\"The best way to predict the future is to create it.\" — Keep coding and building! 🚀",
                "Programming is hard, but every bug you fix makes you a better developer. You've got this! ✨",
                "\"Code is like humor. When you have to explain it, it's bad.\" — Write clean code and keep improving!"
            }
        ));
    }

    public List<Intent> getIntents() {
        return intents;
    }
}
