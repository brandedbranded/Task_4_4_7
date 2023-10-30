package models.responsesPositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "authors_books")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGetAllBooksXML {

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book", required = true)
    List<ResponseGetAllBooks> books;
}