package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import figure.Circle;
import figure.Rectangle;
import figure.Triangle;

public class FigureReader {

    public static ArrayList<Circle> getCircleArrayList(){
        String path = "lib/Circles_in.dat";

        ArrayList<Circle> circles = new ArrayList<>();
        
        try (Scanner circleReader = new Scanner(new File(path))){
            while(circleReader.hasNextLine()){
                int radius = 0;
                
                try{
                    radius = Integer.valueOf(circleReader.nextLine());
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
        
        return circles;
    }
    
    public static ArrayList<Rectangle> getRectangleArrayList(){
        String path = "lib/Rectangles_in.dat";

        ArrayList<Rectangle> rectangles = new ArrayList<>();

        try (Scanner rectangleReader = new Scanner(new File(path))){
            while(rectangleReader.hasNextLine()){
                Scanner sides = new Scanner(rectangleReader.nextLine()).useDelimiter("-");
                
                int width = 0, height = 0;
                
                try{
                    width = Integer.valueOf(sides.next());
                    height = Integer.valueOf(sides.next());
                    
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
        
        return rectangles;
    }

    public static ArrayList<Triangle> getTriangleArrayList(){
        String path = "lib/Triangles_in.dat";

        ArrayList<Triangle> triangles = new ArrayList<>();

        try (Scanner triangleReader = new Scanner(new File(path))){
            while(triangleReader.hasNextLine()){
                Scanner sides = new Scanner(triangleReader.nextLine()).useDelimiter("-");

                int sideA = 0, sideB = 0, sideC = 0;

                try{
                    sideA = Integer.valueOf(sides.next());
                    sideB = Integer.valueOf(sides.next());
                    sideC = Integer.valueOf(sides.next());

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

        return triangles;
    }

    public static ArrayList<Circle> getCircleArrayListWithReflection(){
        String path = "lib/Circles_in.dat";

        ArrayList<Circle> circles = new ArrayList<>();
        
        try (Scanner circleReader = new Scanner(new File(path))){
            while(circleReader.hasNextLine()){
                int radius = 0;
                
                try{
                    radius = Integer.valueOf(circleReader.nextLine());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }
                
                Circle circle = new Circle();

                try{
                    Field circleRadius = circle.getClass().getDeclaredField("radius");
                    circleRadius.setAccessible(true);
                    circleRadius.set(circle, radius);
                }
                //IllegalAccessExcetion | NoSuchFieldException
                catch(Exception exception){
                    System.out.println(exception.getMessage());
                }

                if(circle.validate())
                    circles.add(circle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        
        return circles;
    }
    
    public static ArrayList<Rectangle> getRectangleArrayListWithReflection(){
        String path = "lib/Rectangles_in.dat";

        ArrayList<Rectangle> rectangles = new ArrayList<>();

        try (Scanner rectangleReader = new Scanner(new File(path))){
            while(rectangleReader.hasNextLine()){
                Scanner sides = new Scanner(rectangleReader.nextLine()).useDelimiter("-");
                
                int width = 0, height = 0;
                
                try{
                    width = Integer.valueOf(sides.next());
                    height = Integer.valueOf(sides.next());
                    
                    if(sides.hasNext())
                    throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Rectangle rectangle = new Rectangle();

                try{
                    Field rectangleWidth = rectangle.getClass().getDeclaredField("width");
                    rectangleWidth.setAccessible(true);
                    rectangleWidth.set(rectangle, width);

                    Field rectangleHeight = rectangle.getClass().getDeclaredField("height");
                    rectangleHeight.setAccessible(true);
                    rectangleHeight.set(rectangle, height);
                }
                //IllegalAccessExcetion | NoSuchFieldException
                catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
                
                if(rectangle.validate())
                    rectangles.add(rectangle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        
        return rectangles;
    }

    public static ArrayList<Triangle> getTriangleArrayListWithReflection(){
        String path = "lib/Triangles_in.dat";

        ArrayList<Triangle> triangles = new ArrayList<>();

        try (Scanner triangleReader = new Scanner(new File(path))){
            while(triangleReader.hasNextLine()){
                Scanner sides = new Scanner(triangleReader.nextLine()).useDelimiter("-");

                int sideA = 0, sideB = 0, sideC = 0;

                try{
                    sideA = Integer.valueOf(sides.next());
                    sideB = Integer.valueOf(sides.next());
                    sideC = Integer.valueOf(sides.next());

                    if(sides.hasNext())
                        throw new RuntimeException("Too many sides");
                }
                //NumberFormatException | NoSuchElementException | RuntimeException
                catch (Exception exception){
                    continue;
                }
                
                Triangle triangle = new Triangle();

                try{
                    Field triangleSideA = triangle.getClass().getDeclaredField("sideA");
                    triangleSideA.setAccessible(true);
                    triangleSideA.set(triangle, sideA);

                    Field triangleSideB = triangle.getClass().getDeclaredField("sideB");
                    triangleSideB.setAccessible(true);
                    triangleSideB.set(triangle, sideB);

                    Field triangleSideC = triangle.getClass().getDeclaredField("sideC");
                    triangleSideC.setAccessible(true);
                    triangleSideC.set(triangle, sideC);
                }
                //IllegalAccessExcetion | NoSuchFieldException
                catch(Exception exception){
                    System.out.println(exception.getMessage());
                }

                if(triangle.validate())
                    triangles.add(triangle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        return triangles;
    }
}