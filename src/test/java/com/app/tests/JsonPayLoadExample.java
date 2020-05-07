package com.app.tests;

import com.app.pojos.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class JsonPayLoadExample {

    @Test
    public void payloadTest() throws Exception {

        Instructor instructor = new Instructor();

        String firstName = new Faker().name().firstName();

        String lastName=new Faker().name().lastName();
        int batch=new Random().nextInt(20)+1;
        String subject=new Faker().educator().course();

        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setBatch(batch);
        instructor.setSubject(subject);

        RestAssured.baseURI="http://cybertekchicago.com/";
        Response postResponse = given().
                contentType(ContentType.JSON).
                body(instructor).
                when().post("instructor/create");

        postResponse.then().log().all();


//        int id=postResponse.path("id");
//        Response getResponse=RestAssured.given().pathParam("id", id).when().get("/instructor/{id}");
//        getResponse.then().log().all().statusCode(200);
//
//        Instructor instructor2=new ObjectMapper().readValue(getResponse.asString(), Instructor.class);
//        System.out.println("instructor First name: "+instructor2.getFirstName());
//        System.out.println("instructor First name: "+instructor2.getLastName());
//        System.out.println("instructor First name: "+instructor2.getBatch());
//        System.out.println("instructor First name: "+instructor2.getId());
//        System.out.println("instructor First name: "+instructor2.getSubject());
//
//        assertThat(instructor2.getFirstName(), is(instructor.getFirstName()));
//        assertThat(instructor2.getLastName(),is(instructor.getLastName()));
//        assertThat(instructor2.getBatch(),is(instructor.getBatch()));
//        assertThat(instructor2.getSubject(),is(instructor.getSubject()));
    }
}
