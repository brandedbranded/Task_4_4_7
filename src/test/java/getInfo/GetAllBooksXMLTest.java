package getInfo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.responsesPositive.ResponseGetAllBooksXmlList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specification;
import steps.assertForTest.AssertGetBooksXML;

import java.util.List;

@Epic("GetTests")
@Story("getAllBooksXML")
public class GetAllBooksXMLTest {


    @DisplayName("Get all book in XML")
    @Description("В ответ приходит список всех книг автора, статус-код 200")
    @Test
    public void getAllBooksXMLTest(){
        List<ResponseGetAllBooksXmlList> listBooksXML = Specification.reqSpecGetAllBooksXML(5, 200);
        AssertGetBooksXML.verifyGetAllBooksXMLResponse(listBooksXML);
    }
}
