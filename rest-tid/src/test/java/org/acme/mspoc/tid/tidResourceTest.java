package org.acme.mspoc.tid;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
public class tidResourceTest {

    @Test
    public void shouldGenerateTId() {
        given()
          .when().get("/api/tid")
          .then()
             .statusCode(200)
             .body("tid", startsWith("T0"))
                .body("tid", hasLength(8));
    }

}