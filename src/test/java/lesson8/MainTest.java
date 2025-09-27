package lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainTest {

    RequestSpecification requestSpec = given()
            .baseUri("https://postman-echo.com/");

    @Test
    public void testGETRequest() {
        given()
                .spec(requestSpec)
                .queryParam("name1", "Ivanov")
                .queryParam("name2", "Petrov")
                .when()
                .get("get")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("args.name1", equalTo("Ivanov"))
                .and().body("args.name2", equalTo("Petrov"));
    }

    @Test
    public void testGETRequestNegative() {
        given()
                .spec(requestSpec)
                .queryParam("name1", "Ivanov")
                .queryParam("name2", "Petrov")
                .when()
                .get("post")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("args.name1", equalTo("Ivanov"))
                .and().body("args.name2", equalTo("Petrov"));
    }

    @Test
    public void testPOSTRowText() {
        String requestBody = "{\"name\": \"Ivanov\", \"phoneNum\": \"123-123\"}";

        given()
                .spec(requestSpec)
                .contentType("text/plain").body(requestBody)
                .when()
                .post("post")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("{\"name\": \"Ivanov\", \"phoneNum\": \"123-123\"}"));

    }

    @Test
    public void testPOSTFormData() {
        given()
                .spec(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name1", "Ivanov")
                .formParam("name2", "Petrov")
                .when()
                .post("post")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("form.name1", equalTo("Ivanov"))
                .and().body("form.name2", equalTo("Petrov"));
        ;
    }

    @Test
    public void testPUTRequest() {
        String requestBody = "{\"name\": \"Petrov\", \"phoneNum\": \"567-567\"}";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("put")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("{\"name\": \"Petrov\", \"phoneNum\": \"567-567\"}"));
    }

    @Test
    public void testPATCHRequest() {
        String requestBody = "{\"name\": \"Sidorov\", \"phoneNum\": \"567-567\"}";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("patch")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("{\"name\": \"Sidorov\", \"phoneNum\": \"567-567\"}"));
    }

    @Test
    public void testDELETERequest() {
        String requestBody = "{\"name\": \"Sidorov\", \"phoneNum\": \"567-567\"}";
        given()
                .spec(requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("delete")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("{\"name\": \"Sidorov\", \"phoneNum\": \"567-567\"}"));

    }

}
