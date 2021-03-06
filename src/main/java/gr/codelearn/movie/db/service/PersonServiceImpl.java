package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Person;
import gr.codelearn.movie.db.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Person findByLastName(final String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @Override
    public Person findByLastNameLike(final String lastName) {
        return personRepository.findByLastNameLike(lastName);
    }
}
