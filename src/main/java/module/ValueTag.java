package module;

/**
 * Parsed information about wrapping one string. 
 * 
 * @author Sergey Stotskiy
 *
 */
public class ValueTag implements Tag {
    /**
     * Start position in context
     */
    private int startPosition;
    /**
     * End position in context
     */
    private int endPosition;
    /**
     * Unique tagName for execution
     */
    private String tagName;

    public ValueTag(int startPosition, int endPosition, String tagName) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public String toString() {
        return " startPosition: " + this.startPosition + " endPosition: " + this.endPosition
            + " plugin name: " + this.tagName;
    }
}
