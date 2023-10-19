package getInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import models.responsesPositive.ResponseGetAllBooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specification;
import steps.assertForTest.AssertGetBooks;

import java.util.List;

@Epic("GetTests")
@Story("getAllBooks")
public class GetAllBooksTest {
    @DisplayName("Get all author's books by id")
    @Description("Возвращается список всех книг автора соответствующего введенному id, статус-код 200")
    @Test
    public void getAllBooksTest() {
        List<ResponseGetAllBooks> allBooks = Specification.reqSpecGetAllBooks("15", 200);
        AssertGetBooks.verifyGetAllBooksResponse(allBooks);
    }

    @DisplayName("Get all books including new book")
    @Description("Возвращается список всех книг автора соответствующего введенному id, в списке есть созданная книга, статус-код 200")
    @ParameterizedTest
    @ValueSource(longs = {3})
    public void getAllBooksWithNewBookTest(long id) {
        Specification.reqSpecSaveBook("BookNewBook", id, 201);
        ValidatableResponse allBooks = Specification.reqSpecGetAllBooksResponse(String.valueOf(id), 200);
        AssertGetBooks.verifyBodyGetBooks(allBooks, id);
    }
}
