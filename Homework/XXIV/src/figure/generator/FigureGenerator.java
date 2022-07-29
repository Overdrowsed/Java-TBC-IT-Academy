package figure.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FigureGenerator {
    public static void generate(){
        ExecutorService generator = Executors.newFixedThreadPool(3);

        generator.execute(() -> generateCircles());
        generator.execute(() -> generateRectangles());
        generator.execute(() -> generateTriangles());

        generator.shutdown();
    }

    private static void generateCircles() {
        try (FileWriter writer = new FileWriter("lib/Circles_in.dat")){            
            for(int i = 0; i < 30_000; i++){
                int radius = (int)(Math.random() * 99 + 1);
                
                if(i < 69_999)
                    writer.write(radius + "-");
                else
                    writer.write(String.valueOf(radius));
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void generateRectangles() {
        try (FileWriter writer = new FileWriter("lib/Rectangles_in.dat")){            
            for(int i = 0; i < 30_000; i++){
                int width = (int)(Math.random() * 99 + 1);
                int height = (int)(Math.random() * 99 + 1);

                writer.write(width + "-" + height + System.lineSeparator());
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void generateTriangles() {
        try (FileWriter writer = new FileWriter("lib/Triangles_in.dat")){ 
            for(int i = 0; i < 30_000; i++){
                int sideA = (int)(Math.random() * 99 + 1);
                int sideB = (int)(Math.random() * 99 + 1);
                //Third side is between the larger side and sideA + sideB to maintain triangle inequality
                int sideC = (int)(Math.random() * (sideA + sideB - Math.max(sideA, sideB)) + Math.max(sideA, sideB));

                writer.write(sideA + "-" + sideB + "-" + sideC + System.lineSeparator());
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}