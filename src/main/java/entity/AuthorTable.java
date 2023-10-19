package entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorTable {

    @XmlElement(name = "id", required = true)
    private long id;

    @XmlElement(name = "first_name", required = true)
    private String firstName; //first_name

    @XmlElement(name = "family_name", required = true)
    private String familyName; //family_name
    private String secondName;
}
