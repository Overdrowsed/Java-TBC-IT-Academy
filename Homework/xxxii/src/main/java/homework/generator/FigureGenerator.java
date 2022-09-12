package homework.generator;

import java.util.List;

import homework.jaxb.Circles;
import homework.jaxb.Rectangles;

public class FigureGenerator {

    public static Circles generateCircles() {
        Circles circles = new Circles();

        List<Circles.Circle> circlesList = circles.getCircle();

        for(int i = 0; i < 1000; i++){
            Circles.Circle circle = new Circles.Circle();
            circle.setRadius((int)(Math.random() * 99 + 1));

            circlesList.add(circle);
        }

        return circles;
    }

    public static Rectangles generateRectangles() {
        Rectangles rectangles = new Rectangles();

        List<Rectangles.Rectangle> rectanglesList = rectangles.getRectangles();
        
        for(int i = 0; i < 1000; i++){
            Rectangles.Rectangle rectangle = new Rectangles.Rectangle();
            rectangle.setA((int)(Math.random() * 99 + 1));
            rectangle.setB((int)(Math.random() * 99 + 1));

            rectanglesList.add(rectangle);
        }

        return rectangles;
    }
}