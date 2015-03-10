package sample.project.dto;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Adrian Perez on 2/9/2015.
 */
@Entity
public class Person {

    public Long getRegistrationId() {
        return registrationId;
    }

    @Id
    @GeneratedValue
    private Long registrationId;
    private String lastName;
    private String firstName;

    private Person(){}

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
