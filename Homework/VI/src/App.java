public class App {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(8, 6);
        Triangle triangle = new Triangle(5, 5, 6, 4);

        printFigure(rectangle);
        printFigure(triangle);

        Rectangle rectangle2 = new Rectangle(8, 6),
                  rectangle3 = new Rectangle(9, 5);

        Triangle triangle2 = new Triangle(5, 5, 6, 4),
                 triangle3 = new Triangle(10, 10, 16, 6);


        System.out.println(compareFigure(triangle, rectangle));

        System.out.println(compareFigure(rectangle, rectangle2));
        System.out.println(compareFigure(rectangle, rectangle3));

        System.out.println(compareFigure(triangle, triangle2));
        System.out.println(compareFigure(triangle, triangle3));
    }

    public static void printFigure(Figure figure){
        switch(figure.getClass().toString()){
            case "class Rectangle":
                Rectangle rectangle = (Rectangle) figure;
                System.out.println(rectangle);
                break;

            case "class Triangle":
                Triangle triangle = (Triangle) figure;
                System.out.println(triangle);
        }
    }

    public static boolean compareFigure(Figure first, Figure second) {
        return first.equals(second);
    }
}
