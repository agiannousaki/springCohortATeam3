package gr.codelearn.movie.db.repository;

import gr.codelearn.movie.db.domain.Category;
import gr.codelearn.movie.db.domain.Film;
import gr.codelearn.movie.db.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findByTitle(String title);

    @Query("select f from Film f join fetch f.genre g where g = ?1")
    List<Film> findFilmsByCategory(Category category);

    @Query(nativeQuery = true)
    String findLatestRelease();

    @Query("select f from Film f join fetch f.genre")
    List<Film> findAllLazy();

}
