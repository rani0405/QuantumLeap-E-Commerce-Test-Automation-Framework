package api_tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest {

    String baseUrl = "https://reqres.in/api";

    @Test
    public void testGetUsers() {
        given()
                .when().get(baseUrl + "/users?page=2")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"QA Engineer\" }";

        String response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post(baseUrl + "/users")
                .then().statusCode(201)
                .extract().asString();

        Assert.assertTrue(response.contains("John"));
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"Jane\", \"job\": \"Senior QA\" }";

        String response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().put(baseUrl + "/users/2")
                .then().statusCode(200)
                .extract().asString();

        Assert.assertTrue(response.contains("Jane"));
    }
}
