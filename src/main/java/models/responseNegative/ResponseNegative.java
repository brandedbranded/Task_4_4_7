package models.responseNegative;

import lombok.Data;

@Data
public class ResponseNegative {
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
