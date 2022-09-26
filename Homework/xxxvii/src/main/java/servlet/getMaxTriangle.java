package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import handler.TriangleDatabaseHandler;
import javax.xml.bind.JAXBException;
import polygon.Triangle;
import util.XmlUtil;

@WebServlet(name = "GetMaxPerimeterTriangle", urlPatterns = "/get_max_perimeter_triangle")
public class getMaxTriangle extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = LogManager.getLogger();

        List<Triangle> triangles = new ArrayList<>();

        try{
            triangles = XmlUtil.xmlToTriangles(TriangleDatabaseHandler.getTriangleDatabase());
        }
        catch(JAXBException exception){
            response.sendError(500);
            logger.fatal(exception.getMessage());
            return;
        }

        Triangle maxPerimeterTriangle = null;
        
        try{
            maxPerimeterTriangle = triangles.stream()
                .max(Comparator.comparing(Triangle::getPerimeter))
            .orElseThrow();
        }
        catch(NoSuchElementException exception){
            response.sendError(500);
            logger.fatal("Triangle database is empty");
            return;
        }

        try{
            XmlUtil.sendXmlResponse(maxPerimeterTriangle, response);
        }
        catch(JAXBException exception){
            response.sendError(500);
            logger.fatal(exception.getMessage());
            return;
        }
    }
}
