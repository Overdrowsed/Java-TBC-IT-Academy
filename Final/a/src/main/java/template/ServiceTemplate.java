package template;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import beans.Transaction;
import beans.User;
import fault.AgentAccessDenied;
import fault.AgentAuthFailed;
import fault.AmountNotPositive;
import fault.DuplicateFault;
import fault.InternalError;
import fault.TransactionNotFound;
import fault.UserNotFound;

@WebService
@HandlerChain(file = "/handlers.xml")
public interface ServiceTemplate {

    @WebMethod(operationName = "Check")
    @WebResult(name = "user")
    User check(
        @WebParam(name = "user_id") int id
    ) throws UserNotFound, AgentAuthFailed, AgentAccessDenied, InternalError;
    
    @WebMethod(operationName = "Pay")
    @WebResult(name = "system_transaction_id")
    long pay(
        @WebParam(name = "transaction") Transaction transaction
    ) throws DuplicateFault, UserNotFound, AmountNotPositive, AgentAuthFailed, AgentAccessDenied, InternalError;

    @WebMethod(operationName = "Status")
    @WebResult(name = "system_transaction_id")
    long status(
        @WebParam(name = "agent_transaction_id") String agentTransactionId
    ) throws TransactionNotFound, AgentAuthFailed, AgentAccessDenied, InternalError;
}
