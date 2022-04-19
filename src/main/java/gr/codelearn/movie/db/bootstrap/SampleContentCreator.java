package gr.codelearn.movie.db.bootstrap;

import gr.codelearn.movie.db.base.BaseComponent;
import gr.codelearn.movie.db.domain.Person;
import gr.codelearn.movie.db.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final PersonService personService;


    @Override
    public void run(final String... args) throws Exception {
        Person p1 = Person.builder().firstName("Angeliki").lastName("Giannousaki").biography("test").build();
        personService.create(p1);

        logger.debug("Saved person {}", p1);
        logger.debug("test {}", personService.findByLastName("Giannousaki"));
    }
}
