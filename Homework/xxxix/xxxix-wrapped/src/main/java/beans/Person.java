package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "firstName", "lastName", "age"})
public class Person {
    @XmlAttribute(name = "id", required = true)
    private String id;
    
    @XmlElement(name = "first-name", required = true)
    private String firstName;
    
    @XmlElement(name = "last-name", required = true)
    private String lastName;

    @XmlElement(required = true)
    private Integer age;
    
    //#region getter/setters, toString, equals, constructors
    public Person(){}

    public Person(String id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    //#endregion
}
