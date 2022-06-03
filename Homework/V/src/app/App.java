package app;

import app.square.Square;

public class App {
    public static void main(String[] args){
        Figure shape = new Figure("Figure initialized");
        Rectangle rectangle = new Rectangle(5, 4);
        
        System.out.println(shape.getArea() + " " + shape.getPerimeter() + " " + rectangle.getArea() + " " + rectangle.getPerimeter());

        System.out.println(rectangle instanceof Figure); //true
        System.out.println(rectangle instanceof Rectangle); //true
        System.out.println(shape instanceof Figure); //true
        System.out.println(shape instanceof Rectangle); //false

        Rectangle rectangleTwo = new Rectangle();
        System.out.println(rectangleTwo.getArea());

        System.out.println(rectangle.getArea(6, 5) + " " + rectangle.getPerimeter(7, 3));

        Square square = new Square(5);

        System.out.println(square.getArea() + " " + square.getPerimeter());
    }
}
