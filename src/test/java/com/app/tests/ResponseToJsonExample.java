package com.app.tests;

import com.app.pojos.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ResponseToJsonExample {
    @Test
    public void test() throws JsonProcessingException {
        Response response = given().get("https://swapi.dev/api/people/1/");

        // Using RestAssure

        Person p1 = response.as(Person.class);
//        System.out.println("p1: " + p1);
        System.out.println("p1.getName: " + p1.getName());

        // Using GSON
        Gson gson = new Gson();
        Person p2 = gson.fromJson(response.asString(), Person.class);
        System.out.println("p2: " + p2);

        //Using Jackson DATABIND
        ObjectMapper objectMapper = new ObjectMapper();
        Person p3 = objectMapper.readValue(response.asString(), Person.class);
        System.out.println("p3: " + p3);

    }
}
