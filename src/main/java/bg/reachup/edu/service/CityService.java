package bg.reachup.edu.service;

import bg.reachup.edu.dto.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> getAllCities();
    CityDTO getCityById(Long cityId);
    CityDTO addOrUpdateCities(CityDTO city,long cityId);
    CityDTO deleteCity(Long cityId) ;

    CityDTO addCityIfNotExist(CityDTO cityDTO);
}
