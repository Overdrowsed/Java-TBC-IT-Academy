package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import beans.Person;
import beans.Persons;
import javax.xml.bind.JAXBException;

import manager.AuthValidator;
import manager.ConfigManager;
import manager.IpValidator;
import template.PersonWebServiceTemplate;
import util.JsonUtil;
import util.XmlUtil;

public class PersonWebService implements PersonWebServiceTemplate{
    private static final Logger logger = LogManager.getLogger("person_webservice");
    
    @Override
    public Response getPerson(String id, String username, String password, HttpServletRequest request){        
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "getPerson");

        logger.trace("Request - ip: {}, username: {}, password: {}, id: {}",
            request.getRemoteAddr(),
            username,
            password,
            id
        );
        
        //#region validation
        try{
            IpValidator.validate(request.getRemoteAddr());
        }
        catch(AuthenticationException exception){
            logger.error("Unauthorized client ip");
            return Response.status(Status.FORBIDDEN).entity("Unauthorized client ip").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            AuthValidator.validate(username, password);
        }
        catch(AuthenticationException exception){
            logger.error("Client passed invalid credentials");
            return Response.status(Status.UNAUTHORIZED).entity("Invalid username/password").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        //#endregion

        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        Person requestedPerson = null;

        try{
            requestedPerson = XmlUtil.xmlToPersons(databasePath).getPersons().stream()
                .filter(person -> person.getId().equals(id)).findAny().orElseThrow();
        }
        catch(NoSuchElementException exception){
            logger.error("No person found with id {}", id);
            return Response.status(Status.NOT_FOUND).entity("No person found with id " + id).build();
        }
        catch(JAXBException exception){
            logger.fatal("Malformed xml in database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(IllegalArgumentException exception){
            logger.fatal("Database couldn't be found");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.status(Status.OK).entity(requestedPerson).build();
    }

    @Override
    public Response addPerson(@Valid  Person newPerson, String username, String password, HttpServletRequest request) {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "addPerson");
        
        logger.trace("Request - ip: {}, username: {}, password: {}, object: {}",
            request.getRemoteAddr(),
            username,
            password,
            JsonUtil.toJson(newPerson)
        );
        
        //#region validation
        try{
            IpValidator.validate(request.getRemoteAddr());
        }
        catch(AuthenticationException exception){
            logger.error("Unauthorized client ip");
            return Response.status(Status.FORBIDDEN).entity("Unauthorized client ip").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            AuthValidator.validate(username, password);
        }
        catch(AuthenticationException exception){
            logger.error("Client passed invalid credentials");
            return Response.status(Status.UNAUTHORIZED).entity("Invalid username/password").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        //#endregion
        
        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            logger.fatal("Malformed xml in database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(IllegalArgumentException exception){
            logger.fatal("Database couldn't be found");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        if(persons.stream().anyMatch(person -> person.getId().equals(newPerson.getId()))){
            logger.error("Person already exists in database");
            return Response.status(Status.CONFLICT).entity("Person already exists in database").build();
        }

        persons.add(newPerson);

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            logger.fatal("Couldn't write to database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(JAXBException exception){
            logger.fatal("Jaxb exception occured");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.status(Status.OK).build();
    }
    
    @Override
    public Response updatePerson(Person updatedPerson, String username, String password, HttpServletRequest request) {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "updatePerson");
        
        logger.trace("Request - ip: {}, username: {}, password: {}, object: {}",
            request.getRemoteAddr(),
            username,
            password,
            JsonUtil.toJson(updatedPerson)
        );
        
        //#region validation
        try{
            IpValidator.validate(request.getRemoteAddr());
        }
        catch(AuthenticationException exception){
            logger.error("Unauthorized client ip");
            return Response.status(Status.FORBIDDEN).entity("Unauthorized client ip").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            AuthValidator.validate(username, password);
        }
        catch(AuthenticationException exception){
            logger.error("Client passed invalid credentials");
            return Response.status(Status.UNAUTHORIZED).entity("Invalid username/password").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        //#endregion
        
        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            logger.fatal("Malformed xml in database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(IllegalArgumentException exception){
            logger.fatal("Database couldn't be found");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            persons.set(persons.indexOf(updatedPerson), updatedPerson);
        }
        catch(IndexOutOfBoundsException exception){
            logger.error("No person matches given id");
            return Response.status(Status.NOT_FOUND).entity("No person matches given id").build();
        }

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            logger.fatal("Couldn't write to database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(JAXBException exception){
            logger.fatal("Jaxb exception occured");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.status(Status.OK).build();
    }

    @Override
    public Response deletePerson(String id, String username, String password, HttpServletRequest request) {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "deletePerson");
        
        logger.trace("Request - ip: {}, username: {}, password: {}, id: {}",
            request.getRemoteAddr(),
            username,
            password,
            id
        );

        //#region validation
        try{
            IpValidator.validate(request.getRemoteAddr());
        }
        catch(AuthenticationException exception){
            logger.error("Unauthorized client ip");
            return Response.status(Status.FORBIDDEN).entity("Unauthorized client ip").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            AuthValidator.validate(username, password);
        }
        catch(AuthenticationException exception){
            logger.error("Client passed invalid credentials");
            return Response.status(Status.UNAUTHORIZED).entity("Invalid username/password").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        //#endregion

        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        List<Person> persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath).getPersons();
        }
        catch(JAXBException exception){
            logger.fatal("Malformed xml in database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(IllegalArgumentException exception){
            logger.fatal("Database couldn't be found");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        if(!persons.removeIf(person -> person.getId().equals(id))){
            logger.error("No person with id {} found in database", id);
            return Response.status(Status.NOT_FOUND).build();
        }

        try{
            XmlUtil.personsToXml(persons, databasePath);
        }
        catch(FileNotFoundException exception){
            logger.fatal("Couldn't write to database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(JAXBException exception){
            logger.fatal("Jaxb exception occured");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.status(Status.OK).build();
    }

    @Override
    public Response listPersons(String username, String password, HttpServletRequest request) {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "listPersons");
        
        logger.trace("Request - ip: {}, username: {}, password: {}",
            request.getRemoteAddr(),
            username,
            password
        );

        //#region validation
        try{
            IpValidator.validate(request.getRemoteAddr());
        }
        catch(AuthenticationException exception){
            logger.error("Unauthorized client ip");
            return Response.status(Status.FORBIDDEN).entity("Unauthorized client ip").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        try{
            AuthValidator.validate(username, password);
        }
        catch(AuthenticationException exception){
            logger.error("Client passed invalid credentials");
            return Response.status(Status.UNAUTHORIZED).entity("Invalid username/password").build();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        //#endregion
        
        String databasePath = "";

        try{
            databasePath = ConfigManager.refreshIfUpdated().getConfigurationData().getDatabasePath();
        }
        catch(IOException exception){
            logger.fatal("Configuration couldn't be read");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        Persons persons = null;

        try{
            persons = XmlUtil.xmlToPersons(databasePath);
        }
        catch(JAXBException exception){
            logger.fatal("Malformed xml in database");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        logger.trace("Response - {}",
            JsonUtil.toJson(persons)
        );

        return Response.status(Status.OK).entity(persons).build();
    }
}