/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import javax.json.JsonObject;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;
import org.junit.Before;

/**
 *  Tests the examples of JsonBuilder
 * 
 * @author Julien Sadaoui
 */
public class JsonBuilderServletTest {
    
    private JsonBuilderServlet jsonBuilderServlet;
    
    @Before
    public void setUp() {
        jsonBuilderServlet = new JsonBuilderServlet();
    }
    
    /**
     *  Test 1: build a simple object
     */
    @Test
    public void shouldBuildASimpleObject() 
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
        JsonObject jsonObject = jsonBuilderServlet.example1();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
    
    /**
     *  Test 2: build a simple object with array
     */
    @Test
    public void shouldBuildASimpleObjectWithArray()
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        JsonObject jsonObject = jsonBuilderServlet.example2();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
    
    /**
     *  Test 3: build a simple object with array and embedded object
     */
    @Test
    public void shouldBuildASimpleObjectWithArrayAndEmbeddedObject()
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        JsonObject jsonObject = jsonBuilderServlet.example3();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
}