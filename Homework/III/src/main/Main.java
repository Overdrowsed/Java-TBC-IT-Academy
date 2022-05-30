package main;

import first.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(), rectangleTwo = new Rectangle();

        rectangle.setWidthHeight(5, 4);
        rectangleTwo.setWidthHeight(8, 4);

        System.out.println(rectangle.compareArea(rectangleTwo));

        second.Rectangle rectangleThree = new second.Rectangle(), rectangleFour = new second.Rectangle();

        rectangleThree.setWidthHeight(9, 5);
        rectangleFour.setWidthHeight(8, 5);

        System.out.println(rectangleThree.comparePerimeter(rectangleThree, rectangleFour));
    }
}