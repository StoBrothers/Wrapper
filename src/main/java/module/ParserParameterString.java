package module;

import org.apache.log4j.Logger;

/**
 * Parse one string with parameters for wrapping process.
 *    
 * @author Sergey Stotskiy
 *
 */

public class ParserParameterString {
    
    Logger logger = Logger.getLogger(ParserParameterString.class);
    
    private static final String DIRECTION_STR = " → ";

    private static final int DIRECTION_LENGTH = DIRECTION_STR.length();
    
    private static final String  POSITIONS = "positions";  

    private static final int START_POSITIONS = POSITIONS.length();

    private static final String  THROUGH = "through"; 

    private static final int START_THROUGH = THROUGH.length();
    
    
    /**
     * Parse string to ValueTag object. 
     * @param parameter input parameters string
     * @return wrapping parameters 
     * @throws Exception 
     */
    public Tag parseString (String parameter) throws Exception {
        
        logger.info(String.format("Parse parameter string: %s ", parameter));

        int startTypeOfTag, startPositions, startThrough;

        //check substring with type of tag 
        if ((startTypeOfTag = parameter.lastIndexOf(DIRECTION_STR)) == -1) {
            logger.error("Parameters are not contains tag.");
            throw new Exception("Parameter tag is not valid");
        }
        //check substring with position parameter
        if ((startPositions = parameter.indexOf(POSITIONS)) == -1) {
            logger.error("Parameters are not contains start position.");
            throw new Exception("Parameter startPositions is not valid");
        }

        //check substring with through parameter
        if ((startThrough = parameter.indexOf(THROUGH, startPositions)) == -1) {
            logger.error("Parameters are not contains end position.");
            throw new Exception("Parameter endPositions is not valid");
        }
        // Get name tag 
        String nameTag  = parameter.substring(startTypeOfTag + DIRECTION_LENGTH);
        
        if ((nameTag == null) || (nameTag.length() == 0)) {
            logger.error("Parameters are not contains tag.");
            throw new Exception("Parameter tag is not valid");
        }
        
        // Get value "positions" 
        String positions = parameter.substring(startPositions + START_POSITIONS, startThrough);

        String through = parameter.substring(startThrough + START_THROUGH, startTypeOfTag);

        Integer position_int, through_int;
        try {
         position_int = Integer.parseInt(positions.trim());
         through_int = Integer.parseInt(through.trim());
        } catch (NumberFormatException nfe) {
            logger.error("Postions are not parsed.", nfe);
            throw nfe;
        }
        
        if (position_int == null || through_int == null) {
            logger.error("Postions are not parsed.");
            throw new Exception("Parameters positions are not valid");
        }
        
        Tag value = new ValueTag(position_int.intValue(), through_int.intValue(), nameTag.trim());
        
        return value;
    }

}
