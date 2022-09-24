package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBException;
import polygon.Triangle;
import util.XmlUtil;

@WebServlet(name = "GetTrianglesWithPerimeter", urlPatterns = "/get_triangles_with_perimeter")
public class GetTriangleWithPerimeter extends HttpServlet{
    Logger logger = LogManager.getLogger("triangle_servlet");

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {        
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");

        logger.info("Request received");

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

        String triangleDatabasePath = "D:/Programs/Tomcat/data/triangles.xml";
        
        List<Triangle> triangles = null;
        
        try{
            triangles = XmlUtil.xmlToTriangles(triangleDatabasePath);
        }
        catch (JAXBException exception){
            response.sendError(500);
            logger.fatal(exception);
            return;
        }
        catch (NullPointerException | IllegalArgumentException exception){
            response.sendError(500);
            logger.fatal("Triangle database couldn't be read", exception);
            return;
        }

        final int finalRequestedPerimeter = requestedPerimeter;

        List<Triangle> trianglesWithMatchingPerimeter = triangles.stream().filter(
            triangle -> triangle.getPerimeter() == finalRequestedPerimeter
        ).collect(Collectors.toList());
        
        if(trianglesWithMatchingPerimeter.size() == 0){
            String message = "No triangle found with perimeter " + requestedPerimeter + " in the database";
            
            response.sendError(404, message);
            logger.error(message);
            return;
        }
        
        try{
            XmlUtil.sendXmlResponse(trianglesWithMatchingPerimeter, response);
        }
        catch(JAXBException exception){
            response.sendError(500);
            logger.fatal(exception.getMessage());
        }

        logger.info("Succesfully processed request");
    }
}
