package postInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import models.responsesPositive.ResponseAuthorSave;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertBooks;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveBookTest {
    @DisplayName("New book save")
    @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
    @Test
    public void saveBookTest(){
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
        long id = author.getAuthorId();

        String bookTitle = "BookNewBook";
        Specification.reqSpecSaveBook(bookTitle, id, 201);

        ValidatableResponse allBooks = Specification.reqSpecGetAllBooksResponse(String.valueOf(id), 200);
        AssertBooks.verifyBodyGetBooks(allBooks, id, bookTitle);
    }

    @DisplayName("New book save, book title in Russian")
    @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
    @Test
    public void saveBookRussianTitle(){
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
        long id = author.getAuthorId();

        String bookTitle = "Детство";
        Specification.reqSpecSaveBook(bookTitle, id, 201);

        ValidatableResponse allBooks = Specification.reqSpecGetAllBooksResponse(String.valueOf(id), 200);
        AssertBooks.verifyBodyGetBooks(allBooks, id, bookTitle);

    }
}
