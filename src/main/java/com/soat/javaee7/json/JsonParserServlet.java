package com.soat.javaee7.json;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import static javax.json.stream.JsonParser.Event.START_OBJECT;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  An simple usage of Json Parser (Streaming APIs)
 *  JsonParser - Allows forward, read-only access to JSON
 *
 * @author Julien Sadaoui
 */
public class JsonParserServlet extends CommonHttpServlet {

    private static final String TITLE = "An sample usage of JsonBuilder (Streaming APIs)";
        
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":"
            + "{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},"
            + "\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        StringBuilder content = new StringBuilder();
        
        content.append("Json Example<br />");
        content.append("<pre><code>");
        content.append(json);
        content.append("</code></pre>");
        
        // part 1 : Read the lastname from an input source
        content.append("Example 1 : Read the lastname from an input source<br />");
        content.append("<br />");
        content.append("Lastname: ").append(example1(json));
        content.append("<br />");
    
        // part 1 : Read the phone number (home) from an input source. 
        content.append("Example 2 : Read the phone number (home) from an input source<br />");
        content.append("<br />");
        content.append("Phone number: ").append(example2(json));
        content.append("<br />");
        
        // part 1 : Read the lastname from an input source
        content.append("Example 2 : Read the street address from an input source<br />");
        content.append("<br />");
        content.append("Street address: ").append(example3(json));
        content.append("<br />");
        
        this.display(request, response, TITLE, content.toString());  
    }
    
    /**
     *   Read the lastname from an input source. 
     */
    public String example1(String json) 
    {
        JsonParser parser = Json.createParser(new StringReader(json));
        Event event = parser.next();    // START_OBJECT
        event = parser.next();          // KEY_NAME     (firstname)
        event = parser.next();          // VALUE_STRING
        event = parser.next();          // KEY_NAME     (lastname)
        event = parser.next();          // VALUE_STRING
        return parser.getString();
    }
    
    /**
     *   Read the phone number (home) from an input source. 
     */
    public String example2(String json)
    {
        String phoneNumber  = null;
        
        JsonParser parser = Json.createParser(new StringReader(json));
        while (parser.hasNext()) {
            
            switch (parser.next()) {
                case START_OBJECT:
                    parser.next();      // KEY_NAME
                    String key   = parser.getString();
                    parser.next();      // VALUE_STRING 
                    String value = parser.getString();
                    if (key.equals("type") && value.equals("home")) 
                    {       
                        parser.next();      // KEY_NAME (number)  
                        parser.next();      // VALUE_STRING
                        phoneNumber = parser.getString();
                    }
                    

                    break;
            }        
        }
        return phoneNumber;
    }
    
    /**
     *  Read the street address from an input source. 
     */
    public String example3(String json)
    {
        String streetAddress = null;
        String keyName       = null;
        
        JsonParser parser = Json.createParser(new StringReader(json));
        while (parser.hasNext()) {
            
            switch (parser.next()) {
                case KEY_NAME:
                    keyName = parser.getString();
                    break;
                case START_OBJECT:
                    
                    if ( (keyName != null) && (keyName.equals("address")) ) {
                        parser.next();      // KEY_NAME (streetAddress) 
                        parser.next();      // VALUE_STRING
                        streetAddress = parser.getString();
                    }
                    break;
            }        
        }
        return streetAddress;
    }
}
