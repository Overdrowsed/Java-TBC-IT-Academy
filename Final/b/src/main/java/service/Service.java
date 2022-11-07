package service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.Payment;
import client.Client;
import jakarta.xml.ws.WebServiceException;
import template.ServiceTemplate;
import util.SqlUtil;
import wsdl.AgentAccessDenied_Exception;
import wsdl.AgentAuthFailed_Exception;
import wsdl.AmountNotPositive_Exception;
import wsdl.DuplicateFault_Exception;
import wsdl.InternalError_Exception;
import wsdl.Transaction;
import wsdl.User;
import wsdl.UserNotFound_Exception;

//TODO null header safety & refresh connection in service a, apache pooling, how to add all classes in package in web.xml, check what happens if ServiceA or derby isnt turned on, add response_date column to payments table, ThreadContext, logging?, maybe split a and b log4j2.xml & organize configs
public class Service implements ServiceTemplate{
    private static final Logger logger = LogManager.getLogger("service_B");

    @Override
    public User getUser(int id) throws UserNotFound_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception {
        return Client.getUser(id);
    }

    @Override
    public Map<String, Number> fillBalance(Transaction transaction) throws UserNotFound_Exception, AmountNotPositive_Exception, DuplicateFault_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception{
        Payment payment = SqlUtil.getPayment(transaction.getAgentTransactionId());

        if(payment == null){
            try{
                long systemTransactionId = Client.pay(transaction);

                SqlUtil.storeTransaction(systemTransactionId, transaction, 0);
        
                return new HashMap<>(){
                    {
                        put("transaction_id", systemTransactionId);
                    }
                };
            }
            //WebServiceException for SocketTimeoutException
            catch(InternalError_Exception | WebServiceException exception){
                SqlUtil.storeTransaction(0, transaction, 1);
                throw exception;
            }
            catch(UserNotFound_Exception | AmountNotPositive_Exception | DuplicateFault_Exception | AgentAccessDenied_Exception | AgentAuthFailed_Exception exception){
                SqlUtil.storeTransaction(0, transaction, 2);
                throw exception;
            }
        }
        else if(!payment.equals(new Payment(transaction))){
            throw new DuplicateFault_Exception(null, null);
        }
        else {
            if(payment.getCode() != 1){
                return new HashMap<>(){
                    {
                        put("code", payment.getCode());
                    }
                };
            }
            else {
                long systemTransactionId = Client.pay(transaction);

                SqlUtil.updateTransaction(systemTransactionId, transaction.getAgentTransactionId(), 0);

                return new HashMap<>(){
                    {
                        put("transaction_id", systemTransactionId);
                    }
                };
            }
        }
    }
}
