/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import javax.json.JsonObject;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

/**
 *  Tests for JsonBuilder API
 * 
 * @author Julien Sadaoui
 */
public class JsonBuilderExampleTest {
    
    @Test
    public void jsonSimpleObject() 
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
        JsonObject jsonObject = JsonBuilderExample.buildJsonObject();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
    
    @Test
    public void jsonObjectWithArray()
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        JsonObject jsonObject = JsonBuilderExample.buildJsonObjectWithArray();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
    
    @Test
    public void jsonObjectWithArrayAndEmbeddedObject()
    {
        String expectedValue = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        JsonObject jsonObject = JsonBuilderExample.buildJsonObjectWithArrayAndEmbeddedObject();
        assertThat(jsonObject.toString()).isEqualTo(expectedValue);
    }
}