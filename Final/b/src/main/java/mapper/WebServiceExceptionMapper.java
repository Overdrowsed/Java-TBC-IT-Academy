package mapper;

import java.net.SocketTimeoutException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.ws.WebServiceException;

@Provider
public class WebServiceExceptionMapper implements ExceptionMapper<WebServiceException>{
    private static final Logger logger = LogManager.getLogger("service_B");
    
    @Override
    public Response toResponse(WebServiceException e) {
        var cause = e.getCause();
        
        if(cause != null){
            if(cause.getClass().equals(SocketTimeoutException.class)){
                logger.error(e.getMessage());

                return Response.status(Status.REQUEST_TIMEOUT).build();
            }
        }

        logger.fatal(e.getMessage());
        
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}