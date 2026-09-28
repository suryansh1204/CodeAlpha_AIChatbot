# Task 3: Artificial Intelligence Chatbot — Kira
### CodeAlpha Java Programming Internship

A Java-based AI chatbot named **Kira** that uses NLP (Natural Language Processing) techniques — including tokenization, stopword removal, and stemming — combined with a rule-based intent matching engine to hold intelligent conversations.

---

## Features
- **NLP Pipeline**: normalize → tokenize → remove stopwords → stem
- **Intent matching** with confidence scoring (threshold-based)
- **14 built-in intents**: greetings, farewell, Java Q&A, OOP, exceptions, collections, multithreading, jokes, math, CodeAlpha internship, time/date, weather, motivation, and capabilities
- **Live arithmetic evaluation**: type `5 + 3` or `100 / 4` for instant results
- **Conversation history**: type `history` to review the chat
- **Typing effect** simulation for a natural feel
- Graceful **fallback responses** when no intent matches

---

## Project Structure
```
Task3_AIChatbot/
├── src/
│   ├── NLPProcessor.java    # Normalize, tokenize, stopwords, stemmer, scoring
│   ├── Intent.java          # Intent model (name, keywords, responses)
│   ├── KnowledgeBase.java   # All 14 intents / FAQ database
│   ├── ChatEngine.java      # NLP pipeline + intent matching + math eval
│   └── AIChatbotApp.java    # Main app / console chat UI
└── README.md
```

---

## How to Compile & Run

```bash
# Compile
javac -d Task3_AIChatbot Task3_AIChatbot/src/*.java

# Run
java -cp Task3_AIChatbot AIChatbotApp
```

---

## Sample Conversation
```
  What's your name? Aryan

  KIRA: Hello, Aryan! I'm Kira, your AI assistant.
  KIRA: Type 'help' to see what I can do, or just start chatting!

  Aryan: What is Java?
  KIRA: Java is a high-level, object-oriented programming language known
        for its 'Write Once, Run Anywhere' capability...

  Aryan: 25 * 4
  KIRA: The result of 25.00 * 4.00 = 100.0000

  Aryan: tell me a joke
  KIRA: Why do Java developers wear glasses? Because they don't C#! 😄
```

---

## NLP Architecture
| Component | Description |
|-----------|-------------|
| `NLPProcessor.normalize()` | Lowercase + remove punctuation |
| `NLPProcessor.tokenize()` | Split into word tokens |
| `NLPProcessor.removeStopwords()` | Filter common English stopwords |
| `NLPProcessor.stem()` | Suffix-stripping stemmer |
| `NLPProcessor.matchScore()` | Keyword overlap scoring (0.0–1.0) |
| `ChatEngine.respond()` | Full pipeline + best-intent selection |

---

## Chat Commands
| Command | Action |
|---------|--------|
| `help` | Show chatbot capabilities |
| `history` | View conversation history |
| `clear` | Clear conversation history |
| `quit` / `bye` | Exit the chatbot |

---

## Technologies
- Java SE 17+
- Custom NLP engine (no external libraries)
- Rule-based AI with confidence scoring
- `java.util.regex` for math expression detection
