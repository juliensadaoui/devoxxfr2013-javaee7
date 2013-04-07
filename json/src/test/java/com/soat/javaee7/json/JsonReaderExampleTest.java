/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

/**
 *  Tests the examples of JsonReader
 * 
 * @author Julien Sadaoui
 */
public class JsonReaderExampleTest {
    
    @Test
    public void readLastName()
    {
         String jsonText = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25}";
         String firstName = JsonReaderExample.readFirstName(jsonText);
         assertThat(firstName).isEqualTo("John");
    }
    
    @Test
    public void readPhoneNumber()
    {
        String jsonText = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        String phoneNumber = JsonReaderExample.readPhoneNumber(jsonText);
        assertThat(phoneNumber).isEqualTo("212 555-1234");
    }
    
    @Test
    public void readPhoneTyoe()
    {
        String jsonText = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":28,\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        String phoneNumber = JsonReaderExample.readPhoneType(jsonText);
        assertThat(phoneNumber).isEqualTo("home");
    }
    
    @Test
    public void readStreetAddress()
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"}}";
        String streetAddress = JsonReaderExample.readStreetAddress(json);
        assertThat(streetAddress).isEqualTo("21 2nd Street");
    }
}
