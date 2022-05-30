package main;

import shapes.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5),
                  rectangleTwo = new Rectangle(35, 20),
                  rectangleThree = new Rectangle(),
                  rectangleFour = new Rectangle(8, 5);

        Rectangle[] rectangles = {rectangle, rectangleTwo, rectangleThree, rectangleFour};

        System.out.println(Rectangle.maxArea(rectangles).getWidthHeight());
    }
}