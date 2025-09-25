package lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainTest {

    RequestSpecification requestSpec = given()
            .baseUri("https://postman-echo.com/");

    @Test
    public void testGETRequest() {
        given()
                .spec(requestSpec)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("get")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .contentType("application/json").body("args.foo1", equalTo("bar1"));
    }

    @Test
    public void testPOSTRowText() {
        String requestBody = "{\"test\": \"value\"}";

        given()
                .spec(requestSpec)
                .contentType("text/plain").body(requestBody)
                .when()
                .post("post")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("{\"test\": \"value\"}"));

    }

    @Test
    public void testPOSTFormData() {
        given()
                .spec(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("post")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
        ;
    }

    @Test
    public void testPUTRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("put")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPATCHRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("patch")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
        ;


    }

    @Test
    public void testDELETERequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("delete")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));

    }

}
