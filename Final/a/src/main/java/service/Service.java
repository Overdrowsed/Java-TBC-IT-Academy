package service;

import java.util.UUID;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import beans.Transaction;
import beans.User;
import fault.AgentAccessDenied;
import fault.AgentAuthFailed;
import fault.AmountNotPositive;
import fault.DuplicateFault;
import fault.InternalError;
import fault.TransactionNotFound;
import fault.UserNotFound;
import template.ServiceTemplate;
import util.SqlUtil;
import validation.AuthValidator;

//TODO add logging and whatever apache dbcp2 is
@WebService(serviceName = "ServiceA", endpointInterface = "template.ServiceTemplate")
public class Service implements ServiceTemplate{
    @Resource
    private WebServiceContext context;
    
    private static final Logger logger = LogManager.getLogger("service_A");
    
    @Override
    public User check(int id) throws UserNotFound, AgentAuthFailed, AgentAccessDenied, InternalError{
        ThreadContext.put("method", "check");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        SqlUtil.refreshConnection();

        AuthValidator.validate(context);
        
        return SqlUtil.getUser(id);
    }

    @Override
    public long pay(Transaction transaction) throws DuplicateFault, UserNotFound, AmountNotPositive, AgentAuthFailed, AgentAccessDenied, InternalError {
        ThreadContext.put("method", "pay");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        SqlUtil.refreshConnection();

        AuthValidator.validate(context);

        if(transaction.getAmount() <= 0){
            throw new AmountNotPositive();
        }

        int agentId = getAgentId();

        Transaction duplicateIfExists = null;
        
        try{
            duplicateIfExists = SqlUtil.getTransaction(
                agentId,
                transaction.getAgentTransactionId()
            );
        }
        catch(TransactionNotFound fault){
            SqlUtil.performPayment(agentId, transaction);

            try{
                return SqlUtil.getTransaction(agentId, transaction.getAgentTransactionId()).getSystemTransactionId();
            }
            catch(TransactionNotFound fault2){
                logger.fatal("Unexpected TransactionNotFound");

                throw new InternalError();
            }
        }

        if(duplicateIfExists.equals(transaction)){
            try{
                return SqlUtil.getTransaction(agentId, transaction.getAgentTransactionId()).getSystemTransactionId();
            }
            catch(TransactionNotFound fault){
                logger.fatal("Unexpected TransactionNotFound");

                throw new InternalError();
            }
        }
        else {
            logger.error("Agent sent duplicate transaction");

            throw new DuplicateFault();
        }
    }

    public long status(String agentTransactionId) throws TransactionNotFound, AgentAuthFailed, AgentAccessDenied, InternalError{
        ThreadContext.put("method", "status");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        SqlUtil.refreshConnection();

        AuthValidator.validate(context);
        
        return SqlUtil.getTransaction(getAgentId(), agentTransactionId).getSystemTransactionId();
    }

    //#region utility methods
    private int getAgentId(){
        String id = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getHeader("agent");
        return Integer.valueOf(id);
    }
    //#endregion
}