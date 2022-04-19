package gr.codelearn.movie.db.controller;

import gr.codelearn.movie.db.domain.Person;
import gr.codelearn.movie.db.service.BaseService;
import gr.codelearn.movie.db.service.PersonService;
import gr.codelearn.movie.db.transfer.ApiError;
import gr.codelearn.movie.db.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController extends AbstractController<Person> {
	private final PersonService personService;

	@GetMapping(params={"lastName"})
	public ResponseEntity<ApiResponse<Person>> findByLastName(@RequestParam String lastName){
		Person person = personService.findByLastName(lastName);
		return handleFindPerson(person, lastName);
	}

	@GetMapping(params={"lastNameLike"})
	public ResponseEntity<ApiResponse<Person>> findByLastNameLike(@RequestParam String lastNameLike){
		Person person = personService.findByLastNameLike(lastNameLike);
		return handleFindPerson(person, lastNameLike);
	}

	private ResponseEntity<ApiResponse<Person>> handleFindPerson(Person person, String lastName) {
		if (person == null) {
			ApiError apiError = new ApiError(HttpStatus.NO_CONTENT.value(), "No person was found with lastname " + lastName);
			return ResponseEntity.ok(ApiResponse.<Person>builder().data(null).apiError(apiError).build());
		} else {
			return ResponseEntity.ok(ApiResponse.<Person>builder().data(person).build());
		}
	}

	@Override
	protected BaseService<Person, Long> getBaseService() {
		return personService;
	}



}
