package servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import authmanager.AuthValidator;
import config.ConfigManager;
import polygon.Triangle;
import util.JsonUtil;

@WebServlet(name = "AddTriangle", urlPatterns = "/add_triangle")
public class AddTriangle extends HttpServlet {
    Logger logger = LogManager.getLogger();

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

        Gson json = new Gson();

        Triangle newTriangle = null;

        try{
            newTriangle = json.fromJson(request.getReader(), Triangle.class);
        }
        catch(JsonSyntaxException exception){
            String message = "Request body is an invalid json";

            response.sendError(400, message);
            logger.error(message);
            return;
        }
        catch(JsonIOException exception){
            String message = "Unable to read from request";

            response.sendError(500);
            logger.fatal(message);
            return;
        }

        String triangleDatabasePath = "";

        try{
            triangleDatabasePath = ConfigManager.getConfiguration().getResourcePath().getDatabasePath();
        }
        catch(IOException exception){
            response.sendError(500);
            logger.fatal("Configuration file couldn't be read");
            return;
        }

        try{
            JsonUtil.updateTriangleDatabase(triangleDatabasePath, newTriangle);
        }
        catch (IllegalArgumentException | JsonSyntaxException | NullPointerException exception){
            String message = "Invalid triangle in request body";
            
            response.sendError(400, message);
            logger.error(message);
            return;
        }
        catch (IOException exception){
            String message = "Triangle database couldn't be read";
            
            response.sendError(500);
            logger.fatal(message);
            return;
        }
    }
}
