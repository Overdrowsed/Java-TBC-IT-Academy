package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import figure.Circle;
import figure.Figure;
import figure.Rectangle;
import figure.Triangle;
import figure.reader.FigureReader;

@FunctionalInterface
interface FigureAdder{
    double sum(Figure first, Figure second);
}

public class App {
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static void main(String[] args){
        System.out.println(Rectangle.getLengthStatic(new Rectangle(16, 9)));

        System.out.println();

        ArrayList rectangles = FigureReader.getRectangleArrayList();

        System.out.println(rectangles);

        System.out.println();

        List figures = FigureReader.getRectangleArrayList();

        System.out.println(varArgsClassCastException(figures));

        System.out.println(varArgsClassCastExceptionFixed(figures));

        System.out.println();

        FigureAdder sumPerimeter = (first, second) -> {
            return first.getLength() + second.getLength();
        };

        FigureAdder sumArea = (first, second) -> {
            return first.getArea() + second.getArea();
        };

        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println(sumPerimeter.sum(circle, triangle) + " " + sumArea.sum(circle, triangle));
    }

    public static Figure varArgsClassCastException(List<Figure>... lists){
        Object[] array = lists;
        array[0] = Arrays.asList(17);
        return lists[0].get(0);
    }

    @SafeVarargs
    public static Figure varArgsClassCastExceptionFixed(List<Figure>... figures){
        return figures[0].get(0);
    }
}
