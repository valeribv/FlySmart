package bg.reachup.edu.repository;

import bg.reachup.edu.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByCity(String city);
}
