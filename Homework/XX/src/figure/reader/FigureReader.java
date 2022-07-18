package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

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
        
        Collections.sort(circles);
        
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
    
    public static TreeSet<Circle> getCircleTreeSet(){
        String path = "lib/Circles_in.dat";

        TreeSet<Circle> circles = new TreeSet<>();
        
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

    public static TreeSet<Rectangle> getRectangleTreeSet(){
        String path = "lib/Rectangles_in.dat";

        TreeSet<Rectangle> rectangles = new TreeSet<>();

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

    public static TreeSet<Triangle> getTriangleTreeSet(){
        String path = "lib/Triangles_in.dat";

        TreeSet<Triangle> triangles = new TreeSet<>();

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

    public static TreeMap<Circle, Integer> getCircleTreeMap(){
        String path = "lib/Circles_in.dat";

        TreeMap<Circle, Integer> circles = new TreeMap<>();
        
        int lineIndex = 1;

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
                    circles.put(circle, lineIndex);

                lineIndex++;
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        
        return circles;
    }

    public static TreeMap<Rectangle, Integer> getRectangleTreeMap(){
        String path = "lib/Rectangles_in.dat";

        TreeMap<Rectangle, Integer> rectangles = new TreeMap<>();

        int lineIndex = 1;

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
                    rectangles.put(rectangle, lineIndex);
                
                lineIndex++;
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        return rectangles;
    }

    public static TreeMap<Triangle, Integer> getTriangleTreeMap(){
        String path = "lib/Triangles_in.dat";

        TreeMap<Triangle, Integer> triangles = new TreeMap<>();

        int lineIndex = 1;

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
                    triangles.put(triangle, lineIndex);
                
                lineIndex++;
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        return triangles;
    }
}