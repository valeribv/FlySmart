package bg.reachup.edu.service;

import bg.reachup.edu.dto.FlightDTO;

import java.util.List;

public interface FlightService {

    List<FlightDTO> getAllFlight();
    FlightDTO getFlightById(Long flightId);
    FlightDTO addOrUpdateFlight(FlightDTO city,long flightId);
    FlightDTO deleteFlight(Long flightId) ;

    void addFlightIfNotExist(FlightDTO cityDTO);
}
