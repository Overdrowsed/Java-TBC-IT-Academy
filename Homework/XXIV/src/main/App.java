package main;

import java.util.Comparator;
import java.util.concurrent.ExecutionException;

import figure.analyzer.FigureAnalyzer;
import figure.generator.FigureGenerator;
import figure.reader.FigureReader;
import figure.readerwriter.FigureReaderWriter;

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        FigureGenerator.generate();

        for(var entry : FigureReader.readFigures()){
            try {
                System.out.println(entry.get().stream().max(Comparator.naturalOrder()).get());
            } 
            catch (ExecutionException exception) {
                System.out.println(exception);
            }
        }

        FigureReaderWriter.readWrite(startTime, Long.valueOf(args[0]));

        for(var entry : FigureAnalyzer.getMinMaxRectangle()){
            System.out.println(entry.get());
        }

        FigureAnalyzer.searchMaxTriangle();
        
        FigureAnalyzer.readCirclesFixedRate();

        FigureAnalyzer.readCirclesFixedDelay();
    }
}