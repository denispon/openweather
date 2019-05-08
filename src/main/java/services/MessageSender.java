package services;

import entities.Request;
import entities.Response;
import org.json.simple.parser.ParseException;
import utils.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageSender implements Runnable {
    private int numOfRequests = 0;
    private String senderName;
    private Request request;
    private List<Response> responses = new ArrayList<>();
    private Thread worker;


    public MessageSender(Request request, String senderName) {
        this.request = request;
        this.senderName = senderName;
        this.worker = new Thread(this,senderName);
        this.worker.start();
    }


    public void stopSafely(){
        while(this.worker.getState()== Thread.State.RUNNABLE){

        }
        this.worker.interrupt();
    }

    @Override
    public void run() {
        System.out.println("Sending request for weather cast in  " + request.getCityName() +"  - START "+Thread.currentThread().getName());

        Integer frequency = this.request.getFrequency();

        while(!this.worker.isInterrupted()) {
            try {
                Response response = HttpUtils.sendGet(request);
                responses.add(response);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            try {
                this.worker.sleep(frequency * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Receiving response for weather cast in  " + request.getCityName() +" - END "+Thread.currentThread().getName());

    }

    public List<Response> getResponses() {
        return responses;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

}
