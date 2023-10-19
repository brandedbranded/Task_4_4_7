package steps;

import lombok.Data;

@Data
public final class EndPoints {
    public static final String saveNewAuthorURL = "/library/authors/save";
    public static final String saveNewBookURL = "/library/books/save";
    public static final String getAllBooksURL = "/library/authors/{id}/books";
    public static final String getAllBooksXMLUrl = "/library/authors/books";

/*    given().pathParams("id", someId).get(EndPoints.users)...;

или так

    given().get(EndPoints.users, someId)....*/
}
