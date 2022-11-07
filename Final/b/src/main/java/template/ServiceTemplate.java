package template;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import wsdl.AgentAccessDenied_Exception;
import wsdl.AgentAuthFailed_Exception;
import wsdl.AmountNotPositive_Exception;
import wsdl.DuplicateFault_Exception;
import wsdl.InternalError_Exception;
import wsdl.Transaction;
import wsdl.User;
import wsdl.UserNotFound_Exception;

@Path("/service")
public interface ServiceTemplate {
    @GET
    @Path("/get_user/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    User getUser(
        @PathParam("user_id") int id
    ) throws UserNotFound_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception;

    @POST
    @Path("/fill_balance")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Number> fillBalance(
        Transaction transaction
    ) throws UserNotFound_Exception, AmountNotPositive_Exception, DuplicateFault_Exception, AgentAccessDenied_Exception, AgentAuthFailed_Exception, InternalError_Exception;
}
