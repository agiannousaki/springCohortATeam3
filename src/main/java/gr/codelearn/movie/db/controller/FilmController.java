package gr.codelearn.movie.db.controller;

import gr.codelearn.movie.db.domain.Film;
import gr.codelearn.movie.db.domain.Person;
import gr.codelearn.movie.db.service.BaseService;
import gr.codelearn.movie.db.service.FilmService;
import gr.codelearn.movie.db.service.PersonService;
import gr.codelearn.movie.db.transfer.ApiError;
import gr.codelearn.movie.db.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController extends AbstractController<Film> {

	private final FilmService filmService;

	@GetMapping(headers = "reporting=findLastest")
	public ResponseEntity<ApiResponse<String>> findLatestRelease() {
		return new ResponseEntity<>(ApiResponse.<String>builder().data(filmService.findLatestRelease())
				.build(), HttpStatus.OK);
	}

	@Override
	protected BaseService<Film, Long> getBaseService() {
		return filmService;
	}

	@GetMapping
	@Override
	public ResponseEntity<ApiResponse<List<Film>>> findAll() {
		return new ResponseEntity<>(ApiResponse.<List<Film>>builder().data(filmService.findAllLazy()).build(),
				HttpStatus.OK);
	}
}
