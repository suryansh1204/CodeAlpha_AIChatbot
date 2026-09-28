/**
 * Represents a chatbot intent with trigger keywords and possible responses.
 */
public class Intent {

    private final String   name;
    private final String[] keywords;    // trigger words/phrases
    private final String[] responses;   // possible responses (randomly chosen)

    public Intent(String name, String[] keywords, String[] responses) {
        this.name      = name;
        this.keywords  = keywords;
        this.responses = responses;
    }

    public String   getName()      { return name; }
    public String[] getKeywords()  { return keywords; }

    /**
     * Returns a random response from the response pool.
     */
    public String getResponse() {
        if (responses.length == 0) return "I'm not sure how to respond to that.";
        return responses[(int)(Math.random() * responses.length)];
    }
}
