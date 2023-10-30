package steps.assertForTest;

import entity.AuthorTable;
import models.responsesPositive.ResponseGetAllBooksXML;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertGetBooksXML {
    public static void verifyGetAllBooksXMLResponse(ResponseGetAllBooksXML listBooksXML, String bookTitle, AuthorTable author){
        assertEquals(listBooksXML.getBooks().get(0).getBookTitle(), bookTitle);
        assertEquals(listBooksXML.getBooks().get(0).getAuthor(), author);
    }
}
