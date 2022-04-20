package gr.codelearn.movie.db.bootstrap;

import gr.codelearn.movie.db.base.BaseComponent;
import gr.codelearn.movie.db.domain.*;
import gr.codelearn.movie.db.service.FilmService;
import gr.codelearn.movie.db.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;

    @Override
    public void run(final String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "31-08-1990";
        Date date = sdf.parse(dateInString);
        List<Person> persons = List.of(
                Person.builder().firstName("Angeliki").lastName("Giannousaki").placeOfBirth("Russia").dateOfBirth(date).biography("two Academy Awards, two Golden Globe Awards, and three British Academy Film Awards").build(),
                Person.builder().firstName("Billy").lastName("Batson").placeOfBirth("Germany").dateOfBirth(new Date(31556952000L)).biography("two Academy Awards, two Golden Globe Awards, and three British Academy Film Awards").build(),
                Person.builder().firstName("Charles").lastName("Xavier").placeOfBirth("France").dateOfBirth(new Date(31556952000L)).biography("two Academy Awards, two Golden Globe Awards, and three British Academy Film Awards").build(),
                Person.builder().firstName("Clint").lastName("Barton").placeOfBirth("Italy").dateOfBirth(new Date(31556952000L)).biography("two Academy Awards, a Golden Globe Award, the Cecil B. DeMille Award, and a Screen Actors Guild Life Achievement Award").build(),
                Person.builder().firstName("Harry").lastName("Cleese").placeOfBirth("Spain").dateOfBirth(new Date(31556952000L)).biography("two Academy Awards, a Golden Globe Award, the Cecil B. DeMille Award, and a Screen Actors Guild Life Achievement Award").build(),
                Person.builder().firstName("Henry").lastName("McCoy").placeOfBirth("Ukraine").dateOfBirth(new Date(31556952000L)).biography("two Academy Awards, a Golden Globe Award, the Cecil B. DeMille Award, and a Screen Actors Guild Life Achievement Award").build(),
                Person.builder().firstName("Steven").lastName("Rogers").placeOfBirth("Poland").dateOfBirth(new Date(31556952000L)).biography("Academy Award, a Screen Actors Guild Award, and a Golden Globe Award").build(),
                Person.builder().firstName("Marc").lastName("Spector").placeOfBirth("Romania").dateOfBirth(new Date(31556952000L)).biography("Academy Award, a Screen Actors Guild Award, and a Golden Globe Award").build(),
                Person.builder().firstName("Tony").lastName("Stark").placeOfBirth("Netherlands").dateOfBirth(new Date(31556952000L)).biography("Academy Award, a Screen Actors Guild Award, and a Golden Globe Award").build(),
                Person.builder().firstName("Yondu").lastName("Udonta").placeOfBirth("Belgium").dateOfBirth(new Date(31556952000L)).biography("Academy Award, a Screen Actors Guild Award, and a Golden Globe Award").build());

        persons = personService.createAll(persons);
        logger.info("Created {} persons.", persons.size());
        List<Category> list1 = Arrays.asList(Category.ACTION,Category.ANIMATION);
        List<Category> list2 = Arrays.asList(Category.COMEDY,Category.FANTASY);
        List<Category> list3 = Arrays.asList(Category.CRIME,Category.ACTION);

        List<Film> films = List.of(
                Film.builder().title("Spider-Man: No Way Home").durationInSec(120).dateOfRelease(new Date()).plot("Hans Gruber and the terrorists arrive at Nakatomi Plaza, where John McClane is trying to reconcile with his wife, Holly, during her company Christmas party. The terrorists are the problem, even though John isn't aware of them yet (though he will be shortly").rating(4.3).genre(new HashSet<>(list1)).build(),
                Film.builder().title("The Battle at Lake Changjin").durationInSec(120).dateOfRelease(new Date()).plot("John has learned the terrorists are ruthless killers, and he's the only one who's not being held hostage at gunpoint, so he's the only one who can save them all. His story goal is to save the hostages from the terrorists.").rating(3.3).genre(new HashSet<>(list2)).build(),
                Film.builder().title("Hi, Mom").durationInSec(120).dateOfRelease(new Date()).plot("The first time they come face to face, Hans pretends to be a hostage and John gives him a gun. A fatal misstep? No! John's two steps ahead of Hans this time. Their battle continues into Act 3, with John a bit wiser, a bit more insightful.").rating(2.9).genre(new HashSet<>(list3)).build(),
                Film.builder().title("No Time to Die").durationInSec(120).dateOfRelease(new Date()).plot("Hans Gruber and the terrorists arrive at Nakatomi Plaza, where John McClane is trying to reconcile with his wife, Holly, during her company Christmas party. The terrorists are the problem, even though John isn't aware of them yet (though he will be shortly").rating(8.9).genre(new HashSet<>(list3)).build(),
                Film.builder().title("Detective Chinatown 3").durationInSec(120).dateOfRelease(new Date()).plot("John realizes what Hans's real plan is, uses that info to save the hostages, and then faces off with Hans to save wife Holly. When the movie ends, we know John has solved his problem and saved his marriage.").rating(5.6).genre(new HashSet<>(list2)).build(),
                Film.builder().title("Venom: Let There Be Carnage").durationInSec(120).dateOfRelease(new Date()).plot("John realizes what Hans's real plan is, uses that info to save the hostages, and then faces off with Hans to save wife Holly. When the movie ends, we know John has solved his problem and saved his marriage.").rating(7.5).genre(new HashSet<>(list1)).build(),
                Film.builder().title("Godzilla vs. Kong").durationInSec(120).dateOfRelease(new Date()).plot("John realizes what Hans's real plan is, uses that info to save the hostages, and then faces off with Hans to save wife Holly. When the movie ends, we know John has solved his problem and saved his marriage.").rating(4.3).genre(new HashSet<>(list3)).build(),
                Film.builder().title("Sing 2").durationInSec(120).dateOfRelease(new Date()).plot("Hans Gruber and the terrorists arrive at Nakatomi Plaza, where John McClane is trying to reconcile with his wife, Holly, during her company Christmas party. The terrorists are the problem, even though John isn't aware of them yet (though he will be shortly").rating(5.5).genre(new HashSet<>(list2)).build(),
                Film.builder().title("The Eight Hundred").durationInSec(120).dateOfRelease(new Date()).plot("The first time they come face to face, Hans pretends to be a hostage and John gives him a gun. A fatal misstep? No! John's two steps ahead of Hans this time. Their battle continues into Act 3, with John a bit wiser, a bit more insightful.").rating(9.5).genre(new HashSet<>(list2)).build(),
                Film.builder().title("My People, My Homeland").durationInSec(120).dateOfRelease(new Date()).plot("The first time they come face to face, Hans pretends to be a hostage and John gives him a gun. A fatal misstep? No! John's two steps ahead of Hans this time. Their battle continues into Act 3, with John a bit wiser, a bit more insightful.").rating(5.5).genre(new HashSet<>(list1)).build());

        films = filmService.createAll(films);
        logger.info("Created {} films.", films.size());

        List<Activity> activities = List.of(
                new Activity(films.get(1),persons.get(0), PersonType.ACTOR),
                new Activity(films.get(1),persons.get(1), PersonType.PRODUCER),
                new Activity(films.get(1),persons.get(2), PersonType.DIRECTOR),
                new Activity(films.get(2),persons.get(3), PersonType.ACTOR),
                new Activity(films.get(2),persons.get(4), PersonType.PRODUCER),
                new Activity(films.get(2),persons.get(5), PersonType.DIRECTOR),
                new Activity(films.get(3),persons.get(6), PersonType.PRODUCER),
                new Activity(films.get(3),persons.get(7), PersonType.ACTOR),
                new Activity(films.get(3),persons.get(8), PersonType.DIRECTOR),
                new Activity(films.get(0),persons.get(9), PersonType.DIRECTOR)
        );
        for(Activity act : activities) {
            logger.info("filmId {}", act.getContent().getId());
            filmService.assign(act);
        }

    }
}
