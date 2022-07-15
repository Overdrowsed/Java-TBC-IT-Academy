package main;

import java.lang.reflect.Method;
import java.util.ArrayList;

import figure.Circle;
import figure.Figure;
import figure.Rectangle;
import figure.Triangle;
import figure.analyzer.FigureAnalyzer;
import figure.method.FigureMethod;
import figure.reader.FigureReader;

public class App {

    public static void main(String[] args) {

        System.out.println(FigureReader.getCircleArrayList());
        System.out.println(FigureReader.getRectangleArrayList());
        System.out.println(FigureReader.getTriangleArrayList());


        System.out.println();


        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(10, 10);
        
        System.out.println(FigureAnalyzer.analyzeMethods(circle));
        System.out.println(FigureAnalyzer.analyzeMethods(rectangle));
        System.out.println(FigureAnalyzer.analyzeMethods(triangle));


        System.out.println();


        System.out.println(FigureReader.getCircleArrayListWithReflection());
        System.out.println(FigureReader.getRectangleArrayListWithReflection());
        System.out.println(FigureReader.getTriangleArrayListWithReflection());


        System.out.println();


        System.out.println(FigureAnalyzer.invokeFigureMethod(circle, FigureMethod.GET_LENGTH));
        System.out.println(FigureAnalyzer.invokeFigureMethod(rectangle, FigureMethod.GET_AREA));
        System.out.println(FigureAnalyzer.invokeFigureMethod(triangle, FigureMethod.GET_LENGTH));

        System.out.println();


        ArrayList<Figure> figures = new ArrayList<>();

        figures.add(new Circle(10));
        figures.add(new Rectangle(4, 3));
        figures.add(new Rectangle(5, 4));
        figures.add(new Rectangle(16, 9));
        figures.add(new Rectangle(21, 9));
        figures.add(new Triangle(3, 4, 5));
        figures.add(new Triangle(6, 6, 6));
        figures.add(new Triangle(5, 12, 13));
        figures.add(new Triangle(7, 24, 25));

        System.out.println(FigureAnalyzer.countTriangles(figures));


        System.out.println();

        
        try{
            System.out.println(Circle.class.getMethod("hashCode").invoke(circle));
        }
        //NoSuchMethodException | IllegalAccessException | InvocationTargetException
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }


        System.out.println();

        
        try{
            Method isRightTriangle = triangle.getClass().getDeclaredMethod("isRightTriangle");
            isRightTriangle.setAccessible(true);
            System.out.println(isRightTriangle.invoke(triangle));

            Method isSquare = rectangle.getClass().getDeclaredMethod("isSquare");
            isSquare.setAccessible(true);
            System.out.println(isSquare.invoke(rectangle));
        }
        //NoSuchMethodException | IllegalAccessException | InvocationTargetException
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
