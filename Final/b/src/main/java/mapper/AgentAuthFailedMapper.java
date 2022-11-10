package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wsdl.AgentAuthFailed_Exception;

@Provider
public class AgentAuthFailedMapper implements ExceptionMapper<AgentAuthFailed_Exception>{
    private static final Logger logger = LogManager.getLogger("service_B");

    @Override
    public Response toResponse(AgentAuthFailed_Exception e) {
        logger.fatal(e.getMessage());
        
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}