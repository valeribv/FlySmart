package bg.reachup.edu.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Column
    private String originAirportCode;
    @Column
    private String destinationAirportCode;
    @Column
    private double price;
    @Column
    private double distance;
    @Column
    private String arriveTime;
    @Column
    private String arriveDate;

    //Generated Constructor
    public Flight(long id, String originAirportCode, String destinationAirportCode, double price, double distance, String arriveTime, String arriveDate) {
        this.id = id;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.price = price;
        this.distance = distance;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
    }

    public Flight() {
    }
    //Generated getter and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginAirportCode() {
        return originAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

}