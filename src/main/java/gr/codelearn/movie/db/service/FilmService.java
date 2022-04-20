package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Activity;
import gr.codelearn.movie.db.domain.Category;
import gr.codelearn.movie.db.domain.Film;

import java.util.List;

public interface FilmService extends BaseService<Film, Long> {
    public void assign(Activity activity);
    public List<Film> findFilmsByCategory(Category category);

    public String findLatestRelease();

    public List<Film> findAllLazy();
}
