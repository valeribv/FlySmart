package bg.reachup.edu.controller;

import bg.reachup.edu.dto.AirportDTO;
import bg.reachup.edu.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirport());
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportDTO> getAirport(@PathVariable long airportId) {
        return ResponseEntity.ok(airportService.getAirportById(airportId));
    }

    @PostMapping("/{airportId}")
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO newAirportRequest) {
        AirportDTO newAirport = airportService.addOrUpdateAirport(newAirportRequest, 0);
        return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
    }

    @PutMapping("/{airportId}")
    public ResponseEntity<AirportDTO> updateCity(@RequestBody AirportDTO newAirportRequestToUpdate,
                                                 @PathVariable long airportId) {
        AirportDTO updatedAirport = airportService.addOrUpdateAirport(newAirportRequestToUpdate, airportId);
        return new ResponseEntity<>(updatedAirport, HttpStatus.OK);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<AirportDTO> delete(@PathVariable long airportId) {
        AirportDTO airportDTO = airportService.deleteAirport(airportId);
        return new ResponseEntity<>(airportDTO, HttpStatus.OK);
    }
}

