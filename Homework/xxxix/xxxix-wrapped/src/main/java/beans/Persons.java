package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"persons"})
@XmlRootElement(name = "persons")
public class Persons {
    @XmlElement(name = "person", required = true)
    private List<Person> persons;

    public Persons() {
        persons = new ArrayList<>();
    }

    public Persons(List<Person> persons){
        this.persons = persons;
    }

    public void add(Person person){
        this.persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
