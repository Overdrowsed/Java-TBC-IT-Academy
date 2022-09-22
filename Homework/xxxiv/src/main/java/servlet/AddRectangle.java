package servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import authmanager.AuthValidator;
import config.ConfigManager;
import jakarta.xml.bind.JAXBException;
import polygon.Rectangle;
import util.XmlUtil;

@WebServlet(name = "AddRectangle", urlPatterns = "/add_rectangle")
public class AddRectangle extends HttpServlet {
    Logger logger = LogManager.getLogger("rectangle_servlet");

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "doPost");
        
        try{
            if(!AuthValidator.validate(request, response)){
                logger.error("Incorrect username/password");
                return;
            }
        }
        catch (IOException exception){
            response.sendError(500);
            logger.fatal("Configuration file couldn't be read");
            return;
        }

        logger.info("Authentication successful");

        Rectangle newRectangle = null;

        try{
            newRectangle = XmlUtil.streamToRectangle(request.getInputStream());
        }
        catch(JAXBException exception){
            String message = "Request body is an invalid xml";

            response.sendError(400, message);
            logger.error(message);
            return;
        }

        String rectangleDatabasePath = "";

        try{
            rectangleDatabasePath = ConfigManager.getConfiguration().getResourcePath().getDatabasePath();
        }
        catch(IOException exception){
            response.sendError(500);
            logger.fatal("Configuration file couldn't be read");
            return;
        }

        try{
            XmlUtil.updateRectangleDatabase(rectangleDatabasePath, newRectangle);
        }
        catch (JAXBException | IllegalArgumentException exception){
            String message = "Invalid rectangle in request body";
            
            response.sendError(400, message);
            logger.error(message);
            return;
        }
        catch (FileNotFoundException exception){
            String message = "Rectangle database couldn't be read";
            
            response.sendError(500);
            logger.fatal(message);
            return;
        }
    }
}
