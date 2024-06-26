package bg.reachup.edu.controller;

import bg.reachup.edu.dto.CityDTO;
import bg.reachup.edu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDTO> getCity(@PathVariable long cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@Valid @RequestBody CityDTO newCityRequest) {
        CityDTO newCity = cityService.addOrUpdateCities(newCityRequest, 0);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO newCityRequestToUpdate,
                                              @PathVariable long cityId) {
        CityDTO updatedCity = cityService.addOrUpdateCities(newCityRequestToUpdate, cityId);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<CityDTO> delete(@PathVariable long cityId) {
        CityDTO cityDTO = cityService.deleteCity(cityId);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }
}
