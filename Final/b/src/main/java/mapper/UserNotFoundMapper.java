package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.UserNotFound_Exception;

@Provider
public class UserNotFoundMapper implements ExceptionMapper<UserNotFound_Exception>{
    @Override
    public Response toResponse(UserNotFound_Exception e) {
        return Response.status(Status.NOT_FOUND).build();
    }
}