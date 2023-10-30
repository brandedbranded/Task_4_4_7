package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import models.authorExmp.BookSaveAuthorExmp;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestBookSave {
    private String bookTitle;
    private BookSaveAuthorExmp author;
}
