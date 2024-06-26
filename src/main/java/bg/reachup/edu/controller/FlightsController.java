package bg.reachup.edu.controller;

import bg.reachup.edu.dto.FlightDTO;
import bg.reachup.edu.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightsController {
    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlight() {
        return ResponseEntity.ok(flightService.getAllFlight());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable long flightId) {
        return ResponseEntity.ok(flightService.getFlightById(flightId));
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO newFlightRequest) {
        FlightDTO newFlight = flightService.addOrUpdateFlight(newFlightRequest, 0);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody FlightDTO newFlightRequestToUpdate,
                                                  @PathVariable long flightId) {
        FlightDTO updatedFlight = flightService.addOrUpdateFlight(newFlightRequestToUpdate, flightId);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<FlightDTO> delete(@PathVariable long flightId) {
        FlightDTO flightDTO = flightService.deleteFlight(flightId);
        return new ResponseEntity<>(flightDTO, HttpStatus.OK);
    }
}