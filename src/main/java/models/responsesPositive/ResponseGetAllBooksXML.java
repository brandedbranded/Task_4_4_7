package models.responsesPositive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.AuthorTable;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "authors_books")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGetAllBooksXML {

    @XmlElement(name = "author", required = true)
    private AuthorTable author;

    @XmlElement(name = "book_title", required = true)
    private String bookTitle;
}