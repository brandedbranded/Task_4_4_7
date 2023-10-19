package models.responsesPositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.AuthorTable;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGetAllBooks {
    private String bookTitle;
    private AuthorTable author;
}
