package entities;

public class Request {

    private String cityName;
    private Long cityId;
    private Integer frequency;
    private Double threshold;

    public Request(String cityName, Long cityId, Integer frequency, Double threshold) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.frequency = frequency;
        this.threshold = threshold;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }



}
