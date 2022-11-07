package client;

import java.io.IOException;

import javax.ws.rs.InternalServerErrorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.ws.BindingProvider;
import util.BindingUtil;
import wsdl.AgentAccessDenied_Exception;
import wsdl.AgentAuthFailed_Exception;
import wsdl.AmountNotPositive_Exception;
import wsdl.DuplicateFault_Exception;
import wsdl.InternalError_Exception;
import wsdl.ServiceA;
import wsdl.Transaction;
import wsdl.User;
import wsdl.UserNotFound_Exception;

public class Client {
    private static wsdl.ServiceTemplate service;
    private static BindingProvider bindingProvider;

    private static final Logger logger = LogManager.getLogger("service_B");

    static{
        try{
            service = new ServiceA().getServicePort();
            
            bindingProvider = (BindingProvider) service;
    
            BindingUtil.configureRequestContext(bindingProvider);
    
            BindingUtil.configureHandler(bindingProvider);
        }
        catch(IOException exception){
            logger.fatal(exception.getMessage());
        }
    }

    public static User getUser(int id) throws UserNotFound_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception {
        return service.check(id);
    }

    public static long pay(Transaction transaction) throws UserNotFound_Exception, AmountNotPositive_Exception, DuplicateFault_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception {
        return service.pay(transaction);
    }

    public static void refreshRequestContext() {
        try{
            BindingUtil.configureRequestContext(bindingProvider);
        }
        catch(IOException exception){
            logger.fatal("Unable to access configuration data");
            throw new InternalServerErrorException();
        }
    }
}
