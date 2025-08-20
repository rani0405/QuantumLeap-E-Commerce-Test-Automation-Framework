package api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApiTest {
	@Test
	public void testGetUser() {
		RestAssured.baseURI="https://reqres.in/api";
		Response response = given()
                .when()
                .get("/users/2")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
	}
}
