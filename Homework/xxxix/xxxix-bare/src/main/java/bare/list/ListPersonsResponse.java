package bare.list;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import beans.Persons;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListPersonsResponse {
    @XmlElement
    private Persons persons;

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }
}
