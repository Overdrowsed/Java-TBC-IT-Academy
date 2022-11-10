package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wsdl.UserNotFound_Exception;

@Provider
public class UserNotFoundMapper implements ExceptionMapper<UserNotFound_Exception>{
    private static final Logger logger = LogManager.getLogger("service_B");
    
    @Override
    public Response toResponse(UserNotFound_Exception e) {
        logger.error(e.getMessage());

        return Response.status(Status.NOT_FOUND).build();
    }
}