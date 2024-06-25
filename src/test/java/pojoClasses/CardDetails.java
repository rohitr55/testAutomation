package pojoClasses;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CardDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "fullName")
    public String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "cardNum")
    public double cardNum;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "expMonth")
    public String expMonth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "expYear")
    public String expYear;

}
