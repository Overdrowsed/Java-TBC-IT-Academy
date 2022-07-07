package main;

import figure.reader.FigureReader;

public class App {
    public static void main(String[] args) throws Exception {
        //Circles_in.dat Rectangles_in.dat Triangles_in.dat
        FigureReader.readCircles(args[0]);
        FigureReader.readCirclesUnique(args[0]);
        FigureReader.readRectangles(args[1]);
        FigureReader.readTriangles(args[2]);
    }
}
