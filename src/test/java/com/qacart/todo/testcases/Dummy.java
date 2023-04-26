package com.qacart.todo.testcases;

import com.github.javafaker.Faker;
import com.qacart.todo.models.User;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Dummy {

    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = "iLikeTesting";
        User user = new User(email,firstName,lastName,password);

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post("/api/v1/users/register")
        .then()
                .extract().detailedCookies().asList();

    }
}
