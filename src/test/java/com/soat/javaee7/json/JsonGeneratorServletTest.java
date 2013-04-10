/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import java.io.ByteArrayOutputStream;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 *  Tests the examples of JsonGenerator
 *
 * @author Julien Sadaoui
 */
public class JsonGeneratorServletTest {
    
    private JsonGeneratorServlet jsonGeneratorServlet;
    
    @Before
    public void setUp() {
        jsonGeneratorServlet = new JsonGeneratorServlet();
    }
    
    @Test
    public void testExample1() {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        jsonGeneratorServlet.example1(baos);
        assertThat(baos.toString()).isEqualTo(expectedValue);
    }
    
    @Test
    public void testExample2() {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        jsonGeneratorServlet.example2(baos);
        assertThat(baos.toString()).isEqualTo(expectedValue);     
    }
    
    @Test
    public void testExample3() {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        jsonGeneratorServlet.example3(baos);
        assertThat(baos.toString()).isEqualTo(expectedValue); 
    }
}
