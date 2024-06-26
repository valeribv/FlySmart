package bg.reachup.edu.configuration;

import bg.reachup.edu.dto.AirportDTO;
import bg.reachup.edu.dto.CityDTO;
import bg.reachup.edu.dto.FlightDTO;
import bg.reachup.edu.service.AirportService;
import bg.reachup.edu.service.CityService;
import bg.reachup.edu.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class MigrationService {

    @Autowired
    CityService cityService;
    @Autowired
    FlightService flightService;
    @Autowired
    AirportService airportService;
    public void migrateDatabaseCity() throws IOException {
        Resource resource = new ClassPathResource("dataDB/cityDB.txt");
        File file = resource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // Reading from the first line of input database. And remove title from all columns.
        bufferedReader.readLine();

        String line = bufferedReader.readLine();
        while (line != null && !line.isBlank()) {
            String[] splittedLine = line.split("\\s");
            splittedLine = Arrays.stream(splittedLine).filter(string -> !string.isBlank()).toArray(String[]::new);
            CityDTO newCityDto = new CityDTO();
            newCityDto.setCity(splittedLine[1]);
            newCityDto.setLatitude(Double.parseDouble(splittedLine[2]));
            newCityDto.setLongitude(Double.parseDouble(splittedLine[3]));
            newCityDto.setCountry(splittedLine[4]);

            cityService.addCityIfNotExist(newCityDto);
            line = bufferedReader.readLine();
        }

    }

    public void migrateDatabaseFlight() throws IOException {
        //
        Resource resource = new ClassPathResource("dataDB/flightDB.txt");
        File file = resource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.readLine();


        String line = bufferedReader.readLine();
        while (line != null && !line.isBlank()) {
            //   System.out.println(line);
            String[] splittedLine = line.split("\\s");
            splittedLine = Arrays.stream(splittedLine).filter(string -> !string.isBlank()).toArray(String[]::new);
            FlightDTO newFlightDTO = new FlightDTO();
            newFlightDTO.setArriveDate(splittedLine[1]);
            newFlightDTO.setArriveTime(splittedLine[2]);
            newFlightDTO.setDistance(Double.parseDouble(splittedLine[4]));
            newFlightDTO.setPrice(Double.parseDouble(splittedLine[6]));
            newFlightDTO.setOriginAirportCode(splittedLine[5]);
            newFlightDTO.setDestinationAirportCode(splittedLine[3]);

            flightService.addFlightIfNotExist(newFlightDTO);
            line = bufferedReader.readLine();
        }

    }

    public void migrateDatabaseAirport() throws IOException {
        Resource resource = new ClassPathResource("dataDB/airportsDB.txt");
        File file = resource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // Reading from the first line of input database. And remove title from all columns.
        bufferedReader.readLine();


        String line = bufferedReader.readLine();
        while (line != null && !line.isBlank()) {
            //   System.out.println(line);
            String[] splittedLine = line.split("\\s");
            splittedLine = Arrays.stream(splittedLine).filter(string -> !string.isBlank()).toArray(String[]::new);
            AirportDTO newAirportDTO = new AirportDTO();
            newAirportDTO.setAirportName(splittedLine[4]);
            newAirportDTO.setAirportCode(splittedLine[1]);
            newAirportDTO.setLatitude(Double.parseDouble(splittedLine[2]));
            newAirportDTO.setLongitude(Double.parseDouble(splittedLine[3]));
            // newAirportDTO.setAirportName("Bulgaria");

            airportService.addAirportIfNotExist(newAirportDTO);
            line = bufferedReader.readLine();
        }

    }

}
