package globant.talentpod.restSample.ports;

import globant.talentpod.restSample.domain.payroll.Employee;
import globant.talentpod.restSample.domain.payroll.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            LOGGER.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            LOGGER.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}
