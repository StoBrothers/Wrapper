package module;

import java.util.Map;

import org.apache.log4j.Logger;

import module.base.HtmlWrapper;
import module.loader.WrapperLoader;

 
/**
 * Parse third module with example of using.
 * 
 * @author Sergey Stotskiy
 *
 */
public class ThirdModule {
    
    private static final Logger logger = Logger.getLogger(ThirdModule.class);

    
    private static final String OUTPUT_STRING = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a>";

    private static final String INPUT_STRING = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

    private static final String[] PARAMETERS_STRINGS = {
        " positions 14 through 22 → Entity", " positions 0 through 5 → Entity",
        " positions 56 through 67 → Twitter username",
        " positions 37 through 54 → Link" };
    
    private static final String etalonResultString = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a>";

    public static void main(String[] args) {
        
        // Get and initialization all wrappers in app  
        Map<String, HtmlWrapper> parsers = new WrapperLoader().initializationWrappers();
        
        // Executor 
        String resultString = new Executor().buildString(ThirdModule.INPUT_STRING,
            ThirdModule.PARAMETERS_STRINGS, parsers);

        if (!resultString.equals(etalonResultString)) {
            ThirdModule.logger.error(" Received wrong result : " + resultString);
        }
    }
}
