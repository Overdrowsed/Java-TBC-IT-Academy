package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.AgentAuthFailed_Exception;

@Provider
public class AgentAuthFailedMapper implements ExceptionMapper<AgentAuthFailed_Exception>{
    @Override
    public Response toResponse(AgentAuthFailed_Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}