package figure.analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import figure.Circle;
import figure.Rectangle;
import figure.reader.FigureReader;

public class FigureAnalyzer {
    public static List<Future<Double>> getMinMaxRectangle(){
        ArrayList<Rectangle> rectangles = FigureReader.readRectangles();

        ArrayList<Callable<Double>> callables = new ArrayList<>();

        //min perimeter
        callables.add(() -> {return rectangles.stream().min(Comparator.naturalOrder()).map(Rectangle::getLength).get();});
        
        //max perimeter
        callables.add(() -> {return rectangles.stream().max(Comparator.naturalOrder()).map(Rectangle::getLength).get();});
        
        //min area
        callables.add(() -> {return rectangles.stream().min(Comparator.comparingDouble(Rectangle::getArea)).map(Rectangle::getArea).get();});
    
        //max area
        callables.add(() -> {return rectangles.stream().max(Comparator.comparingDouble(Rectangle::getArea)).map(Rectangle::getArea).get();});
    
        ExecutorService analyzer = Executors.newFixedThreadPool(4);

        try{
            var result = analyzer.invokeAll(callables);
            
            analyzer.shutdown();

            return result;
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return null;
    }

    public static void searchMaxTriangle(){   
        ScheduledExecutorService searcher = Executors.newSingleThreadScheduledExecutor();

        searcher.schedule(() -> {
            System.out.println(FigureReader.readTriangles().stream().max(Comparator.naturalOrder()).get());
        }, 5, TimeUnit.SECONDS);
        
        searcher.shutdown();
    }

    public static void readCirclesFixedRate(){
        ScheduledExecutorService reader = Executors.newSingleThreadScheduledExecutor();

        final AtomicInteger totalReads = new AtomicInteger(0);


        reader.scheduleAtFixedRate(() -> {totalReads.set(readCircles(totalReads.get(), 150)); if(totalReads.get() > 500) reader.shutdownNow();}, 0, 2, TimeUnit.SECONDS);
    }

    public static void readCirclesFixedDelay(){
        ScheduledExecutorService reader = Executors.newSingleThreadScheduledExecutor();

        AtomicInteger totalReads = new AtomicInteger(0);

        reader.scheduleWithFixedDelay(() -> {totalReads.set(readCircles(totalReads.get(), 250)); if(totalReads.get() > 700) reader.shutdownNow();}, 0, 3, TimeUnit.SECONDS);
    }

    private static int readCircles(int startIndex, int maxReadsPerInstance){
        String readPath = "lib/Circles_in.dat";

        int circleCount = 0, skips = 0;

        try (Scanner circleReader = new Scanner(new File(readPath))){
            Scanner circleReaderDelimiter = circleReader.useDelimiter("-");
            
            while(skips < startIndex){
                circleReaderDelimiter.next();
                skips++;
            }

            while(circleReaderDelimiter.hasNext() && circleCount < maxReadsPerInstance){
                int radius = 0;
                
                try{
                    radius = Integer.valueOf(circleReaderDelimiter.next());
                }
                catch (NumberFormatException | NoSuchElementException exception){
                    continue;
                }
                
                Circle circle = new Circle(radius);

                if(circle.validate()){
                    System.out.println(circle);
                    circleCount++;
                }
            }

        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return startIndex + circleCount;
    }
}
