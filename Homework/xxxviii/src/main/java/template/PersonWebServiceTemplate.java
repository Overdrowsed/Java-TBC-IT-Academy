package template;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Person;

@Path("/persons")
public interface PersonWebServiceTemplate {
    @GET
    @Path("/get_person")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response getPerson(
        @QueryParam("id") String id,
        @HeaderParam("username") String username,
        @HeaderParam("password") String password,
        @Context HttpServletRequest request
    );

    @POST
    @Path("/add_person")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response addPerson(
        Person newPerson,
        @HeaderParam("username") String username,
        @HeaderParam("password") String password,
        @Context HttpServletRequest request
    );

    @PUT
    @Path("/update_person")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response updatePerson(
        Person updatedPerson,
        @HeaderParam("username") String username,
        @HeaderParam("password") String password,
        @Context HttpServletRequest request
    );

    @DELETE
    @Path("/delete_person/{id}")
    Response deletePerson(
        @PathParam("id") String id,
        @HeaderParam("username") String username,
        @HeaderParam("password") String password,
        @Context HttpServletRequest request
    );

    @GET
    @Path("/list_persons")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response listPersons(
        @HeaderParam("username") String username,
        @HeaderParam("password") String password,
        @Context HttpServletRequest request
    );
}
