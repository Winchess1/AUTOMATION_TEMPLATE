package services;

import Configuration.ConfigFactory.SystemConfig;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Translations {
    private static SystemConfig config = SystemConfig.getInstance();
    JSONParser jsonParser = new JSONParser();
    private JSONObject translates;
    public JSONObject Translations(){
        System.out.println(translates);
        if(translates == null){
            try (FileReader reader = new FileReader("src/main/resources/"+config.getApiConfig().getLanguage()+".json"))
            {
                translates=new JSONObject(jsonParser.parse(reader).toString());
                System.out.println("REPSONSE\t"+translates);
                return translates;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

    return translates;
    }

}
