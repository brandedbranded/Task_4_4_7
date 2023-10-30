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

    @DisplayName("Сохранение нового автора")
    @Description("Автор сохраняется, статус-код 201, в ответе возвращается id сохранённого автора")
    @Test
    public void saveAuthorTest() {
        ResponseAuthorSave author = Specification.reqSpecSaveAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
        AssertSaveAuthor.verifySaveAuthorResponse(author);
    }
}
