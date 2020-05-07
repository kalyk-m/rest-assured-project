package com.app.tests;

import com.app.pojos.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

public class PojoExamples {

    @Test
    public void testGson(){
        Person person = new Person();

        person.setName("Daniel");
        person.setSurname("Jackson");
        person.setGender("male");
        person.setRegion("Earth");
        System.out.println("printing the person object: " + person);

        // TODO serialization
        Gson gson = new Gson();
        String jsonString = gson.toJson(person);
        System.out.println("printing the json: " + jsonString);

        // TODO deserialization
        String myJsonString =     "{\"name\":\"Daniel\"," +
                                "\"surname\":\"Jackson\"," +
                                "\"gender\":\"male\"," +
                                "\"region\":\"Earth\"}";
        Person myPerson = gson.fromJson(myJsonString, Person.class);
        System.out.println("Printing the new person object: "+ myPerson);
    }

    @Test
    public void testJackson() throws JsonProcessingException {
        Person person = new Person();

        person.setName("Daniel");
        person.setSurname("Jackson");
        person.setGender("male");
        person.setRegion("Earth");
        System.out.println("printing the person object: " + person);

        // TODO serialization
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("printing the jsonString: " + json);

        // TODO deserialization
        String myJsonString =     "{\"name\":\"Daniel\"," +
                "\"surname\":\"Jackson\"," +
                "\"gender\":\"male\"," +
                "\"region\":\"Earth\"}";
        Person myPerson = objectMapper.readValue(myJsonString, Person.class);
        System.out.println("Printing the new person object: "+ myPerson);
    }

    @Test
    public void jacksonVsGson() throws JsonProcessingException {
        Person person = new Person();

        person.setName("Daniel");
        person.setSurname("Jackson");

        Gson gson = new Gson();
        String j1 = gson.toJson(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String j2 = objectMapper.writeValueAsString(person);

        System.out.println(j1);
    //{"name":"Daniel","surname":"Jackson"}
        System.out.println(j2);
    //{"name":"Daniel","surname":"Jackson","gender":null,"region":null}

    }
}
