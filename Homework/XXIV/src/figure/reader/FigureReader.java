package figure.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import figure.Circle;
import figure.Figure;
import figure.Rectangle;
import figure.Triangle;

public class FigureReader {
    public static List<Future<ArrayList<? extends Figure>>> readFigures(){
        ArrayList<Callable<ArrayList<? extends Figure>>> callables = new ArrayList<>();

        callables.add(() -> {return readCircles();});
        callables.add(() -> {return readRectangles();});
        callables.add(() -> {return readTriangles();});
        
        ExecutorService reader = Executors.newFixedThreadPool(3);

        try{
            var result = reader.invokeAll(callables);
            
            reader.shutdown();

            return result;
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return null;
    }

    public static ArrayList<Circle> readCircles(){
        String readPath = "lib/Circles_in.dat";

        ArrayList<Circle> circles = new ArrayList<>(); 

        try (Scanner circleReader = new Scanner(new File(readPath))){
            Scanner circleReaderDelimiter = circleReader.useDelimiter("-");
            
            while(circleReaderDelimiter.hasNext()){
                int radius = 0;
                
                try{
                    radius = Integer.valueOf(circleReaderDelimiter.next());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }
                
                Circle circle = new Circle(radius);

                if(circle.validate())
                    circles.add(circle);
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return circles;
    }

    public static ArrayList<Rectangle> readRectangles(){
        String readPath = "lib/Rectangles_in.dat";

        ArrayList<Rectangle> rectangles = new ArrayList<>();

        try (Scanner rectangleReader = new Scanner(new File(readPath))){
            while(rectangleReader.hasNextLine()){
                Scanner rectangleDelimier = new Scanner(rectangleReader.nextLine()).useDelimiter("-");

                int width = 0, height = 0;
                
                try{
                    width = Integer.valueOf(rectangleDelimier.next());
                    height = Integer.valueOf(rectangleDelimier.next());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }

                Rectangle rectangle = new Rectangle(width, height);

                if(rectangle.validate())
                    rectangles.add(rectangle);
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return rectangles;
    }

    public static ArrayList<Triangle> readTriangles(){
        String readPath = "lib/Triangles_in.dat";
        
        ArrayList<Triangle> triangles = new ArrayList<>();

        try (Scanner triangleReader = new Scanner(new File(readPath))){
            while(triangleReader.hasNextLine()){
                Scanner triangleDelimier = new Scanner(triangleReader.nextLine()).useDelimiter("-");
                
                int sideA = 0, sideB = 0, sideC = 0;
                
                try{
                    sideA = Integer.valueOf(triangleDelimier.next());
                    sideB = Integer.valueOf(triangleDelimier.next());
                    sideC = Integer.valueOf(triangleDelimier.next());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }

                Triangle triangle = new Triangle(sideA, sideB, sideC);

                if(triangle.validate())
                    triangles.add(triangle);
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return triangles;
    }
}