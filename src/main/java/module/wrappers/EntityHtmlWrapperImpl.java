package module.wrappers;

import module.base.HtmlWrapper;

/**
 * Wrapper for "Entity" tag. 
 * 
 * @author Sergey Stotskiy
 *
 */
public class EntityHtmlWrapperImpl implements HtmlWrapper {

    /** Tag name for wrapping **/
    private final static String tagName = "Entity";

    /** Output formatting string **/
    private final static String formatString = "<strong>%s</strong>";

    public EntityHtmlWrapperImpl() {

    }

    @Override
    public String getTagName() {
        return tagName;
    }

    @Override
    public String wrap(String context) {
        return String.format(formatString, context);
    }
}
