package module;

/**
 * 
 * 
 * @author Sergey Stotskiy
 *
 */
public interface Tag {

    public String getTagName();

    public void setTagName(String tagName);

    public int getStartPosition();

    public void setStartPosition(int startPosition);

    public int getEndPosition();

    public void setEndPosition(int endPosition);
}
