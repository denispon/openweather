import entities.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.HttpUtils;
import utils.JsonUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

    private static Request singleRequest = null;
    private static List<Request> requests = new ArrayList<>();

    @BeforeClass
    public static void createRequest(){

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\Denis\\Desktop\\codingLab\\openweather\\src\\main\\resources\\input\\inputJsonSingle.json"));
            JSONObject jsonRequest = (JSONObject)obj;
            singleRequest = JsonUtils.mapJsonObjectToRequest(jsonRequest);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testConnection() throws IOException {
        HttpURLConnection connection = HttpUtils.getConnection(singleRequest);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", HttpUtils.USER_AGENT);
        try {
            int responseCode = connection.getResponseCode();
            assertEquals(responseCode, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
