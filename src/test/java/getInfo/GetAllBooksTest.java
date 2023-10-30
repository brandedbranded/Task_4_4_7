package getInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import models.responsesPositive.ResponseAuthorSave;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specification;
import steps.assertForTest.AssertBooks;

@Epic("GetTests")
@Story("getAllBooks")
public class GetAllBooksTest {

    @DisplayName("Получить список всех книг с новой созданной книгой")
    @Description("Возвращается список всех книг автора соответствующего введенному id, в списке есть созданная книга, статус-код 200")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {46})
    public void getAllBooksWithNewBookTest() {
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
        long id = author.getAuthorId();

        String bookTitle = "BookNewBook";
        Specification.reqSpecSaveBook("BookNewBook", id, 201);

        ValidatableResponse allBooks = Specification.reqSpecGetAllBooksResponse(String.valueOf(id), 200);
        AssertBooks.verifyBodyGetBooks(allBooks, id, bookTitle);
    }
}
