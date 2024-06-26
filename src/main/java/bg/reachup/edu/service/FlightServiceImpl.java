package bg.reachup.edu.service;

import bg.reachup.edu.dto.FlightDTO;
import bg.reachup.edu.entity.Flight;
import bg.reachup.edu.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<FlightDTO> getAllFlight() {
        return flightRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlightById(Long flightId) {
        return flightRepository.findById(flightId).map(this::convertToDto).orElse(null);
    }

    @Override
    public FlightDTO addOrUpdateFlight(FlightDTO flightDTO, long flightId) {
        Flight newFlight = convertFromDtoToEntity(flightDTO);
        newFlight.setId(flightId);
        Flight saveFlight = flightRepository.save(newFlight);
        return convertToDto(saveFlight);
    }

    @Override
    public FlightDTO deleteFlight(Long flightId) {
        Flight flightToDelete = flightRepository.findById(flightId).orElse(null);
        if (flightToDelete == null) {
            throw new EntityNotFoundException("There is no city in the database!");
        }
        flightRepository.deleteById(flightId);
        return convertToDto(flightToDelete);
    }

    @Override
    public void addFlightIfNotExist(FlightDTO flightDTO) {
        Flight flight = convertFromDtoToEntity(flightDTO);
        this.flightRepository.save(flight);
    }

    private FlightDTO convertToDto(Flight flight) {
        return new FlightDTO(flight.getOriginAirportCode(), flight.getDestinationAirportCode(),
                flight.getPrice(), flight.getDistance(), flight.getArriveTime(), flight.getArriveDate());
    }

    private Flight convertFromDtoToEntity(FlightDTO flightDTO) {
        return new Flight(0, flightDTO.getOriginAirportCode(), flightDTO.getDestinationAirportCode(),
                flightDTO.getPrice(), flightDTO.getDistance(), flightDTO.getArriveTime(), flightDTO.getArriveDate());
    }
}
