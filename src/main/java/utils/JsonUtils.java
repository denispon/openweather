package utils;

import entities.Request;
import entities.Response;
import org.json.simple.JSONObject;

import java.util.Date;

public class JsonUtils {

    public static Request mapJsonObjectToRequest(JSONObject jsonRequest){

        String cityName = (String) jsonRequest.get("city_name");
        Long cityId = (Long) jsonRequest.get("city_id");
        Integer frequency = (Integer) jsonRequest.get("frequency");
        Double threshold = (Double) jsonRequest.get("threshold");

        Request request = new Request(cityName, cityId, frequency, threshold );

        return  request;
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
