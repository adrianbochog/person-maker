package sample.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sample.project.data.RegistrationRequest;
import sample.project.data.RegistrationResponse;
import sample.project.dto.Person;
import sample.project.dto.PersonRepository;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;

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

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public HttpEntity<RegistrationResponse> findById(@PathVariable Long id) {

        Person person = personRepository.findOne(id);
        RegistrationResponse response = new RegistrationResponse();
        response.setResult("SUCCESS");
        response.setRegistrationId(Long.toString(id));
        response.add(linkTo(methodOn(PersonController.class).findById(person.getRegistrationId())).withSelfRel());

        return new ResponseEntity(response,HttpStatus.OK);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
     public HttpEntity<RegistrationResponse> addPerson(@Valid @RequestBody RegistrationRequest request) {

        Person person = new Person(request.getFirstName(),request.getLastName());
        Person saved = personRepository.save(person);

        RegistrationResponse response = new RegistrationResponse();
        response.setRegistrationId(Long.toString(saved.getRegistrationId()));
        response.setResult("SUCCESS");

        response.add(linkTo(methodOn(PersonController.class).findById(saved.getRegistrationId())).withSelfRel());

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.delete(id);
    }
}
