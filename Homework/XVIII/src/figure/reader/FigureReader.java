package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

import figure.Circle;
import figure.Figure;
import figure.Rectangle;
import figure.Triangle;
import figure.exceptions.FigureValidatorException;
import figure.validator.FigureValidator;
import utilities.Pair;

public class FigureReader {
    public enum Result{
        
        OK (0, "OK"),
        FileNotFound (1, "FileNotFound"),
        IOError (2, "IOError");
        
        int code;
        String message;
    
        private Result(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String toString(){
            return "[" + code + " - " + message + "]";
        }
    }
    
    public static Pair<Result, TreeSet<Circle>> getCircleTreeSet(){
        class CircleComparatorDescending implements Comparator<Circle>{

            //Implement
            public int compare(Circle first, Circle second) {
                return -1 * Integer.compare(first.getLength(), second.getLength());
            }
        }
        
        String path = "lib/Circles_in.dat";
        
        TreeSet<Circle> circles = new TreeSet<>(new CircleComparatorDescending());
        
        Result result = Result.OK;

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
            result = Result.FileNotFound;
        }
        catch(IOError error){
            result = Result.IOError;
        }

        
        return new Pair<Result, TreeSet<Circle>>(result, circles);
    }

    public static ArrayList<Rectangle> getRectangleArrayList() throws FigureValidatorException {
        String path = "lib/Rectangles_in.dat";

        ArrayList<Rectangle> rectangles = new ArrayList<>();

        try (Scanner rectangleReader = new Scanner(new File(path))){
            while(rectangleReader.hasNextLine()){
                Scanner sides = new Scanner(rectangleReader.nextLine()).useDelimiter("#");
                
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

                class RectangleValidator extends FigureValidator{
                    
                    //Implement
                    public void validate(Figure figure) throws FigureValidatorException{
                        
                        Rectangle rectangle = (Rectangle) figure;
        
                        if(!(rectangle.getWidth() > 0 && rectangle.getHeight() > 0)){
                            throw new FigureValidatorException();
                        }
                    }
                }
            
                RectangleValidator validator = new RectangleValidator();

                validator.validate(rectangle);

                rectangles.add(rectangle);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        
        return rectangles;
    }

    public static Triangle[] getTriangleArray(String path){

        int validTriangleCount = 0;
        
        try (Scanner lineCounter = new Scanner(new File(path))){
            while(lineCounter.hasNextLine()){
                Scanner sides = new Scanner(lineCounter.nextLine()).useDelimiter("-");
                
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
                    validTriangleCount++;
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        Triangle[] triangles = new Triangle[validTriangleCount];
        
        try (Scanner triangleReader = new Scanner(new File(path))){
            int currentIndex = 0;

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
                    triangles[currentIndex++] = triangle;
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        return triangles;
    }
}