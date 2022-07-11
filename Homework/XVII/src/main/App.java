package main;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import analyzer.NumberAnalyzer;
import analyzer.StringAnalyzer;
import figure.Circle;
import figure.Rectangle;
import figure.Triangle;
import figure.analyzer.FigureAnalyzer;
import figure.reader.FigureReader;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Circle> circleArrayList = FigureReader.getCircleArrayList();
        ArrayList<Rectangle> rectangleArrayList = FigureReader.getRectangleArrayList();
        ArrayList<Triangle> triangleArrayList = FigureReader.getTriangleArrayList();

        TreeSet<Circle> circleTreeSet = FigureReader.getCircleTreeSet();
        TreeSet<Rectangle> rectangleTreeSet = FigureReader.getRectangleTreeSet();
        TreeSet<Triangle> triangleTreeSet = FigureReader.getTriangleTreeSet();

        TreeMap<Circle, Integer> circleTreeMap = FigureReader.getCircleTreeMap();
        TreeMap<Rectangle, Integer> rectangleTreeMap = FigureReader.getRectangleTreeMap();
        TreeMap<Triangle, Integer> triangleTreeMap = FigureReader.getTriangleTreeMap();

        System.out.println(FigureAnalyzer.arrayListGetMinMax(circleArrayList).second);
        System.out.println(FigureAnalyzer.arrayListGetMinMax(rectangleArrayList).second);
        System.out.println(FigureAnalyzer.arrayListGetMinMax(triangleArrayList).second);

        System.out.println();

        System.out.println(FigureAnalyzer.treeSetGetMinMax(circleTreeSet).second);
        System.out.println(FigureAnalyzer.treeSetGetMinMax(rectangleTreeSet).second);
        System.out.println(FigureAnalyzer.treeSetGetMinMax(triangleTreeSet).second);

        System.out.println();

        System.out.println(FigureAnalyzer.treeMapGetMinMax(circleTreeMap).second);
        System.out.println(FigureAnalyzer.treeMapGetMinMax(rectangleTreeMap).second);
        System.out.println(FigureAnalyzer.treeMapGetMinMax(triangleTreeMap).second);

        System.out.println();

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);

        System.out.println(NumberAnalyzer.minMaxAverage(numbers));

        System.out.println();

        ArrayList<String> strings = new ArrayList<>();

        strings.add("a");
        strings.add("ab");
        strings.add("abcd");
        strings.add("abcdefg");
        strings.add("abcdefgh");
        strings.add("abcdefghij");

        System.out.println(StringAnalyzer.minMaxAverage(strings));
    }
}
