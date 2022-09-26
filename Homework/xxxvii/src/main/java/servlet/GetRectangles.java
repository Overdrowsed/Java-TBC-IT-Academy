package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import handler.RectangleDatabaseHandler;
import polygon.Rectangle;
import util.JsonUtil;

@WebServlet(name = "GetRectangles", urlPatterns = "/get_rectangles")
public class GetRectangles extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = LogManager.getLogger();

        logger.info("Request received");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String rectangleJson = "";

        try{
            rectangleJson = RectangleDatabaseHandler.getRectangleDatabase();
        }
        catch(Exception exception){
            response.sendError(500);
            logger.fatal("Databases couldn't be read");
            return;
        }
        
        int requestedPerimeter = Integer.valueOf(request.getParameter("p"));

        List<Rectangle> rectanglesWithMatchingPerimeter = 
            JsonUtil.jsonToList(rectangleJson, Rectangle.class)
            .stream()
            .filter(rectangle -> rectangle.getPerimeter() == requestedPerimeter)
        .collect(Collectors.toList());

        if(rectanglesWithMatchingPerimeter.size() == 0){
            response.sendError(404, "No rectangles found with matching perimeter in the database");
            return;
        }

        response.getWriter().write(JsonUtil.listToJsonString(rectanglesWithMatchingPerimeter));

        logger.info("Request processed");
    }
}
