package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wsdl.DuplicateFault_Exception;

@Provider
public class DuplicateFaultMapper implements ExceptionMapper<DuplicateFault_Exception>{
    private static final Logger logger = LogManager.getLogger("service_B");
    
    @Override
    public Response toResponse(DuplicateFault_Exception e) {
        logger.error(e.getMessage());

        return Response.status(Status.CONFLICT).build();
    }
}