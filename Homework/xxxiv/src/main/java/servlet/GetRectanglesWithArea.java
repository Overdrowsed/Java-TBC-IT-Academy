package servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

@WebServlet(name = "GetRectanglesWithArea", urlPatterns = "/get_rectangles_with_area")
public class GetRectanglesWithArea extends HttpServlet {
    Logger logger = LogManager.getLogger("rectangle_servlet");

    private static final long serialVersionUID = 1L;

    //@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "doGet");
        
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");

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

        int requestedArea = 0;

        try{
            requestedArea = Integer.valueOf(request.getParameter("s"));

            if(requestedArea <= 0)
                throw new Exception();
        }
        catch (Exception exception){
            String message = "Invalid area arguement";

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
        
        List<Rectangle> rectangles = null;
        
        try{
            rectangles = XmlUtil.xmlToRectangles(rectangleDatabasePath);
            logger.info(rectangleDatabasePath);
        }
        catch (JAXBException exception){
            response.sendError(500);
            logger.fatal(exception);
            return;
        }
        catch (NullPointerException exception){
            response.sendError(500);
            logger.fatal("Rectangle database couldn't be read", exception);
            return;
        }

        final int finalRequestedArea = requestedArea;

        List<Rectangle> rectanglesWithMatchingArea = rectangles.stream().filter(
            rectangle -> rectangle.getArea() == finalRequestedArea
        ).collect(Collectors.toList());
        
        if(rectanglesWithMatchingArea.size() == 0){
            String message = "No rectangle found with area " + requestedArea + " in the database";
            
            response.sendError(404, message);
            logger.error(message);
            return;
        }
        
        try{
            XmlUtil.sendXmlResponse(rectanglesWithMatchingArea, response);
        }
        catch(JAXBException exception){
            response.sendError(500);
            logger.fatal(exception.getMessage());
        }
    }
}