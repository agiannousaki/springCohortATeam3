package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Activity;
import gr.codelearn.movie.db.domain.Category;
import gr.codelearn.movie.db.domain.Film;
import gr.codelearn.movie.db.repository.ActivityRepository;
import gr.codelearn.movie.db.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;
    private final ActivityRepository activityRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public List<Film> findFilmsByCategory(Category category) {
        return filmRepository.findFilmsByCategory(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(Activity activity) {
        activityRepository.save(activity);
        logger.debug("Saved activity {}.", activity);
    }

    @Override
    public String findLatestRelease() {
        return filmRepository.findLatestRelease();
    }

    @Override
    public List<Film> findAllLazy() {
        return filmRepository.findAllLazy();
    }
}
