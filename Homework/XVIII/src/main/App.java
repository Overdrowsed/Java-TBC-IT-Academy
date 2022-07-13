package main;

import figure.Triangle;
import figure.exceptions.FigureValidatorException;
import figure.reader.FigureReader;

public class App {
    public static void main(String[] args) throws Exception {
        Triangle triangles = new Triangle("lib/Triangles_in.dat");

        triangles.printRightTriangles();

        System.out.println();

        try{
            System.out.println(FigureReader.getRectangleArrayList());
        }
        catch (FigureValidatorException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println();
        
        System.out.println(FigureReader.getCircleTreeSet());
    }
}
