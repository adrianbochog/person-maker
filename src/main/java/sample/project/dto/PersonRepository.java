package sample.project.dto;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adrian Perez on 2/9/2015.
 */
public interface PersonRepository extends CrudRepository<Person,Long> {
    Iterable<Person> findByFirstName(String firstName);

    Iterable<Person> findByLastName(String lastName);

}
