package mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import wsdl.AmountNotPositive_Exception;

@Provider
public class AmountNotPositiveMapper implements ExceptionMapper<AmountNotPositive_Exception>{
    @Override
    public Response toResponse(AmountNotPositive_Exception e) {
        return Response.status(Status.BAD_REQUEST).build();
    }
}