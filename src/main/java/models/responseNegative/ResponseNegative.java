package models.responseNegative;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseNegative {
    private String errorCode;
    private String errorMessage;
    private String errorDetails;
}
