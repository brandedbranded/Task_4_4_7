package getInfo;

import entity.AuthorTable;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.responsesPositive.ResponseAuthorSave;
import models.responsesPositive.ResponseGetAllBooksXML;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertGetBooksXML;

@Epic("GetTests")
@Story("getAllBooksXML")
public class GetAllBooksXMLTest {


    @DisplayName("Получить список всех книг в XML формате")
    @Description("В ответ приходит список всех книг автора, статус-код 200")
    @Test
    public void getAllBooksXMLTest(){
        ResponseAuthorSave author1 = Specification.reqSpecSaveAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
        long id = author1.getAuthorId();

        String bookTitle = "BookNewBook";
        Specification.reqSpecSaveBook(bookTitle, id, 201);

        ResponseGetAllBooksXML listBooksXML = Specification.reqSpecGetAllBooksXML(id, 200);
        AuthorTable author = listBooksXML.getBooks().get(0).getAuthor();

        AssertGetBooksXML.verifyGetAllBooksXMLResponse(listBooksXML, bookTitle, author);
    }
}
