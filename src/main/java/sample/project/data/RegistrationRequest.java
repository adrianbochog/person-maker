package sample.project.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Adrian Perez on 3/10/2015.
 */
public class RegistrationRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "first_name is required")
    @JsonProperty(value = "first_name")
    private String firstName;

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

    @NotNull(message = "last_name is required")
    @JsonProperty(value = "last_name")
    private String lastName;
}
