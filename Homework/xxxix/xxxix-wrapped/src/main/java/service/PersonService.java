package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import beans.Person;
import beans.Persons;
import fault.AccessForbidden;
import fault.GeneralError;
import fault.PersonAlreadyExists;
import fault.PersonNotFound;
import manager.ConfigManager;
import manager.IpValidator;
import template.PersonServiceTemplate;
import util.XmlUtil;

@WebService(serviceName = "PersonServiceWrapped", endpointInterface = "template.PersonServiceTemplate")
public class PersonService implements PersonServiceTemplate{
    @Resource
    private WebServiceContext context;
    
    private static final Logger logger = LogManager.getLogger("person_webservice");
    
    @Override
    public Person getPerson(String id) throws GeneralError, AccessForbidden, PersonNotFound{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "getPerson");
        
        String ip = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
        
        try{
            IpValidator.validate(ip);
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";
            
            logger.fatal(message);
            throw new GeneralError(message);
        }

        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        Person requestedPerson = null;

        try{
            requestedPerson = XmlUtil.xmlToPersons(databasePath).getPersons().stream()
                .filter(person -> person.getId().equals(id)).findAny().orElseThrow();
        }
        catch(NoSuchElementException exception){
            String message = "No person found with id " + id;

            logger.error(message);
            throw new PersonNotFound(message);
        }
        catch(JAXBException exception){
            String message = "Malformed xml in database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(IllegalArgumentException exception){
            String message = "Database couldn't be found";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        
        return requestedPerson;
    }

    @Override
    public boolean addPerson(String id, String firstName, String lastName, int age) throws GeneralError, AccessForbidden, PersonAlreadyExists{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "addPerson");

        String ip = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
        
        try{
            IpValidator.validate(ip);
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        
        Person newPerson = new Person(id, firstName, lastName, age);

        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            String message = "Malformed xml in database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(IllegalArgumentException exception){
            String message = "Database couldn't be found";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        if(persons.stream().anyMatch(person -> person.getId().equals(newPerson.getId()))){
            String message = "Person already exists in database"; 

            logger.error(message);
            throw new PersonAlreadyExists(message);
        }

        persons.add(newPerson);

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            String message = "Couldn't write to database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(JAXBException exception){
            String message = "Jaxb exception occured";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        return true;
    }
    
    @Override
    public boolean updatePerson(String id, String firstfirstName, String lastName, int age) throws GeneralError, AccessForbidden, PersonNotFound{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "updatePerson");

        String ip = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
        
        try{
            IpValidator.validate(ip);
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        
        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            String message = "Malformed xml in database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(IllegalArgumentException exception){
            String message = "Database couldn't be found";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        Person updatedPerson = new Person(id, firstfirstName, lastName, age);
        
        try{
            persons.set(persons.indexOf(updatedPerson), updatedPerson);
        }
        catch(IndexOutOfBoundsException exception){
            String message = "No person matches given id";

            logger.error(message);
            throw new PersonNotFound(message);
        }

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            String message = "Couldn't write to database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(JAXBException exception){
            String message = "Jaxb exception occured";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        return true;
    }

    @Override
    public boolean deletePerson(String id) throws GeneralError, AccessForbidden, PersonNotFound{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "deletePerson");

        String ip = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
        
        try{
            IpValidator.validate(ip);
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        
        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            String message = "Malformed xml in database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(IllegalArgumentException exception){
            String message = "Database couldn't be found";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        if(!persons.removeIf(person -> person.getId().equals(id))){
            String message = "No person with id " + id + " found in database";

            logger.error(message);
            throw new PersonNotFound(message);
        }

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            String message = "Couldn't write to database";

            logger.fatal(message);
            throw new GeneralError(message);
        }
        catch(JAXBException exception){
            String message = "Jaxb exception occured";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        return true;
    }

    @Override
    public Persons listPersons() throws GeneralError, AccessForbidden{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "listPersons");
        
        String ip = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
        
        try{
            IpValidator.validate(ip);
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            String message = "Configuration couldn't be read";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        Persons persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath);
        }
        catch(JAXBException exception){
            String message = "Malformed xml in database";

            logger.fatal(message);
            throw new GeneralError(message);
        }

        return persons;
    }
}