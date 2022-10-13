package bare.get;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import manager.data.AuthData;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class GetPersonRequest {
    @XmlElement(required = true)
    private AuthData auth;

    @XmlElement(required = true)
    private String id;

    public AuthData getAuth() {
        return auth;
    }

    public void setAuth(AuthData auth) {
        this.auth = auth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
