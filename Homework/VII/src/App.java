public class App {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 3),
                  rectangle2 = new Rectangle(0, -5);

        Triangle triangle = new Triangle(3, 4, 5),
                 triangle2 = new Triangle(-6, -7, -8);

        printData(rectangle);
        printData(triangle);
        
        printFigure(rectangle);
        printFigure(rectangle2);
        printFigure(triangle);
        printFigure(triangle2);
    }

    static void printData(IFigure figure){
        figure.printFigureData(); 
        figure.printFigureAreaAndLength();
    }

    static void printFigure(IFigureAnother figure){
        if(figure.validateFigure())
            figure.sayHelloToFigure();
        else
            System.out.println("Invalid Figure");
    }
}
