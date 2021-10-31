package utils;

import Configuration.ConfigFactory.SystemConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rollingslots.api.Pojo.LoginTo;

import static io.restassured.RestAssured.given;


public class RestWrapper {
    private static final String Base_url = "https://rollingslots.gbl-systems.com/api/v1";
    private static  RequestSpecification REQ_SPEC;
    private Cookies cookies;

    private static SystemConfig config = SystemConfig.getInstance();
    private RestWrapper(String cookies){
//        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())

                .setBaseUri(Base_url)
                .setBasePath("en/account/login")
                .setContentType(ContentType.JSON)
                .build();
    }



    public static RestWrapper loginAs(String login,String password){
        JSONParser jsonParser = new JSONParser();
        String cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(Base_url)
                .basePath("en/account/login")
                .body(new LoginTo(login,password))
                .post().then().statusCode(200)
                .extract().asString();
        System.out.println(cookies);

        try{
            var translates=new JSONObject(jsonParser.parse(cookies));
            System.out.println(translates);

        }catch (ParseException e) {
            e.printStackTrace();
        }


//        System.out.println(cookies +"DDDDD");
//
        return new RestWrapper(cookies);
    }
}
