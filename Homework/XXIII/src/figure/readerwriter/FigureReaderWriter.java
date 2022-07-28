package figure.readerwriter;

import java.io.File;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;

public class FigureReaderWriter extends Thread {
    public void run(){
        Thread circleThread = new Thread(() -> readWriteCircles());
        Thread rectangleThread = new Thread (() -> readWriteRectangles());
        Thread triangleThread = new Thread (() -> readWriteTriangles());

        circleThread.start();
        rectangleThread.start();
        triangleThread.start();

        try{
            circleThread.join();
            rectangleThread.join();
            triangleThread.join();
        }
        catch(InterruptedException exception){
            System.out.println(exception);
        }
    }

    private static void readWriteCircles(){
        String readPath = "lib/Circles_in.dat", writePath = "out/Circles_out.dat";

        try (Scanner circleReader = new Scanner(new File(readPath)); FileWriter circleWriter = new FileWriter(writePath)){
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

                if(circle.validate()){
                    if(circleReaderDelimiter.hasNext())
                        circleWriter.write(radius + "#");
                    else
                        circleWriter.write(String.valueOf(radius));
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    private static void readWriteRectangles(){
        String readPath = "lib/Rectangles_in.dat", writePath = "out/Rectangles_out.dat";

        try (Scanner rectangleReader = new Scanner(new File(readPath)); FileWriter rectangleWriter = new FileWriter(writePath)){
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

                if(rectangle.validate()){
                    rectangleWriter.write(width + "#" + height + System.lineSeparator());
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }


    private static void readWriteTriangles(){
        String readPath = "lib/Triangles_in.dat", writePath = "out/Triangles_out.dat";
        
        try (Scanner triangleReader = new Scanner(new File(readPath)); FileWriter triangleWriter = new FileWriter(writePath)){
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

                if(triangle.validate()){
                    triangleWriter.write(sideA + "#" + sideB + "#" + sideC + System.lineSeparator());
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }
}
