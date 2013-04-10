/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *  Tests the examples of JsonReader
 * 
 * @author Julien Sadaoui
 */
public class JsonReaderServletTest {
    
    private JsonReaderServlet jsonReaderServlet;
    
    @Before
    public void setUp() {
        jsonReaderServlet = new JsonReaderServlet();
    }
    
    /**
     *  Test 1 : Read the first name from the json
     */
    @Test
    public void testExample1()
    {
         String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
         String firstName = jsonReaderServlet.example1(json);
         assertThat(firstName).isEqualTo("John");
    }

    /**
     *  Test 3 : read the phone number from the json
     */
    @Test
    public void testExample2()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        String phoneNumber = jsonReaderServlet.example2(json);
        assertThat(phoneNumber).isEqualTo("212 555-1234");
    }
    
    /**
     *  Test 3 : read the phone type from the json
     */
    @Test
    public void testExample3()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        String phoneNumber = jsonReaderServlet.example3(json);
        assertThat(phoneNumber).isEqualTo("home");
    }
    
    /**
     *  Test 4 : Read the street address from the json
     */
    @Test
    public void testExample4()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"}}";
        String streetAddress = jsonReaderServlet.example4(json);
        assertThat(streetAddress).isEqualTo("21 2nd Street");
    }
}
