package steps;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import rollingslots.api.Pojo.LoginRes;
import rollingslots.api.Pojo.LoginTo;

import static io.restassured.RestAssured.given;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class steps {
    public void login() {

    }

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .addFilter(new AllureRestAssured())
                    .setBaseUri("")
                    .setBasePath("api/v1/en/account/login")
                    .setContentType(ContentType.JSON)
                    .build();


    public static String loginResponse() {
        LoginTo rq = new LoginTo().builder()
                .login("test25@gmail.com")
                .password("123123123")
                .build();

        return given().spec(REQ_SPEC)
                .body(rq).when()
                .post()
                .then().statusCode(200)
                .extract().asString();
    }
}

//LoginRes