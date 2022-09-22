package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import com.google.gson.JsonSyntaxException;

import authmanager.AuthValidator;
import config.ConfigManager;
import polygon.Triangle;
import util.JsonUtil;

@WebServlet(name = "GetTriangleWithPerimeter", urlPatterns = "/get_triangles_with_perimeter")
public class GetTriangleWithPerimeter extends HttpServlet {
    Logger logger = LogManager.getLogger("triangle_servlet");

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        ThreadContext.put("method", "doGet");
        
        response.setContentType("application/json");
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

        int requestedPerimeter = 0;

        try{
            requestedPerimeter = Integer.valueOf(request.getParameter("p"));

            if(requestedPerimeter <= 0)
                throw new Exception();
        }
        catch (Exception exception){
            String message = "Invalid perimeter arguement";

            response.sendError(400, message);
            logger.error(message);
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

        Triangle[] triangles = null;

        try{
            triangles = JsonUtil.jsonToTriangleArray(triangleDatabasePath);
        }
        catch (JsonSyntaxException exception){
            response.sendError(500);
            logger.fatal("Malformed triangle in database");
            return;
        }
        catch (IOException exception){
            response.sendError(500);
            logger.fatal("Triangle database couldn't be read");
            return;
        }

        final int finalRequestedPerimeter = requestedPerimeter;

        List<Triangle> trianglesWithMatchingPerimeter = Stream.of(triangles).filter(triangle -> triangle.getPerimeter() == finalRequestedPerimeter).collect(Collectors.toList());
        
        if(trianglesWithMatchingPerimeter.size() == 0){
            String message = "No triangle found with perimeter " + requestedPerimeter + " in the database";
            
            response.sendError(404, message);
            logger.error(message);
            return;
        }

        String trianglesJson = JsonUtil.trianglesToJson(trianglesWithMatchingPerimeter);

        PrintWriter out = response.getWriter();

        out.write(trianglesJson);

        out.flush();
        out.close();
    }
}