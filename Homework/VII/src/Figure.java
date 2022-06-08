public abstract class Figure implements IFigure, IFigureAnother{

    public abstract double getPerimeter();

    public abstract double getArea();

    public void printFigureAreaAndLength(){
        System.out.println("area: " + this.getArea() + ", perimeter: " + this.getPerimeter());
    }
}
