package module.base;
/**
 * General interface for every wrapper.
 * 
 * @author Sergey Stotskiy
 *
 */

public interface HtmlWrapper {
        
        /**
         * Get registered Tag name of Wrapper
         * @return
         */
        String getTagName();
        
        /**
         * 
         * @param context - full input string
         * @return new wrapped token
         */
        String wrap (String context);
    
}
