package steps.assertForTest;

import models.responsesPositive.ResponseGetAllBooksXmlList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertGetBooksXML {
    public static void verifyGetAllBooksXMLResponse(List<ResponseGetAllBooksXmlList> listBooksXML){
        assertFalse(listBooksXML.isEmpty());
    }

}
