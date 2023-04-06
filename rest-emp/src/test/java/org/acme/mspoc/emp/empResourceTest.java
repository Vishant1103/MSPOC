package org.acme.mspoc.emp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
public class empResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .formParam("name", "Vishant")
                .formParam("title", "Intern")
                .formParam("yoj", 2023)
          .when().post("/api/create")
          .then()
             .statusCode(201)
             .body("tid", startsWith("T0"))
                .body("name", startsWith("Vishant"))
                .body("title", startsWith("Intern"));
    }
}