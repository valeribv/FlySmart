package bg.reachup.edu.dto;

import java.io.Serializable;

public class AirportDTO implements Serializable {
    private double latitude;
    private double longitude;
    private String airportCode;
    private String airportName;

    //Generated Constructor
    public AirportDTO(long id, double latitude, double longitude, String airportCode, String airportName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.airportCode = airportCode;
        this.airportName = airportName;
    }

    //Generated getter and setters
    public AirportDTO() {}

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

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}

