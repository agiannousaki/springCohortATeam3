package gr.codelearn.movie.db.controller;

import gr.codelearn.movie.db.base.BaseComponent;
import gr.codelearn.movie.db.domain.BaseModel;
import gr.codelearn.movie.db.service.BaseService;
import gr.codelearn.movie.db.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<T extends BaseModel> extends BaseComponent {
	protected abstract BaseService<T,Long> getBaseService();
	@GetMapping
	public ResponseEntity<ApiResponse<List<T>>> findAll() {
		return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build(),
									HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<T>> get(@PathVariable Long id) {
		return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody T entity) {
		return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(entity)).build(),
									HttpStatus.CREATED);
	}

	@DeleteMapping
	public void delete(@Valid @RequestBody T entity) {
		if (getBaseService().exists(entity)) {
			getBaseService().delete(entity);
		}
	}
}
