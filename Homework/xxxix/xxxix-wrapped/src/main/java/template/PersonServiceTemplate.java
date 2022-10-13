package template;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import beans.Person;
import beans.Persons;
import fault.AccessForbidden;
import fault.GeneralError;
import fault.PersonAlreadyExists;
import fault.PersonNotFound;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
@HandlerChain(file = "/handlers.xml")
public interface PersonServiceTemplate {

    @WebMethod(operationName = "GetPerson")
    @WebResult(name = "person")
    Person getPerson(
        @WebParam(name = "id") String id
    ) throws GeneralError, AccessForbidden, PersonNotFound;
        
        
    @WebMethod(operationName = "AddPerson")
    @WebResult(name = "AddPersonResult")
    boolean addPerson(
        @WebParam(name = "id") String id,
        @WebParam(name = "first-name") String firstName,
        @WebParam(name = "last-name") String lastName,
        @WebParam(name = "age") int age
    ) throws GeneralError, AccessForbidden, PersonAlreadyExists;

    @WebMethod(operationName = "UpdatePerson")
    @WebResult(name = "UpdatePersonResult")
    boolean updatePerson(
        @WebParam(name = "id") String id,
        @WebParam(name = "first-name") String firstName,
        @WebParam(name = "last-name") String lastName,
        @WebParam(name = "age") int age
    ) throws GeneralError, AccessForbidden, PersonNotFound;

    @WebMethod(operationName = "DeletePerson")
    @WebResult(name = "DeletePersonResult")
    boolean deletePerson(
        @WebParam(name = "id") String id
    ) throws GeneralError, AccessForbidden, PersonNotFound;

    @WebMethod(operationName = "ListPersons")
    @WebResult(name = "ListPersonsResult")
    Persons listPersons() throws GeneralError, AccessForbidden;
}
