import entities.Request;
import entities.Response;
import services.MessageSender;
import utils.JsonUtils;
import utils.Utils;

import java.util.*;

public class App {

    public static void main(String[] args){

        List<Request> requests = JsonUtils.createRequests("C:\\Users\\Denis\\Desktop\\codingLab\\openweather\\src\\main\\resources\\input\\inputJson.json");

        List<MessageSender> messageSenders = new ArrayList<>();
        int i = 0;
        for(Request request : requests){
            messageSenders.add(new MessageSender(request, "sender " + i++));

        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(MessageSender sender: messageSenders){
            sender.stopSafely();
        }

        Map<String, List<Response>> responseMap = new HashMap<>();
        List<Response> responses = new ArrayList<>();
        for (MessageSender sender : messageSenders){
            responseMap.put(sender.getSenderName(), sender.getResponses());
            responses.addAll(sender.getResponses());
        }


        Collections.sort(responses, Utils.cityNameComparator);
        System.out.println("Sorted by city names");

        for(Response response : responses){
            System.out.println(response);
        }

        System.out.println("#######################################################################");

        Collections.sort(responses, Utils.temperatureComparator);
        System.out.println("Sorted by temperature");

        for(Response response : responses){
            System.out.println(response);
        }


        /*for(String workerName : responseMap.keySet()){
            System.out.println(workerName + " :");
            for(Response response : responseMap.get(workerName)){
                System.out.println(response.toString());
                System.out.println("----------------------------------------------------------------------------");
            }
            System.out.println("###################################################################################");
        }*/


    }
}
