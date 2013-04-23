/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Before;

/**
 *  Tests the examples of JsonParser
 * 
 * @author Julien Sadaoui
 */
public class JsonParserServletTest {
    
    private JsonParserServlet jsonParserServlet;
    
    @Before
    public void setUp() {
        jsonParserServlet = new JsonParserServlet();
    }
    
    /**
     *  Test 1 : Read the last name from an input source. 
     */
    @Test
    public void shouldGetLastname() 
    {
        // create a JsonReader
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
        String lastName = jsonParserServlet.example1(json);
        assertThat(lastName).isEqualTo("Smith");
    }

    /**
     *  Test 2 : Read the phone number "212 555-1234" from an input source. 
     */
    @Test
    public void shouldGetPhoneNumber()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        String phoneNumber = jsonParserServlet.example2(json);
        assertThat(phoneNumber).isEqualTo("212 555-1234");
    }
    
    /**
     *  Test 3 : Read the street address from an input source. 
     */
    @Test
    public void shouldGetStreetAddress()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"}}";
        String streetAddress = jsonParserServlet.example3(json);
        assertThat(streetAddress).isEqualTo("21 2nd Street");
    }
}
