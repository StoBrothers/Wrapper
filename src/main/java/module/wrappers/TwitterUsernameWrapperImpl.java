package module.wrappers;

import module.base.HtmlWrapper;

/**
 * Wrapper for "Twitter username" tag.
 * 
 * @author Sergey Stotskiy
 *
 */
public class TwitterUsernameWrapperImpl implements HtmlWrapper {

    /** Tag name for execution **/
    private final static String tagName = "Twitter username";
    
    /** Formatter string **/
    private final static String formatString = "<a href=\"http://twitter.com/%s\">%s</a>";
    
    @Override
    public String wrap(String context) {
        return String.format(formatString, context, context);
    }

    @Override
    public String getTagName() {
        return tagName;
    }
}
