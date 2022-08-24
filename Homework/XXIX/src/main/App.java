package main;

import generator.FigureGenerator;
import util.JaxbUtil;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            JaxbUtil.serialize(FigureGenerator.generateCircles(), "out/circles_output.xml");
        } catch(Exception exception){
            System.out.println(exception);
        }

        try{
            JaxbUtil.serialize(FigureGenerator.generateRectangles(), "out/rectangles_output.xml");
        } catch(Exception exception){
            System.out.println(exception);
        }

        try{
            JaxbUtil.modifyTriangles("data/triangles_input.xml");
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
