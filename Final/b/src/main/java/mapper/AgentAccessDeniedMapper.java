package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.AgentAccessDenied_Exception;

@Provider
public class AgentAccessDeniedMapper implements ExceptionMapper<AgentAccessDenied_Exception>{
    @Override
    public Response toResponse(AgentAccessDenied_Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}