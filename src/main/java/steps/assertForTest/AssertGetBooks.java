package steps.assertForTest;

import io.restassured.response.ValidatableResponse;
import models.responsesPositive.ResponseGetAllBooks;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AssertGetBooks {
    public static void verifyGetAllBooksResponse(List<ResponseGetAllBooks> listOfBooks) {
        assertFalse(listOfBooks.isEmpty());
        assertThat(listOfBooks)
                .isNotNull()
                .asString()
                .contains("bookTitle")
                .contains("author")
                .contains("firstName")
                .contains("familyName")
                .contains("secondName");
    }

    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id) {
        allBooks.assertThat()
                .body("find{it.bookTitle=='BookNewBook'}.bookTitle", equalTo("BookNewBook"))
                .body("author.find{it.id==3}.id", equalTo((int)id));
    }
}
