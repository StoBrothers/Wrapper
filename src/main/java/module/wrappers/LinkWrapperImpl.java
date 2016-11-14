package module.wrappers;

import module.base.HtmlWrapper;

/**
 * Wrapper for "Link" tag.
 * 
 * @author Sergey Stotskiy
 *
 */
public class LinkWrapperImpl implements HtmlWrapper {

    /** Tag name for execution **/
    private final static String tagName = "Link";
    
    /** Formatter string **/
    private final static String formatString = "<a href=\"%s\">%s</a>";

    @Override
    public String wrap(String context) {
        return String.format(formatString, context, context);
    }

    @Override
    public String getTagName() {
        return tagName;
    }
}
