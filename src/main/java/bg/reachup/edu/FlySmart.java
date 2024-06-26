package bg.reachup.edu;

import bg.reachup.edu.configuration.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class FlySmart {
    @Autowired
    MigrationService migrationService;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FlySmart.class, args);
        System.out.println("<Message> App status: .:is Running:.");

    }

    //When application successfully started, use this method
    @EventListener(ApplicationReadyEvent.class)
    public void updateDatabaseAfterStartup() throws IOException {
        migrationService.migrateDatabaseCity();
        migrationService.migrateDatabaseFlight();
        migrationService.migrateDatabaseAirport();
    }
}