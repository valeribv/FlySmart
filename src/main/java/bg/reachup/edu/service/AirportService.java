package bg.reachup.edu.service;

import bg.reachup.edu.dto.AirportDTO;

import java.util.List;

public interface AirportService {

    List<AirportDTO> getAllAirport();
    AirportDTO getAirportById(Long airportId);
    AirportDTO addOrUpdateAirport(AirportDTO airport,long airportId);
    AirportDTO deleteAirport(Long airportId);

    void addAirportIfNotExist(AirportDTO cityDTO);
}
