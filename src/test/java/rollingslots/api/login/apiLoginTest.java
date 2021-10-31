package rollingslots.api.login;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RestWrapper;

public class apiLoginTest {


    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("test25@gmail.com","123123123");
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

//        steps res = new steps();
//        System.out.println( res.loginResponse());
    }

}
