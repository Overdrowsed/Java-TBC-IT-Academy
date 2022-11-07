package mapper;

import java.net.SocketTimeoutException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import jakarta.xml.ws.WebServiceException;

@Provider
public class WebServiceExceptionMapper implements ExceptionMapper<WebServiceException>{
    @Override
    public Response toResponse(WebServiceException e) {
        if(e.getCause().getClass().equals(SocketTimeoutException.class)){
            return Response.status(Status.REQUEST_TIMEOUT).build();
        }

        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}