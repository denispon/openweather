package utils;
import entities.Request;
import entities.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtils {

    public static final String Q_KEY ="q";
    public static final String APPID_KEY ="APPID=f5a5a1e3fcdd904137ef21ab61f86d3d";
    public static final String AMP ="&";
    public static final String SITE_URL = "http://api.openweathermap.org/data/2.5/weather";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";


    public static String getUrlParamsAsString(Request request){

        StringBuilder sb = new StringBuilder("?" + Q_KEY + "=");

        if(request.getCityName() != null && !request.getCityName().isEmpty()){
            sb.append(request.getCityName());
        }
       return sb.append(AMP + APPID_KEY).toString();
    }

    public static HttpURLConnection getConnection(Request request) throws IOException {
        String urlWithParams = SITE_URL + getUrlParamsAsString(request);
        URL url = new URL(urlWithParams);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection;
    }

    public static Response sendGet(Request request) throws IOException, ParseException {
        HttpURLConnection connection = getConnection(request);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();

        if(responseCode != 200){
            System.out.println("Connection was not established");
            return null;
        }

        BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        StringBuffer response = new StringBuffer();
        while(in.available() > 0){
            response.append((char) in.read());
        }

        JSONObject jsonResponse = (JSONObject)new JSONParser().parse(response.toString());

        return JsonUtils.mapJsonObjectToResponse(jsonResponse);

    }
}
