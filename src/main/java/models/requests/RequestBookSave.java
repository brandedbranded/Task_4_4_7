package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import models.BookSaveAuthorExmp.BookSaveAuthorExmp;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestBookSave {
    private String bookTitle;
    private BookSaveAuthorExmp author;
}
