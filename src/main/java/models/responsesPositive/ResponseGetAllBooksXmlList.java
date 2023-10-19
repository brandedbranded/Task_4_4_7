package models.responsesPositive;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "authors_books")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGetAllBooksXmlList {

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book", required = true)
    List<ResponseGetAllBooksXML> books;
}
