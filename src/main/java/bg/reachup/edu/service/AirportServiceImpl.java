package bg.reachup.edu.service;

import bg.reachup.edu.dto.AirportDTO;
import bg.reachup.edu.entity.Airport;
import bg.reachup.edu.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<AirportDTO> getAllAirport() {
        return airportRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AirportDTO getAirportById(Long airportId) {
        return airportRepository.findById(airportId).map(this::convertToDto).orElse(null);
    }

    @Override
    public AirportDTO addOrUpdateAirport(AirportDTO airportDto, long airportId) {
        Airport newAirport = convertFromDtoToEntity(airportDto);
        newAirport.setId(airportId);
        Airport saveAirport = airportRepository.save(newAirport);
        return convertToDto(saveAirport);
    }

    @Override
    public AirportDTO deleteAirport(Long airportId) {
        Airport airportToDelete = airportRepository.findById(airportId).orElse(null);
        if (airportToDelete == null) {
            throw new EntityNotFoundException("There is no airport in the database!");
        }
        airportRepository.deleteById(airportId);
        return convertToDto(airportToDelete);
    }

    @Override
    public void addAirportIfNotExist(AirportDTO airportDTO) {
        Airport airport = convertFromDtoToEntity(airportDTO);
        this.airportRepository.save(airport);
    }

    private AirportDTO convertToDto(Airport airport) {
        return new AirportDTO(airport.getId(), airport.getLatitude(), airport.getLongitude(),
                airport.getCityName(), airport.getAirportCode());
    }

    private Airport convertFromDtoToEntity(AirportDTO airportDTO) {
        return new Airport(0, airportDTO.getLatitude(), airportDTO.getLongitude(), airportDTO.getAirportCode(),
                airportDTO.getAirportName());
    }
}
