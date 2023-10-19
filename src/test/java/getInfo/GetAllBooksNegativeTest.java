package getInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specification;

@Epic("GetTests")
@Story("getAllBooks-negative")
public class GetAllBooksNegativeTest {

    @DisplayName("Get all books, unknown author")
    @Description("Список книг в ответе отсутствует, статус-код 409")
    @Test
    public void getAllBooksUnknownAuthorTest(){
        Specification.reqSpecGetAllBooksNegative("1553", 409, "1004");
    }

    @DisplayName("Get all books, id is incorrect")
    @Description("Список книг в ответе отсутствует, статус-код 400")
    @ParameterizedTest
    @ValueSource (strings = {"fakeId"," "})
    public void getAllBooksIdNullTest(String id){
        Specification.reqSpecGetAllBooksNegative(id, 400, "1001");
    }

    @DisplayName("Get all books, id is incorrect")
    @Description("Список книг в ответе отсутствует, статус-код 400")
    @ParameterizedTest
    @ValueSource (strings = {"-1","-2"})
    public void getAllBooksIdNegativeTest(String id){
        Specification.reqSpecGetAllBooksNegative(id, 409, "1004");
    }
}
