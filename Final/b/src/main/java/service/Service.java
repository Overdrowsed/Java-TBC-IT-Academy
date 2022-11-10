package service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.ThreadContext;

import beans.Payment;
import client.Client;
import jakarta.xml.ws.WebServiceException;
import template.ServiceTemplate;
import util.FaultUtil;
import util.SqlUtil;
import wsdl.AgentAccessDenied_Exception;
import wsdl.AgentAuthFailed_Exception;
import wsdl.AmountNotPositive_Exception;
import wsdl.DuplicateFault_Exception;
import wsdl.InternalError_Exception;
import wsdl.Transaction;
import wsdl.User;
import wsdl.UserNotFound_Exception;

public class Service implements ServiceTemplate{
    @Override
    public User getUser(int id) throws UserNotFound_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception {        
        ThreadContext.put("method", "getUser");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        return Client.getUser(id);
    }

    @Override
    public Map<String, Number> fillBalance(Transaction transaction) throws UserNotFound_Exception, AmountNotPositive_Exception, DuplicateFault_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception{
        ThreadContext.put("method", "fillBalance");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        Timestamp requestDate = new Timestamp(System.currentTimeMillis());
        
        Payment payment = SqlUtil.getPayment(transaction.getAgentTransactionId());

        if(payment == null){
            try{
                long systemTransactionId = Client.pay(transaction);

                Timestamp responseDate = new Timestamp(System.currentTimeMillis());

                SqlUtil.storeTransaction(systemTransactionId, transaction, requestDate, responseDate, 200, 0);
                
                Map<String, Number> returnMap = new HashMap<>();
                
                returnMap.put("transaction_id", systemTransactionId);

                return returnMap;
            }
            //WebServiceException for SocketTimeoutException
            catch(InternalError_Exception | WebServiceException exception){
                Timestamp responseDate = new Timestamp(System.currentTimeMillis());

                SqlUtil.storeTransaction(0, transaction, requestDate, responseDate, FaultUtil.toHttpCode(exception), 1);

                throw exception;
            }
            catch(UserNotFound_Exception | AmountNotPositive_Exception | DuplicateFault_Exception | AgentAccessDenied_Exception | AgentAuthFailed_Exception exception){
                Timestamp responseDate = new Timestamp(System.currentTimeMillis());
                
                SqlUtil.storeTransaction(0, transaction, requestDate, responseDate, FaultUtil.toHttpCode(exception), 2);
                
                throw exception;
            }
        }
        else if(!payment.equals(new Payment(transaction))){
            throw new DuplicateFault_Exception(null, null);
        }
        else {
            if(payment.getStatus() != 1){
                Map<String, Number> returnMap = new HashMap<>();
                
                returnMap.put("status", payment.getStatus());

                return returnMap;
            }
            else {
                long systemTransactionId = Client.pay(transaction);

                SqlUtil.updateRetriedTransaction(systemTransactionId, transaction.getAgentTransactionId());

                Map<String, Number> returnMap = new HashMap<>();
                
                returnMap.put("transaction_id", systemTransactionId);

                return returnMap;
            }
        }
    }
}
