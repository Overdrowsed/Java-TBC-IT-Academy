package figure.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import figure.Rectangle;

public class FigureReader {
    
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
}