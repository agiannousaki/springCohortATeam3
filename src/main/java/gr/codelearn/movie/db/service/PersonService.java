package gr.codelearn.movie.db.service;

import gr.codelearn.movie.db.domain.Person;

public interface PersonService extends BaseService<Person, Long> {

    public Person findByLastName(String lastName);
}
