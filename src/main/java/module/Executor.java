package module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;

import module.base.HtmlWrapper;

/**
 * Parse and wrap input string. 
 * 
 * @author Sergey Stotskiy
 *
 */

public class Executor {
    
    Logger logger = Logger.getLogger(Executor.class);

    public String buildString(String inputString, String[] positions,
        Map<String, HtmlWrapper> parsers) {

        ParserParameterString parser = new ParserParameterString();

        ArrayList<Tag> tagList = buildParametersList(positions, parser);

        char[] result = inputString.toCharArray();

        StringBuilder resultBuilder = new StringBuilder();

        HtmlWrapper currentWrapper = null;
        int startPosition = 0;// work position in input string

        for (Tag val : tagList) {
            // if existed text before this formated text that need copy this text to result string
            if (startPosition != val.getStartPosition()) {
                resultBuilder.append(
                    Arrays.copyOfRange(result, startPosition, val.getStartPosition()));
            }

            // Get string for wrapping over parameters of wrapping
            String token = String.valueOf(
                Arrays.copyOfRange(result, val.getStartPosition(), val.getEndPosition()));

            startPosition = val.getEndPosition(); // update start position for next token

            if ((currentWrapper = parsers.get(val.getTagName())) != null) {
                resultBuilder.append(currentWrapper.wrap(token));// add wrapped string
            }
        }

        // copy tail of string after last wrapping if tail is existed
        if (startPosition != result.length) {
            resultBuilder
                .append(Arrays.copyOfRange(result, startPosition, result.length));
        }
        
        logger.info("Result : " + resultBuilder.toString());
        return resultBuilder.toString();
    }

    /**
     * Build list with parse parameters.
     * @param positions 
     * @param parser
     * @return
     */
    private ArrayList<Tag> buildParametersList(String[] positions,
        ParserParameterString parser) {
        
        // Storage of Value Tag entity with name of tag and parameters for executing
        // After fulfilling this list it will be sorted
        ArrayList<Tag> tagList = new ArrayList<>();
        
         // Parse string with parameters to execute and add to list
        for (String parameter : positions) {
            Tag parseString = parser.parseString(parameter);
            if (parseString != null) {
            tagList.add(parseString);
            }
        }
        // sort by start position
        tagList.sort ((o1, o2)-> o1.getStartPosition()- o2.getStartPosition());
        return tagList;
    }
}
