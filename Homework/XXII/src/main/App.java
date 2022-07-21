package main;

import converter.ObjectToCustomStringConverter;
import figure.Triangle;

public class App {
    public static void main(String[] args) throws Exception {
        Triangle triangle = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(0, 1, 2);

        System.out.println(ObjectToCustomStringConverter.convert(triangle));
        System.out.println(ObjectToCustomStringConverter.convert(triangle2));
    }
}
