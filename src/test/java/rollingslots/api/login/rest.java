package rollingslots.api.login;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rollingslots.api.Pojo.LoginTo;
import steps.steps;
import utils.RestWrapper;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class rest {


    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("","");
    }

    @Test
    public void loginGet(){
//       given()
//                .baseUri("")
//                .basePath("api/v1/en/model/level?fields=alias,level_name,level_color,image,exchange_rate&page=1&limit=100")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("data.find{it.alias == '1'}.level_color",equalTo("vinyl"));

//     List<steps> level =  given()
//                .baseUri("")
//                .basePath("api/v1/en/model/level?fields=alias,level_name,level_color,image,exchange_rate&page=1&limit=100")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .extract().jsonPath().getList("data",steps.class);
//
//     assertThat(level).extracting(steps::getLevel_name).contains("Level 1 ");

//         given()
//                .baseUri("")
//                .basePath("api/v1/en/model/level?fields=alias,level_name,level_color,image,exchange_rate&page=1&limit=100")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("data[0].alias",equalTo("1"));

//        System.out.println(level);
    }
@Test
@Step("Login API")
@DisplayName("Login Name Api")
    public void LoginPost(){
        steps res = new steps();
        System.out.println( res.loginResponse());
    }

}
