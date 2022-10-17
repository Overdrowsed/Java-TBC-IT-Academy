package homework.client;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import homework.wsdl.AddPersonRequest;
import homework.wsdl.AuthData;
import homework.wsdl.DeletePersonRequest;
import homework.wsdl.GetPersonRequest;
import homework.wsdl.Person;
import homework.wsdl.PersonServiceTemplate;
import homework.wsdl.PersonServiceWrapped;
import homework.wsdl.UpdatePersonRequest;
import jakarta.xml.ws.BindingProvider;
import homework.util.BindingUtil;

public class Client {
    private static PersonServiceTemplate service;

    private static final Logger logger = LogManager.getLogger("person_wrapped_client");

    private static AuthData authData;

    static {
        try{
            service = new PersonServiceWrapped().getPersonServicePort();
            
            BindingProvider bindingProvider = (BindingProvider) service;

            BindingUtil.configureRequestContext(bindingProvider);

            BindingUtil.configureHandler(bindingProvider);

            Properties properties = new Properties();

            properties.load(
                Client.class.getClassLoader().getResourceAsStream("client.properties")
            );

            authData = new AuthData();

            authData.setUsername(properties.getProperty("username"));
            authData.setPassword(properties.getProperty("password"));
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }

    public static void getPerson(String id){
        try{
            GetPersonRequest request = new GetPersonRequest();

            request.setAuth(authData);
            request.setId(id);
            
            service.getPerson(request);
        }
        catch(Exception exception){
            ThreadContext.put("method", "getPerson");

            logger.error(exception.getMessage());
        }
    }
    
    public static void addPerson(String id, String firstName, String lastName, int age){
        try{
            AddPersonRequest request = new AddPersonRequest();

            Person person = new Person();

            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setAge(age);

            request.setAuth(authData);
            request.setPerson(person);
            
            service.addPerson(request);
        }
        catch(Exception exception){
            ThreadContext.put("method", "addPerson");

            logger.error(exception.getMessage());
        }
    }

    public static void updatePerson(String id, String firstName, String lastName, int age){
        try{
            UpdatePersonRequest request = new UpdatePersonRequest();

            Person person = new Person();

            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setAge(age);

            request.setAuth(authData);
            request.setPerson(person);

            service.updatePerson(request);
        }
        catch(Exception exception){
            ThreadContext.put("method", "updatePerson");

            logger.error(exception.getMessage());
        }
    }

    public static void deletePerson(String id){
        try{
            DeletePersonRequest request = new DeletePersonRequest();

            request.setAuth(authData);
            request.setId(id);

            service.deletePerson(request);
        }
        catch(Exception exception){
            ThreadContext.put("method", "deletePerson");

            logger.error(exception.getMessage());
        }
    }

    public static void listPersons(){
        try{
            service.listPersons(authData);
        }
        catch(Exception exception){
            ThreadContext.put("method", "listPersons");

            logger.error(exception.getMessage());
        }
    }
}
