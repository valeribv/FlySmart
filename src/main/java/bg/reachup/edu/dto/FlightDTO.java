package bg.reachup.edu.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class FlightDTO implements Serializable {
    @Min(value = 2, message = "AirCode must be bigger than 1 char.")
    @Max(value = 4, message = "Input is to big.")
    private String originAirportCode;
    private String destinationAirportCode;
    private double price;
    private double distance;
    private String arriveTime;
    private String arriveDate;

    //Generated Constructor
    public FlightDTO(String originAirportCode, String destinationAirportCode, double price,
                     double distance, String arriveTime, String arriveDate) {
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.price = price;
        this.distance = distance;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
    }
   public FlightDTO() {}

    //Generated getter and setters
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


