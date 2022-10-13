package bare.list;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import manager.data.AuthData;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class ListPersonsRequest {
    @XmlElement(required = true)
    private AuthData auth;

    public AuthData getAuth() {
        return auth;
    }

    public void setAuth(AuthData auth) {
        this.auth = auth;
    }
}
