package smart.automation;


import Configuration.ConfigFactory.SystemConfig;
import io.restassured.http.ContentType;
import services.Translations;

import java.io.FileWriter;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Main {
    private static SystemConfig config = SystemConfig.getInstance();
    private static Translations translations = new Translations();

    public static void main(String[] args) {
        translations.Translations();
//        updateLanguageConf();

    }

    private static void updateLanguageConf(){
        ArrayList<String> listdata = new ArrayList<String>();
        // write your code here
        String url = config.getApiConfig().getBaseUrl();
        String language = config.getApiConfig().getLanguage();
        String basePath = "api/v1/"+language+"/language";

        String response =     given()
                .baseUri(url)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().asString();



//        Object array = res.get("cancel");

        try (FileWriter file = new FileWriter("src/main/resources/"+language+".json")) {
            file.write(response);
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + response);
        } catch(Exception e){
            System.out.println(e);

        }
    }

}
