package entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "author")
public class AuthorTable {

    @XmlElement(name = "id", required = true)
    private long id;

    @XmlElement(name = "first_name", required = true)
    private String firstName;

    @XmlElement(name = "family_name", required = true)
    private String familyName;

    @XmlElement(name = "second_name", required = true)
    private String secondName;
}
