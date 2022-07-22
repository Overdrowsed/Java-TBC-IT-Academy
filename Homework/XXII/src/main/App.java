package main;

import converter.ObjectToCustomStringConverter;
import figure.Rectangle;
import figure.Triangle;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(ObjectToCustomStringConverter.convert(new Triangle(3, 4, 5)));
        System.out.println(ObjectToCustomStringConverter.convert(new Rectangle(16, 9)));
        System.out.println(ObjectToCustomStringConverter.convert(new Triangle(0, 1, 2)));
        System.out.println(ObjectToCustomStringConverter.convert(new Object()));
    }
}
