package postInfo;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.responsesPositive.ResponseBookSave;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertSaveBook;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveBookTest {
    @DisplayName("New book save")
    @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
    @Test
    public void saveBookTest(){
        ResponseBookSave book = Specification.reqSpecSaveBook("BookNewBook", 2, 201);
        AssertSaveBook.verifySaveBookResponse(book);
    }

    @DisplayName("New book save, book title in Russian")
    @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
    @Test
    public void saveBookRussianTitle(){
        ResponseBookSave bookUnknownAuthor = Specification.reqSpecSaveBook("Детство", 1, 201);
        AssertSaveBook.verifySaveBookResponse(bookUnknownAuthor);

    }
}
