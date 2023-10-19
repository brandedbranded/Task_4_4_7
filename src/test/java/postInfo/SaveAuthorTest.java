package postInfo;


import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseAuthorSave;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertSaveAuthor;

@Epic("PostTests")
@Story("saveNewAuthor")
public class SaveAuthorTest {

    @DisplayName("New author save")
    @Description("Автор сохраняется, статус-код 201, в ответе возвращается id сохранённого автора")
    @Test
    public void saveAuthorTest() {
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(4);;
        String middleName = RandomStringUtils.randomAlphabetic(6);;
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor(firstName, lastName, middleName, 201);
        AssertSaveAuthor.verifySaveAuthorResponse(author);
    }
}
