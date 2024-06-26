package bg.reachup.edu.repository;

import bg.reachup.edu.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    //TODO
    // Add for Flight DB
   //  City findByFlight(String city);
}
