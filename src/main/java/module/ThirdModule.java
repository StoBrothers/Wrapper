package module;

import java.util.Map;

import org.apache.log4j.Logger;
import module.base.HtmlWrapper;
import module.loader.WrapperLoader;

 
/**
 * 
 * Class contains example of using this wrapper.
 * 
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
    
    public static void main(String[] args) {
        String resultString = null;
        try {
            // Get and initialization all wrappers in app  
            Map<String, HtmlWrapper> parsers = new WrapperLoader().initializationWrappers();

            resultString = new Executor().buildString(ThirdModule.INPUT_STRING,
                ThirdModule.PARAMETERS_STRINGS, parsers);
        } catch (Exception e) {
            logger.error("Fatal error occures", e);
            System.exit(1);
        }

        if (!OUTPUT_STRING.equals(resultString)) {
            ThirdModule.logger.error(" Received wrong result : " + resultString);
        }
    }
}
