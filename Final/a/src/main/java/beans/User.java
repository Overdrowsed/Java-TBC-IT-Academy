package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private transient int id;
    private transient String name, surname;
    private transient String personalId;
    private String fullName;
    private float balance;
    
    public User(){}

    public User(int id, String name, String surname, String personalId, float balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalId = personalId;
        this.balance = balance;
        this.fullName = name.toUpperCase().charAt(0) + ". " + surname.toUpperCase().charAt(0) + ".";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return fullName;
    }
}
