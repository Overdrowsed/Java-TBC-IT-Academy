package bare.add;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import beans.Person;
import manager.data.AuthData;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class AddPersonRequest {
    @XmlElement(required = true)
    private AuthData auth;

    @XmlElement(required = true)
    private Person person;

    public AuthData getAuth() {
        return auth;
    }

    public void setAuth(AuthData auth) {
        this.auth = auth;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
