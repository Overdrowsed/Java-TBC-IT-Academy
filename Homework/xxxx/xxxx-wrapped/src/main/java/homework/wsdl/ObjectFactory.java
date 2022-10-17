
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
    private final static QName _AddPerson_QNAME = new QName("http://template/", "AddPerson");
    private final static QName _AddPersonResponse_QNAME = new QName("http://template/", "AddPersonResponse");
    private final static QName _DeletePerson_QNAME = new QName("http://template/", "DeletePerson");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://template/", "DeletePersonResponse");
    private final static QName _GeneralError_QNAME = new QName("http://template/", "GeneralError");
    private final static QName _GetPerson_QNAME = new QName("http://template/", "GetPerson");
    private final static QName _GetPersonResponse_QNAME = new QName("http://template/", "GetPersonResponse");
    private final static QName _ListPersons_QNAME = new QName("http://template/", "ListPersons");
    private final static QName _ListPersonsResponse_QNAME = new QName("http://template/", "ListPersonsResponse");
    private final static QName _PersonAlreadyExists_QNAME = new QName("http://template/", "PersonAlreadyExists");
    private final static QName _PersonNotFound_QNAME = new QName("http://template/", "PersonNotFound");
    private final static QName _UpdatePerson_QNAME = new QName("http://template/", "UpdatePerson");
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
     * Create an instance of {@link AddPerson }
     * 
     */
    public AddPerson createAddPerson() {
        return new AddPerson();
    }

    /**
     * Create an instance of {@link AddPersonResponse }
     * 
     */
    public AddPersonResponse createAddPersonResponse() {
        return new AddPersonResponse();
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link GeneralError }
     * 
     */
    public GeneralError createGeneralError() {
        return new GeneralError();
    }

    /**
     * Create an instance of {@link GetPerson }
     * 
     */
    public GetPerson createGetPerson() {
        return new GetPerson();
    }

    /**
     * Create an instance of {@link GetPersonResponse }
     * 
     */
    public GetPersonResponse createGetPersonResponse() {
        return new GetPersonResponse();
    }

    /**
     * Create an instance of {@link ListPersons }
     * 
     */
    public ListPersons createListPersons() {
        return new ListPersons();
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
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AddPerson")
    public JAXBElement<AddPerson> createAddPerson(AddPerson value) {
        return new JAXBElement<AddPerson>(_AddPerson_QNAME, AddPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AddPersonResponse")
    public JAXBElement<AddPersonResponse> createAddPersonResponse(AddPersonResponse value) {
        return new JAXBElement<AddPersonResponse>(_AddPersonResponse_QNAME, AddPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "DeletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "DeletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "GetPerson")
    public JAXBElement<GetPerson> createGetPerson(GetPerson value) {
        return new JAXBElement<GetPerson>(_GetPerson_QNAME, GetPerson.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPersons }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListPersons }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "ListPersons")
    public JAXBElement<ListPersons> createListPersons(ListPersons value) {
        return new JAXBElement<ListPersons>(_ListPersons_QNAME, ListPersons.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "UpdatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "UpdatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
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
