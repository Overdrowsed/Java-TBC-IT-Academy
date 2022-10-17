
package homework.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the homework.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccessForbidden_QNAME = new QName("http://template/", "AccessForbidden");
    private final static QName _AddPersonRequest_QNAME = new QName("http://template/", "AddPersonRequest");
    private final static QName _AddPersonResponse_QNAME = new QName("http://template/", "AddPersonResponse");
    private final static QName _ClientUnauthorized_QNAME = new QName("http://template/", "ClientUnauthorized");
    private final static QName _DeletePersonRequest_QNAME = new QName("http://template/", "DeletePersonRequest");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://template/", "DeletePersonResponse");
    private final static QName _GeneralError_QNAME = new QName("http://template/", "GeneralError");
    private final static QName _GetPersonRequest_QNAME = new QName("http://template/", "GetPersonRequest");
    private final static QName _GetPersonResponse_QNAME = new QName("http://template/", "GetPersonResponse");
    private final static QName _ListPersons_QNAME = new QName("http://template/", "ListPersons");
    private final static QName _ListPersonsResponse_QNAME = new QName("http://template/", "ListPersonsResponse");
    private final static QName _PersonAlreadyExists_QNAME = new QName("http://template/", "PersonAlreadyExists");
    private final static QName _PersonNotFound_QNAME = new QName("http://template/", "PersonNotFound");
    private final static QName _UpdatePersonRequest_QNAME = new QName("http://template/", "UpdatePersonRequest");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://template/", "UpdatePersonResponse");
    private final static QName _Person_QNAME = new QName("http://template/", "person");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: homework.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccessForbidden }
     * 
     */
    public AccessForbidden createAccessForbidden() {
        return new AccessForbidden();
    }

    /**
     * Create an instance of {@link AddPersonRequest }
     * 
     */
    public AddPersonRequest createAddPersonRequest() {
        return new AddPersonRequest();
    }

    /**
     * Create an instance of {@link ClientUnauthorized }
     * 
     */
    public ClientUnauthorized createClientUnauthorized() {
        return new ClientUnauthorized();
    }

    /**
     * Create an instance of {@link DeletePersonRequest }
     * 
     */
    public DeletePersonRequest createDeletePersonRequest() {
        return new DeletePersonRequest();
    }

    /**
     * Create an instance of {@link GeneralError }
     * 
     */
    public GeneralError createGeneralError() {
        return new GeneralError();
    }

    /**
     * Create an instance of {@link GetPersonRequest }
     * 
     */
    public GetPersonRequest createGetPersonRequest() {
        return new GetPersonRequest();
    }

    /**
     * Create an instance of {@link GetPersonResponse }
     * 
     */
    public GetPersonResponse createGetPersonResponse() {
        return new GetPersonResponse();
    }

    /**
     * Create an instance of {@link ListPersonsRequest }
     * 
     */
    public ListPersonsRequest createListPersonsRequest() {
        return new ListPersonsRequest();
    }

    /**
     * Create an instance of {@link ListPersonsResponse }
     * 
     */
    public ListPersonsResponse createListPersonsResponse() {
        return new ListPersonsResponse();
    }

    /**
     * Create an instance of {@link PersonAlreadyExists }
     * 
     */
    public PersonAlreadyExists createPersonAlreadyExists() {
        return new PersonAlreadyExists();
    }

    /**
     * Create an instance of {@link PersonNotFound }
     * 
     */
    public PersonNotFound createPersonNotFound() {
        return new PersonNotFound();
    }

    /**
     * Create an instance of {@link UpdatePersonRequest }
     * 
     */
    public UpdatePersonRequest createUpdatePersonRequest() {
        return new UpdatePersonRequest();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Persons }
     * 
     */
    public Persons createPersons() {
        return new Persons();
    }

    /**
     * Create an instance of {@link AuthData }
     * 
     */
    public AuthData createAuthData() {
        return new AuthData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessForbidden }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccessForbidden }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AccessForbidden")
    public JAXBElement<AccessForbidden> createAccessForbidden(AccessForbidden value) {
        return new JAXBElement<AccessForbidden>(_AccessForbidden_QNAME, AccessForbidden.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPersonRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AddPersonRequest")
    public JAXBElement<AddPersonRequest> createAddPersonRequest(AddPersonRequest value) {
        return new JAXBElement<AddPersonRequest>(_AddPersonRequest_QNAME, AddPersonRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AddPersonResponse")
    public JAXBElement<Boolean> createAddPersonResponse(Boolean value) {
        return new JAXBElement<Boolean>(_AddPersonResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientUnauthorized }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientUnauthorized }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "ClientUnauthorized")
    public JAXBElement<ClientUnauthorized> createClientUnauthorized(ClientUnauthorized value) {
        return new JAXBElement<ClientUnauthorized>(_ClientUnauthorized_QNAME, ClientUnauthorized.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePersonRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "DeletePersonRequest")
    public JAXBElement<DeletePersonRequest> createDeletePersonRequest(DeletePersonRequest value) {
        return new JAXBElement<DeletePersonRequest>(_DeletePersonRequest_QNAME, DeletePersonRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "DeletePersonResponse")
    public JAXBElement<Boolean> createDeletePersonResponse(Boolean value) {
        return new JAXBElement<Boolean>(_DeletePersonResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralError }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeneralError }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "GeneralError")
    public JAXBElement<GeneralError> createGeneralError(GeneralError value) {
        return new JAXBElement<GeneralError>(_GeneralError_QNAME, GeneralError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "GetPersonRequest")
    public JAXBElement<GetPersonRequest> createGetPersonRequest(GetPersonRequest value) {
        return new JAXBElement<GetPersonRequest>(_GetPersonRequest_QNAME, GetPersonRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "GetPersonResponse")
    public JAXBElement<GetPersonResponse> createGetPersonResponse(GetPersonResponse value) {
        return new JAXBElement<GetPersonResponse>(_GetPersonResponse_QNAME, GetPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPersonsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListPersonsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "ListPersons")
    public JAXBElement<ListPersonsRequest> createListPersons(ListPersonsRequest value) {
        return new JAXBElement<ListPersonsRequest>(_ListPersons_QNAME, ListPersonsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPersonsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListPersonsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "ListPersonsResponse")
    public JAXBElement<ListPersonsResponse> createListPersonsResponse(ListPersonsResponse value) {
        return new JAXBElement<ListPersonsResponse>(_ListPersonsResponse_QNAME, ListPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAlreadyExists }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAlreadyExists }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "PersonAlreadyExists")
    public JAXBElement<PersonAlreadyExists> createPersonAlreadyExists(PersonAlreadyExists value) {
        return new JAXBElement<PersonAlreadyExists>(_PersonAlreadyExists_QNAME, PersonAlreadyExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "PersonNotFound")
    public JAXBElement<PersonNotFound> createPersonNotFound(PersonNotFound value) {
        return new JAXBElement<PersonNotFound>(_PersonNotFound_QNAME, PersonNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePersonRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "UpdatePersonRequest")
    public JAXBElement<UpdatePersonRequest> createUpdatePersonRequest(UpdatePersonRequest value) {
        return new JAXBElement<UpdatePersonRequest>(_UpdatePersonRequest_QNAME, UpdatePersonRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "UpdatePersonResponse")
    public JAXBElement<Boolean> createUpdatePersonResponse(Boolean value) {
        return new JAXBElement<Boolean>(_UpdatePersonResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Person }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

}
