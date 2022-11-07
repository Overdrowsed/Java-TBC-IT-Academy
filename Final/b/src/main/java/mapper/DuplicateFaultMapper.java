package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.DuplicateFault_Exception;

@Provider
public class DuplicateFaultMapper implements ExceptionMapper<DuplicateFault_Exception>{
    @Override
    public Response toResponse(DuplicateFault_Exception e) {
        return Response.status(Status.CONFLICT).build();
    }
}