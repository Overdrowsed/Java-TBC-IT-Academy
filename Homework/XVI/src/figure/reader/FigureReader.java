package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;
import figure.comparator.CircleComparatorAscending;
import figure.comparator.TriangleComparatorDescending;

public class FigureReader {

    public static void readCircles(String fileName){
        String path = "lib/" + fileName;

        ArrayList<Circle> circles = new ArrayList<>();

        try (Scanner circleReader = new Scanner(new File(path))){
            while(circleReader.hasNextLine()){
                double radius = 0.0;
                
                try{
                    radius = Double.valueOf(circleReader.nextLine());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }

                Circle circle = new Circle(radius);

                if(circle.validate())
                    circles.add(circle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }


        circles.sort(new CircleComparatorAscending());


        try (FileWriter writer = new FileWriter("out/Circles_out.dat")){
            for(Circle circle : circles)
                writer.write(circle.getRadius() + System.lineSeparator());
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void readCirclesUnique(String fileName){
        String path = "lib/" + fileName;

        HashSet<Circle> uniqueCircles = new HashSet<>();

        try (Scanner circleReader = new Scanner(new File(path))){
            while(circleReader.hasNextLine()){
                double radius = 0.0;
                
                try{
                    radius = Double.valueOf(circleReader.nextLine());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }
                
                Circle circle = new Circle(radius);

                if(circle.validate())
                    uniqueCircles.add(circle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        

        try (FileWriter writer = new FileWriter("out/Circles_out_unique.dat")){
            for(Circle circle : uniqueCircles)
                writer.write(circle.getRadius() + System.lineSeparator());
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void readRectangles(String fileName){
        String path = "lib/" + fileName;

        TreeSet<Rectangle> rectangles = new TreeSet<>();

        try (Scanner rectangleReader = new Scanner(new File(path))){
            while(rectangleReader.hasNextLine()){
                Scanner sides = new Scanner(rectangleReader.nextLine()).useDelimiter("-");
                
                double width = 0.0, height = 0.0;

                try{
                    width = Double.valueOf(sides.next());
                    height = Double.valueOf(sides.next());

                    if(sides.hasNext())
                        throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Rectangle rectangle = new Rectangle(width, height);

                if(rectangle.validate())
                    rectangles.add(rectangle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }


        try (FileWriter writer = new FileWriter("out/Rectangles_out.dat")){
            for(Rectangle rectangle : rectangles)
                writer.write(rectangle.getWidth() + "-" + rectangle.getHeight() + System.lineSeparator());
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void readTriangles(String fileName){
        String path = "lib/" + fileName;

        TreeSet<Triangle> triangles = new TreeSet<>(new TriangleComparatorDescending());

        try (Scanner triangleReader = new Scanner(new File(path))){
            while(triangleReader.hasNextLine()){
                Scanner sides = new Scanner(triangleReader.nextLine()).useDelimiter("-");

                double sideA = 0.0, sideB = 0.0, sideC = 0.0;

                try{
                    sideA = Double.valueOf(sides.next());
                    sideB = Double.valueOf(sides.next());
                    sideC = Double.valueOf(sides.next());

                    if(sides.hasNext())
                        throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Triangle triangle = new Triangle(sideA, sideB, sideC);

                if(triangle.validate())
                    triangles.add(triangle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        try (FileWriter writer = new FileWriter("out/Triangles_out.dat")){
            for(Triangle triangle : triangles)
                writer.write(triangle.getSideA() + "-" + triangle.getSideB() + "-" + triangle.getSideC() + System.lineSeparator());
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}