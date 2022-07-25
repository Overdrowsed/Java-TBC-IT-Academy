package main;

import figure.generator.FigureGenerator;
import figure.readerwriter.FigureReaderWriter;
import logger.ProcessLogger;

public class App {
    public static void main(String[] args) throws Exception {
        Thread generator = new FigureGenerator();
        Thread readerWriter = new FigureReaderWriter();
    
        Thread logger = new ProcessLogger(generator, readerWriter);
        
        logger.setDaemon(true);
        logger.start();
    
        generator.start();
        generator.join();
        
        readerWriter.start();
        readerWriter.join();
    }
}