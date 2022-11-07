package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.InternalError_Exception;

@Provider
public class InternalErrorMapper implements ExceptionMapper<InternalError_Exception>{
    @Override
    public Response toResponse(InternalError_Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}