package homework.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import homework.wsdl.PersonServiceTemplate;
import homework.wsdl.PersonServiceWrapped;
import jakarta.xml.ws.BindingProvider;
import homework.util.BindingUtil;

public class Client {
    private static PersonServiceTemplate service;

    private static final Logger logger = LogManager.getLogger("person_wrapped_client");

    static {
        try{
            service = new PersonServiceWrapped().getPersonServicePort();
            
            BindingProvider bindingProvider = (BindingProvider) service;

            BindingUtil.configureRequestContext(bindingProvider);

            BindingUtil.configureHandler(bindingProvider);
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }

    public static void getPerson(String id){
        try{
            service.getPerson(id);
        }
        catch(Exception exception){
            ThreadContext.put("method", "getPerson");

            logger.error(exception.getMessage());
        }
    }
    
    public static void addPerson(String id, String firstName, String lastName, int age){
        try{
            service.addPerson(id, firstName, lastName, age);
        }
        catch(Exception exception){
            ThreadContext.put("method", "addPerson");

            logger.error(exception.getMessage());
        }
    }

    public static void updatePerson(String id, String firstName, String lastName, int age){
        try{
            service.updatePerson(id, firstName, lastName, age);
        }
        catch(Exception exception){
            ThreadContext.put("method", "updatePerson");

            logger.error(exception.getMessage());
        }
    }

    public static void deletePerson(String id){
        try{
            service.deletePerson(id);
        }
        catch(Exception exception){
            ThreadContext.put("method", "deletePerson");

            logger.error(exception.getMessage());
        }
    }

    public static void listPersons(){
        try{
            service.listPersons();
        }
        catch(Exception exception){
            ThreadContext.put("method", "listPersons");

            logger.error(exception.getMessage());
        }
    }
}
