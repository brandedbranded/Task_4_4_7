package postInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specification;
@Epic("PostTests")
@Story("saveNewBook-negative")
public class SaveBookNegativeTest {

    @DisplayName("New book save, id of unknown author")
    @Description("Книга не сохраняется, статус-код 409, error 1004")
    @Test
    public void saveBookUnknownAuthorTest(){
        //generate id -> delete author(id) -> save book(id)
        Specification.reqSpecSaveBook("BookUnknown", 222, 409);
    }

    @DisplayName("New book save, id is negative")
    @Description("Книга не сохраняется, статус-код 409, error 1004")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {-1,-2, })
    public void saveBookNegativeId(long id){
        Specification.reqSpecSaveBook("Title", id, 409);
    }

    @DisplayName("New book save, bookTitle is null")
    @Description("Книга не сохраняется, статус-код 400, error 1001")
    @ParameterizedTest
    @NullSource
    public void saveBookNullId(String bookTitle){
        Specification.reqSpecSaveBook(bookTitle, 4, 400);
    }
}
