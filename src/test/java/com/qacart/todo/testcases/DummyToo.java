package com.qacart.todo.testcases;

import static io.restassured.RestAssured.given;

public class DummyToo {
    public static void main(String[] args) {
        given()
                .baseUri("https://todo.qacart.com")
        .when()
                .get("/api/v1/info/lectures")
        .then()
                .log().all();
    }
}
