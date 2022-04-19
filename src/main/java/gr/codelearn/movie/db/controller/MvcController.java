package gr.codelearn.movie.db.controller;

import gr.codelearn.movie.db.base.BaseComponent;
import gr.codelearn.movie.db.domain.Person;
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

@Controller
@RequestMapping("mvc")
@AllArgsConstructor
public class MvcController extends BaseComponent {
	private final PersonService personService;

	@GetMapping
	public String index(Model model) {
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
			model.addAttribute("actor", new ArrayList());
			model.addAttribute("director", new ArrayList());
			model.addAttribute("producer", new ArrayList());
		}
		return "findPerson";
	}

	@GetMapping("about")
	public String about(HttpServletRequest request, HttpServletResponse response) {
		return "about";
	}

}
