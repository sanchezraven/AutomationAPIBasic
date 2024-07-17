package tests;

import io.restassured.http.ContentType;
import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static specs.LoginSpecs.loginRequestSpec;
import static specs.LoginSpecs.loginResponseSpec;

public class RegExtendedTest {
    @Test
    void loginTest() {
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");


        LoginResponseModel response = given(loginRequestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginResponseModel.class);

        Assertions.assertEquals(response.getToken(), "QpwL5tke4Pnpja7X4");
    }
}
