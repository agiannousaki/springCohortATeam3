package gr.codelearn.movie.db.controller;

import gr.codelearn.movie.db.base.BaseComponent;
import gr.codelearn.movie.db.domain.Activity;
import gr.codelearn.movie.db.domain.Film;
import gr.codelearn.movie.db.domain.Person;
import gr.codelearn.movie.db.domain.PersonType;
import gr.codelearn.movie.db.service.FilmService;
import gr.codelearn.movie.db.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("mvc")
@AllArgsConstructor
public class MvcController extends BaseComponent {
	private final PersonService personService;

	private final FilmService filmService;

	@GetMapping
	public String index(Model model) {

		String filmTitle = filmService.findLatestRelease();
		model.addAttribute("latestFilm", filmTitle);

		return "home";
	}

	@GetMapping("people")
	public String products(Model model) {
		List<Person> allPeople = personService.findAll();
		model.addAttribute("allPeople", allPeople);
		return "people";
	}

	@GetMapping("findPerson")
	public String findPerson(Model model, @RequestParam(value = "lastName", required = false) String lastName) {
		if (lastName != null) {
			Person person = personService.findByLastName(lastName);
			if (person != null) {
				model.addAttribute("person", person);
			} else {
				logger.info("Person with lastname {} does not exist", lastName);
				model.addAttribute("error", "Person does not exist.");
			}
			Set<Activity> activities = person.getActivities();

			model.addAttribute("actor", activities.stream().filter(o -> o.getPersonType().equals(PersonType.ACTOR)).map(Activity :: getContent).collect(Collectors.toList()));
			model.addAttribute("director", activities.stream().filter(o -> o.getPersonType().equals(PersonType.DIRECTOR)).map(Activity :: getContent).collect(Collectors.toList()));
			model.addAttribute("producer", activities.stream().filter(o -> o.getPersonType().equals(PersonType.PRODUCER)).map(Activity :: getContent).collect(Collectors.toList()));
		}
		return "findPerson";
	}

	@GetMapping("about")
	public String about(HttpServletRequest request, HttpServletResponse response) {
		return "about";
	}

}
