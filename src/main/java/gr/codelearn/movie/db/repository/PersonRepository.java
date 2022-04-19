package gr.codelearn.movie.db.repository;

import gr.codelearn.movie.db.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLastName(String lastName);

    @Query("select p from Person p where p.lastName like CONCAT('%',?1,'%')")
    Person findByLastNameLike(String lastName);

}
