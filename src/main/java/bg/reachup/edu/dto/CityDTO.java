package bg.reachup.edu.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class CityDTO implements Serializable {

    //TODO
    // Finish other validations
    @Min(value = 2, message = "City must be bigger than 1 char")
    @Max(value = 30, message = "Input is to big.")
    private String city;
    private String country;

    private double latitude;

    private double longitude;

    //Generated Constructor
    public CityDTO(String city, String country, double latitude, double longitude) {
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Generated getter and setters
    public CityDTO() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
