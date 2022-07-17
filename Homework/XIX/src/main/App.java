package main;

import java.lang.reflect.Constructor;
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

        System.out.println(FigureReader.getCircleArrayListPrivateConstructor());
        System.out.println(FigureReader.getRectangleArrayListPrivateConstructor());
        System.out.println(FigureReader.getTriangleArrayListPrivateConstructor());


        System.out.println();


        Constructor<Circle> circleConstructor = null;
        Constructor<Rectangle> rectangleConstructor = null;
        Constructor<Triangle> triangleConstructor = null;

        try{
            circleConstructor = Circle.class.getDeclaredConstructor(int.class);
            rectangleConstructor = Rectangle.class.getDeclaredConstructor(int.class, int.class);
            triangleConstructor = Triangle.class.getDeclaredConstructor(int.class, int.class, int.class);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        
        circleConstructor.setAccessible(true);
        rectangleConstructor.setAccessible(true);
        triangleConstructor.setAccessible(true);
        
        Circle circle = null;
        Rectangle rectangle = null;
        Triangle triangle = null;

        try{
            circle = circleConstructor.newInstance(5);
            rectangle = rectangleConstructor.newInstance(10, 10);
            triangle = triangleConstructor.newInstance(3, 4, 5);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        
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

        try {
            figures.add(circleConstructor.newInstance(10));
            figures.add(rectangleConstructor.newInstance(4, 3));
            figures.add(rectangleConstructor.newInstance(5, 4));
            figures.add(rectangleConstructor.newInstance(16, 9));
            figures.add(rectangleConstructor.newInstance(21, 9));
            figures.add(triangleConstructor.newInstance(3, 4, 5));
            figures.add(triangleConstructor.newInstance(6, 6, 6));
            figures.add(triangleConstructor.newInstance(5, 12, 13));
            figures.add(triangleConstructor.newInstance(7, 24, 25));
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

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
