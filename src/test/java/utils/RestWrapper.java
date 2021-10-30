package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import rollingslots.api.Pojo.LoginTo;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String Base_url = "";
    private static  RequestSpecification REQ_SPEC;
    private Cookies cookies;

    private RestWrapper(Cookies cookies){
        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .addCookies(cookies)
                .setBaseUri(Base_url)
                .setBasePath("en/account/login")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RestWrapper loginAs(String login,String password){
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(Base_url)
                .basePath("en/account/login")
                .body(new LoginTo(login,password))
                .post()
                .getDetailedCookies();

        System.out.println(cookies +"DDDDD");

        return new RestWrapper(cookies);
    }
}
