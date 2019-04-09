import entities.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.HttpUtils;
import utils.JsonUtils;

import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\Denis\\Desktop\\codingLab\\openweather\\src\\main\\resources\\input\\inputJsonSingle.json"));
            JSONObject jsonRequest = (JSONObject)obj;
            Request request = JsonUtils.mapJsonObjectToRequest(jsonRequest);
            HttpUtils.sendGet(request);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
         }

    }
}
