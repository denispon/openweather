package utils;

import entities.Request;
import entities.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JsonUtils {

    public static Request mapJsonObjectToRequest(JSONObject jsonRequest){

        String cityName = (String) jsonRequest.get("city_name");
        Long cityId = (Long) jsonRequest.get("city_id");
        Integer frequency = new Integer(jsonRequest.get("frequency").toString());
        Double threshold = new Double( jsonRequest.get("threshold").toString());

        Request request = new Request(cityName, cityId, frequency, threshold );

        return  request;
    }

    public static List<Request> createRequests(String filePath){
        List<Request> requests = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {

            JSONArray jsonArray =(JSONArray) parser.parse(new FileReader(filePath));

            Iterator<JSONObject> iter = jsonArray.iterator();

            while(iter.hasNext()){
                JSONObject jsonObject = iter.next();
                Request request = JsonUtils.mapJsonObjectToRequest(jsonObject);
                requests.add(request);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }finally {
            return requests;
        }
    }

    public static Response mapJsonObjectToResponse(JSONObject jsonResponse){

      String cityName = (String) jsonResponse.get("name");
      Double temperature = (Double) ((JSONObject)jsonResponse.get("main")).get("temp");
      Double windSpeed = (Double) ((JSONObject)jsonResponse.get("wind")).get("speed");
      Long dateLong = (Long) jsonResponse.get("dt");
      Date date = new Date(dateLong);

      Response response = new Response(cityName, temperature, windSpeed, date);

      return response;
    }
}
