package utils;

import entities.Response;

import java.util.Comparator;

public class Utils {

    public static Comparator<Response> temperatureComparator = new Comparator<Response>() {
        @Override
        public int compare(Response o1, Response o2) {
            return o1.getTemperature().compareTo(o2.getTemperature()) ;
        }
    };

    public static  Comparator<Response> windSpeedComparator = new Comparator<Response>() {
        @Override
        public int compare(Response o1, Response o2) {
            return o1.getWindSpeed().compareTo(o2.getWindSpeed());
        }
    };

    public static Comparator<Response> cityNameComparator = new Comparator<Response>() {
        @Override
        public int compare(Response o1, Response o2) {
            return o1.getCityName().compareTo(o2.getCityName());
        }
    };
}
