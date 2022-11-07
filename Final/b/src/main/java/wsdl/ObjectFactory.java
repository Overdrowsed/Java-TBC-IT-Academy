
package wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl package. 
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

    private final static QName _AgentAccessDenied_QNAME = new QName("http://template/", "AgentAccessDenied");
    private final static QName _AgentAuthFailed_QNAME = new QName("http://template/", "AgentAuthFailed");
    private final static QName _AmountNotPositive_QNAME = new QName("http://template/", "AmountNotPositive");
    private final static QName _Check_QNAME = new QName("http://template/", "Check");
    private final static QName _CheckResponse_QNAME = new QName("http://template/", "CheckResponse");
    private final static QName _DuplicateFault_QNAME = new QName("http://template/", "DuplicateFault");
    private final static QName _InternalError_QNAME = new QName("http://template/", "InternalError");
    private final static QName _Pay_QNAME = new QName("http://template/", "Pay");
    private final static QName _PayResponse_QNAME = new QName("http://template/", "PayResponse");
    private final static QName _Status_QNAME = new QName("http://template/", "Status");
    private final static QName _StatusResponse_QNAME = new QName("http://template/", "StatusResponse");
    private final static QName _TransactionNotFound_QNAME = new QName("http://template/", "TransactionNotFound");
    private final static QName _UserNotFound_QNAME = new QName("http://template/", "UserNotFound");
    private final static QName _Transaction_QNAME = new QName("http://template/", "transaction");
    private final static QName _User_QNAME = new QName("http://template/", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgentAccessDenied }
     * 
     */
    public AgentAccessDenied createAgentAccessDenied() {
        return new AgentAccessDenied();
    }

    /**
     * Create an instance of {@link AgentAuthFailed }
     * 
     */
    public AgentAuthFailed createAgentAuthFailed() {
        return new AgentAuthFailed();
    }

    /**
     * Create an instance of {@link AmountNotPositive }
     * 
     */
    public AmountNotPositive createAmountNotPositive() {
        return new AmountNotPositive();
    }

    /**
     * Create an instance of {@link Check }
     * 
     */
    public Check createCheck() {
        return new Check();
    }

    /**
     * Create an instance of {@link CheckResponse }
     * 
     */
    public CheckResponse createCheckResponse() {
        return new CheckResponse();
    }

    /**
     * Create an instance of {@link DuplicateFault }
     * 
     */
    public DuplicateFault createDuplicateFault() {
        return new DuplicateFault();
    }

    /**
     * Create an instance of {@link InternalError }
     * 
     */
    public InternalError createInternalError() {
        return new InternalError();
    }

    /**
     * Create an instance of {@link Pay }
     * 
     */
    public Pay createPay() {
        return new Pay();
    }

    /**
     * Create an instance of {@link PayResponse }
     * 
     */
    public PayResponse createPayResponse() {
        return new PayResponse();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link StatusResponse }
     * 
     */
    public StatusResponse createStatusResponse() {
        return new StatusResponse();
    }

    /**
     * Create an instance of {@link TransactionNotFound }
     * 
     */
    public TransactionNotFound createTransactionNotFound() {
        return new TransactionNotFound();
    }

    /**
     * Create an instance of {@link UserNotFound }
     * 
     */
    public UserNotFound createUserNotFound() {
        return new UserNotFound();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgentAccessDenied }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgentAccessDenied }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AgentAccessDenied")
    public JAXBElement<AgentAccessDenied> createAgentAccessDenied(AgentAccessDenied value) {
        return new JAXBElement<AgentAccessDenied>(_AgentAccessDenied_QNAME, AgentAccessDenied.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgentAuthFailed }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgentAuthFailed }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AgentAuthFailed")
    public JAXBElement<AgentAuthFailed> createAgentAuthFailed(AgentAuthFailed value) {
        return new JAXBElement<AgentAuthFailed>(_AgentAuthFailed_QNAME, AgentAuthFailed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountNotPositive }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountNotPositive }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "AmountNotPositive")
    public JAXBElement<AmountNotPositive> createAmountNotPositive(AmountNotPositive value) {
        return new JAXBElement<AmountNotPositive>(_AmountNotPositive_QNAME, AmountNotPositive.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Check }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Check }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "Check")
    public JAXBElement<Check> createCheck(Check value) {
        return new JAXBElement<Check>(_Check_QNAME, Check.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "CheckResponse")
    public JAXBElement<CheckResponse> createCheckResponse(CheckResponse value) {
        return new JAXBElement<CheckResponse>(_CheckResponse_QNAME, CheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicateFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DuplicateFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "DuplicateFault")
    public JAXBElement<DuplicateFault> createDuplicateFault(DuplicateFault value) {
        return new JAXBElement<DuplicateFault>(_DuplicateFault_QNAME, DuplicateFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternalError }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InternalError }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "InternalError")
    public JAXBElement<InternalError> createInternalError(InternalError value) {
        return new JAXBElement<InternalError>(_InternalError_QNAME, InternalError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pay }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Pay }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "Pay")
    public JAXBElement<Pay> createPay(Pay value) {
        return new JAXBElement<Pay>(_Pay_QNAME, Pay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "PayResponse")
    public JAXBElement<PayResponse> createPayResponse(PayResponse value) {
        return new JAXBElement<PayResponse>(_PayResponse_QNAME, PayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Status }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Status }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "Status")
    public JAXBElement<Status> createStatus(Status value) {
        return new JAXBElement<Status>(_Status_QNAME, Status.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "StatusResponse")
    public JAXBElement<StatusResponse> createStatusResponse(StatusResponse value) {
        return new JAXBElement<StatusResponse>(_StatusResponse_QNAME, StatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransactionNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "TransactionNotFound")
    public JAXBElement<TransactionNotFound> createTransactionNotFound(TransactionNotFound value) {
        return new JAXBElement<TransactionNotFound>(_TransactionNotFound_QNAME, TransactionNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "UserNotFound")
    public JAXBElement<UserNotFound> createUserNotFound(UserNotFound value) {
        return new JAXBElement<UserNotFound>(_UserNotFound_QNAME, UserNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaction }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Transaction }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "transaction")
    public JAXBElement<Transaction> createTransaction(Transaction value) {
        return new JAXBElement<Transaction>(_Transaction_QNAME, Transaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link User }{@code >}
     */
    @XmlElementDecl(namespace = "http://template/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

}
