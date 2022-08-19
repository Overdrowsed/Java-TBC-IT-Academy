package main;

import figure.reader.FigureReader;

public class App {
    public static void main(String[] args) throws Exception {
        FigureReader.getCirclesToXML();
        FigureReader.getRectanglesToXML();
        FigureReader.getTrianglesToXML();

        FigureReader.printFiguresFromXMLDOM("out/");
        System.out.println();
        FigureReader.printFiguresFromXMLSAX("out/");

        System.out.println();

        FigureReader.compileEditXMLDOM("out/rectangles");
    }
}
