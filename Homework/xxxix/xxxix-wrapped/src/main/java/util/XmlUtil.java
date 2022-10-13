package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import beans.Person;
import beans.Persons;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtil {    
    public static void personsToXml(List<Person> personList, String path) throws JAXBException, FileNotFoundException{
        Persons persons = new Persons(personList);
        
        FileOutputStream output = new FileOutputStream(path);

        JAXBContext context = JAXBContext.newInstance(Persons.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(persons, output);
    }

    public static Persons xmlToPersons(String path) throws JAXBException, IllegalArgumentException{
        JAXBContext context = JAXBContext.newInstance(Persons.class);

        Persons persons = (Persons) context.createUnmarshaller().unmarshal(new File(path));

        return persons;
    }
}
