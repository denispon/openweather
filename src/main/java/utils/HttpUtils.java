package utils;
import entities.Request;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtils {

    private static final String Q_KEY ="q";
    private static final String APPID_KEY ="APPID=f5a5a1e3fcdd904137ef21ab61f86d3d";
    private static final String AMP ="&";
    private static final String SITE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";


    public static String getUrlParamsAsString(Request request){

        StringBuilder sb = new StringBuilder("?" + Q_KEY + "=");

        if(request.getCityName() != null && !request.getCityName().isEmpty()){
            sb.append(request.getCityName());
        }
       return sb.append(AMP + APPID_KEY).toString();
    }

    public static void sendGet(Request request) throws IOException {
        String urlWithParams = SITE_URL + getUrlParamsAsString(request);
        URL url = new URL(urlWithParams);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + urlWithParams);
        System.out.println("Response Code : " + responseCode);
    }
}
