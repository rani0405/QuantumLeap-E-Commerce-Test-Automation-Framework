package api_tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {

    @BeforeClass
    public void setup() {
        // Base URI for ReqRes API
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
