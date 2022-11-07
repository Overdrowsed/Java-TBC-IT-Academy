package jobs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import client.Client;
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
        try{
            logger.info("Attempting to retry payments...");

            List<Transaction> retriablePayments = SqlUtil.getRetriableTransactions();

            for(var payment : retriablePayments){
                Client.pay(payment);
            }
        }
        catch(UserNotFound_Exception | AmountNotPositive_Exception | DuplicateFault_Exception | AgentAccessDenied_Exception | AgentAuthFailed_Exception | InternalError_Exception exception){
            logger.fatal("Failed to retry payment");
        }
    }
}
