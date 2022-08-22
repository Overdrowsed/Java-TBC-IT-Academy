package figure.generator;

import java.util.ArrayList;
import java.util.List;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;

public class FigureGenerator {

    public static List<Circle> generateCircles() {
        ArrayList<Circle> circles = new ArrayList<>(); 
        
        for(int i = 0; i < 50; i++){
            circles.add(new Circle((int)(Math.random() * 99 + 1)));
        }

        return circles;
    }

    public static List<Rectangle> generateRectangles() {
        ArrayList<Rectangle> rectangles = new ArrayList<>(); 
        
        for(int i = 0; i < 50; i++){
            rectangles.add(new Rectangle(
                (int)(Math.random() * 99 + 1),
                (int)(Math.random() * 99 + 1))
            );
        }

        return rectangles;
    }

    public static List<Triangle> generateTriangles() {
        List<Triangle> triangles = new ArrayList<>();
        
        for(int i = 0; i < 50; i++){
            
            //Third side is between the larger side and sideA + sideB to maintain triangle inequality
            int sideA = (int)(Math.random() * 99 + 1);
            int sideB = (int)(Math.random() * 99 + 1);
            int sideC = (int)(Math.random() * (sideA + sideB - Math.max(sideA, sideB)) + Math.max(sideA, sideB));

            triangles.add(new Triangle(sideA, sideB, sideC));
        }

        return triangles;
    }
}