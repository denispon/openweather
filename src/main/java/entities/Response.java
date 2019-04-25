package entities;

import java.util.Date;

public class Response {

    private String cityName;

    private Double temperature;

    private Double windSpeed;

    private Date date;

    public Response(String cityName, Double temperature, Double windSpeed, Date date) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Response{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", date=" + date +
                '}';
    }
}
