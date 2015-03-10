package sample.project.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Adrian Perez on 3/10/2015.
 */
public class RegistrationResponse extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String result;

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String registrationId;
}
