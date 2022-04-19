package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Category;
import gr.codelearn.movie.db.domain.Film;

import java.util.List;

public interface FilmService extends BaseService<Film, Long> {

    public List<Film> findFilmsByCategory(Category category);
}
