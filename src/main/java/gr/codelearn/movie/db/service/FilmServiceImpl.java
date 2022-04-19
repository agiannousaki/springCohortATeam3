package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Category;
import gr.codelearn.movie.db.domain.Film;
import gr.codelearn.movie.db.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public List<Film> findFilmsByCategory(Category category) {
        return filmRepository.findFilmsByCategory(category);
    }
}
