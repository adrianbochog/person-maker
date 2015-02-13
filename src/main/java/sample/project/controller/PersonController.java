package sample.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.project.dto.Person;
import sample.project.dto.PersonRepository;

/**
 * Created by Adrian Work on 7/28/2014.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model) {
        return "hello world!";
    }

    @RequestMapping("/findAll")
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @RequestMapping("/find/{id}")
    public Person findById(@PathVariable Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping("/find/firstName/{firstName}")
    public Iterable<Person> findByFirstName(@PathVariable String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @RequestMapping("/find/lastName/{lastName}")
    public Iterable<Person> findByLastName(@PathVariable String lastName) {
        return personRepository.findByFirstName(lastName);
    }

    @RequestMapping("/add/{firstName}/{lastName}")
    public Person addPerson(@PathVariable String firstName, @PathVariable String lastName) {
        Person person = new Person(firstName, lastName);
        return personRepository.save(person);
    }

    @RequestMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.delete(id);
    }
}
