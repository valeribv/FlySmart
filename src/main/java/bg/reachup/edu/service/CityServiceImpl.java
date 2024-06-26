package bg.reachup.edu.service;

import bg.reachup.edu.dto.CityDTO;
import bg.reachup.edu.entity.City;
import bg.reachup.edu.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CityDTO getCityById(Long cityId) {
        CityDTO cityDTO = cityRepository.findById(cityId).map(this::convertToDto).orElse(null);
        return cityDTO;
    }

    @Override
    public CityDTO addOrUpdateCities(CityDTO cityDto, long cityId) {
        City newCity = convertFromDtoToEntity(cityDto,cityId);
        City savedCity = cityRepository.save(newCity);
        return convertToDto(savedCity);
    }

    @Override
    public CityDTO deleteCity(Long cityId) {
        City cityToDelete = cityRepository.findById(cityId).orElse(null);
        if (cityToDelete == null) {
            throw new EntityNotFoundException("There is no city in the database!");
        }
        cityRepository.deleteById(cityId);
        return convertToDto(cityToDelete);
    }

    @Override
    public CityDTO addCityIfNotExist(CityDTO cityDTO) {
        City existingCity = cityRepository.findByCity(cityDTO.getCity());
        if (existingCity == null){
            CityDTO createdCity = addOrUpdateCities(cityDTO, 0);
            return createdCity;
        }

        return convertToDto(existingCity);
    }


    //TODO
    // Write explanation what do Convert here
    // Methods for converting DTO to + DTO to Entity
    private CityDTO convertToDto(City city) {
        return new CityDTO(city.getCity(), city.getCountry(), city.getLatitude(),city.getLongitude());
    }

    private City convertFromDtoToEntity(CityDTO cityDTO, long cityId) {
      City city =  new City(cityId, cityDTO.getCity(), cityDTO.getCountry());
      city.setLatitude(cityDTO.getLatitude());
      city.setLongitude(cityDTO.getLongitude());
        return city;
    }
}
