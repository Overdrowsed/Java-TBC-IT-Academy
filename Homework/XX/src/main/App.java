package main;

import analyzer.FileAnalyzer;
import analyzer.NumberAnalyzer;
import figure.analyzer.FigureAnalyzer;
import figure.reader.FigureReader;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(FigureAnalyzer.radiusGreaterThan(FigureReader.getCircleArrayList(), 10));

        System.out.println();
        
        System.out.println(FigureAnalyzer.areaGreaterThan(FigureReader.getRectangleArrayList(), 100));

        System.out.println();

        FigureAnalyzer.printRightTriangles(FigureReader.getTriangleArrayList());

        System.out.println();

        System.out.println(FigureAnalyzer.minLengthMaxArea(FigureReader.getCircleTreeSet()));

        System.out.println();

        System.out.println(FigureAnalyzer.filterRectangleDiagonal(FigureReader.getRectangleTreeSet(), 50));

        System.out.println();

        System.out.println(FigureAnalyzer.filterTrianglesPerimeter(FigureReader.getTriangleTreeSet(), 29.5));
        
        System.out.println();

        System.out.println(FigureAnalyzer.groupIndenticalRadiusCount(FigureReader.getCircleArrayList()));
    
        System.out.println();

        System.out.println(FigureAnalyzer.groupIndenticalPerimeterWidth(FigureReader.getRectangleArrayList()));

        System.out.println();

        System.out.println(FigureAnalyzer.groupIndenticalSideSummarize(FigureReader.getTriangleArrayList()));

        System.out.println();

        System.out.println(NumberAnalyzer.printPrimes(1, 100));

        //lib/InputFile.dat out/OutputFile.dat
        FileAnalyzer.writeFile(args[0], args[1]);
    }
}
