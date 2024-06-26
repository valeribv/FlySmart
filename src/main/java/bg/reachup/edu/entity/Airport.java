package bg.reachup.edu.entity;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private String cityName;
    @Column
    private String airportCode;

    //Generated Constructor
    public Airport(long id, double latitude, double longitude, String cityName, String airportCode) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityName = cityName;
        this.airportCode = airportCode;
    }

    //Generated getter and setters
    public Airport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String airportCode) {
        this.cityName = airportCode;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportName) {
        this.airportCode = airportName;
    }
}
