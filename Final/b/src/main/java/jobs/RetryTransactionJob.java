package jobs;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import client.Client;
import jakarta.xml.ws.WebServiceException;
import util.SqlUtil;
import wsdl.AgentAccessDenied_Exception;
import wsdl.AgentAuthFailed_Exception;
import wsdl.AmountNotPositive_Exception;
import wsdl.DuplicateFault_Exception;
import wsdl.InternalError_Exception;
import wsdl.Transaction;
import wsdl.UserNotFound_Exception;

public class RetryTransactionJob implements Job{
    private static final Logger logger = LogManager.getLogger("service_B");

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ThreadContext.put("method", "execute");
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        
        Client.refreshRequestContext();
        SqlUtil.refreshConnection();
        
        int successfulRetries = 0;
        
        List<Transaction> retriablePayments = SqlUtil.getRetriableTransactions();
        
        if(retriablePayments.size() == 0){
            logger.info("No payments to retry");
            return;
        }

        logger.info("Attempting to retry payments...");

        for(var payment : retriablePayments){
            try{
                long systemTransactionId = Client.pay(payment);

                SqlUtil.updateRetriedTransaction(systemTransactionId, payment.getAgentTransactionId());

                successfulRetries++;
            }
            catch(UserNotFound_Exception | AmountNotPositive_Exception | DuplicateFault_Exception | AgentAccessDenied_Exception | AgentAuthFailed_Exception | InternalError_Exception | WebServiceException exception){
                logger.fatal("Failed to retry payment due to {} with message: {}", exception.getClass().getSimpleName(), exception.getMessage());
            }
        }

        logger.info("Successfully retried {} out of {} payments", successfulRetries, retriablePayments.size());
    }
}
