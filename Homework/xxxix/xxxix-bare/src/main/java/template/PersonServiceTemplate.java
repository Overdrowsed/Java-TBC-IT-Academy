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

import bare.add.AddPersonRequest;
import bare.delete.DeletePersonRequest;
import bare.get.GetPersonRequest;
import bare.get.GetPersonResponse;
import bare.list.ListPersonsRequest;
import bare.list.ListPersonsResponse;
import bare.update.UpdatePersonRequest;
import fault.AccessForbidden;
import fault.ClientUnauthorized;
import fault.GeneralError;
import fault.PersonAlreadyExists;
import fault.PersonNotFound;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
@HandlerChain(file = "/handlers.xml")
public interface PersonServiceTemplate {

    @WebMethod(operationName = "GetPerson")
    @WebResult(name = "GetPersonResponse")
    GetPersonResponse getPerson(
        @WebParam(name = "GetPersonRequest") GetPersonRequest request
    ) throws GeneralError, AccessForbidden, ClientUnauthorized, PersonNotFound;
        
        
    @WebMethod(operationName = "AddPerson")
    @WebResult(name = "AddPersonResponse")
    boolean addPerson(
        @WebParam(name = "AddPersonRequest") AddPersonRequest request
    ) throws GeneralError, AccessForbidden, ClientUnauthorized, PersonAlreadyExists;

    @WebMethod(operationName = "UpdatePerson")
    @WebResult(name = "UpdatePersonResponse")
    boolean updatePerson(
        @WebParam(name = "UpdatePersonRequest") UpdatePersonRequest request
    ) throws GeneralError, AccessForbidden, ClientUnauthorized, PersonNotFound;

    @WebMethod(operationName = "DeletePerson")
    @WebResult(name = "DeletePersonResponse")
    boolean deletePerson(
        @WebParam(name = "DeletePersonRequest") DeletePersonRequest request
    ) throws GeneralError, AccessForbidden, ClientUnauthorized, PersonNotFound;

    @WebMethod(operationName = "ListPersons")
    @WebResult(name = "ListPersonsResponse")
    ListPersonsResponse listPersons(ListPersonsRequest request) throws GeneralError, AccessForbidden, ClientUnauthorized;
}
