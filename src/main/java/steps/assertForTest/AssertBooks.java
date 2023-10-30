package steps.assertForTest;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.core.IsEqual.equalTo;


public class AssertBooks {

    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id, String bookTitle) {
        allBooks.assertThat()
                .body("find{it.bookTitle=='" + bookTitle + "'}.bookTitle", equalTo(bookTitle))
                .body("author.find{it.id==" + id + "}.id", equalTo((int) id));
    }
}
