package figure.analyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import figure.Circle;
import figure.Rectangle;
import figure.Triangle;
import utilities.Pair;

public class FigureAnalyzer {
    public static long radiusGreaterThan(ArrayList<Circle> circles, double threshold){
        return circles.stream().filter(circle -> circle.getRadius() > threshold).count();
    }

    public static ArrayList<Double> areaGreaterThan(ArrayList<Rectangle> rectangles, double threshold){
        return (ArrayList<Double>) rectangles.stream().filter(rectangle -> rectangle.getArea() > threshold).map(Rectangle::getHeight).collect(Collectors.toList());
    }

    public static void printRightTriangles(ArrayList<Triangle> triangles){
        triangles.stream().filter(triangle -> triangle.isRightTriangle()).map(Triangle::getLength).forEach(System.out::println);
    }

    public static Pair<Double, Double> minLengthMaxArea(Set<Circle> circles){
        return new Pair<>(
            circles.stream().max(Comparator.comparingDouble(Circle::getArea)).map(Circle::getArea).get(),
            circles.stream().min(Comparator.comparingDouble(Circle::getLength)).map(Circle::getLength).get()
        );
    }

    public static Set<Rectangle> filterRectangleDiagonal(Set<Rectangle> rectangles, double threshold){
        return rectangles.stream().filter(rectangle -> rectangle.getDiagonal() > threshold).collect(Collectors.toSet());
    }

    public static Set<Double> filterTrianglesPerimeter(Set<Triangle> triangles, double threshold){
        return triangles.stream().filter(triangle -> triangle.getLength() <= threshold).map(Triangle::getLength).collect(Collectors.toSet());
    }

    public static Map<Double, Long> groupIndenticalRadiusCount(ArrayList<Circle> circles){
        return circles.stream().collect(Collectors.groupingBy(Circle::getRadius, Collectors.counting()));
    }

    public static Map<Double, Double> groupIndenticalPerimeterWidth(ArrayList<Rectangle> rectangles){
        return rectangles.stream().collect(Collectors.groupingBy(Rectangle::getHeight, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingDouble(Rectangle::getWidth)), optionalRectangle -> optionalRectangle.map(Rectangle::getWidth).orElseThrow())));
    }

    public static Map<Double, DoubleSummaryStatistics> groupIndenticalSideSummarize(ArrayList<Triangle> triangles){
        return triangles.stream().collect(Collectors.groupingBy(Triangle::getSideA, Collectors.summarizingDouble(Triangle::getLength)));
    }
}
