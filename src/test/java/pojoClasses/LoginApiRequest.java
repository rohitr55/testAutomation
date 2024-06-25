package pojoClasses;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginApiRequest {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "email")
    public String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "password")
    public String password;

}
