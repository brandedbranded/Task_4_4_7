package getInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responseNegative.ResponseNegative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specification;

@Epic("GetTests")
@Story("getAllBooks-negative")
public class GetAllBooksNegativeTest {

    @DisplayName("Получить список книг неизвестного автора")
    @Description("Список книг в ответе отсутствует, статус-код 409")
    @Test
    public void getAllBooksUnknownAuthorTest(){
        ResponseNegative response = Specification.reqSpecGetAllBooksNegative("1553", 409);
        Specification.respSpecNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Получить список всех книг, id задан неверным форматом")
    @Description("Список книг в ответе отсутствует, статус-код 400")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource (strings = {"fakeId"," ","null"})
    public void getAllBooksIdWrongFormatTest(String id){
        ResponseNegative response = Specification.reqSpecGetAllBooksNegative(id, 400);
        Specification.respSpecNegative(response, "1001", "Некорректный обязательный параметр");

    }

    @DisplayName("Получить список всех книг с отрицательным id")
    @Description("Список книг в ответе отсутствует, статус-код 400")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource (strings = {"-1","-2"})
    public void getAllBooksIdNegativeTest(String id){
        ResponseNegative response = Specification.reqSpecGetAllBooksNegative(id, 409);
        Specification.respSpecNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Получить список всех книг без ввода id")
    @Description("Список книг в ответе отсутствует, статус-код 400")
    @Test
    public void getAllBooksIdNullTest(){
        ResponseNegative response = Specification.reqSpecGetAllBooksNegativeIdNull(400);
        Specification.respSpecNegative(response, "1001", "Некорректный обязательный параметр");
    }
}
