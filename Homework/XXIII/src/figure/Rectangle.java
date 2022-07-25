package figure;

public class Rectangle extends Figure{

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDiagonal(){
        return Math.sqrt(width * width + height * height);
    }

    //Implement
    public double getLength(){
        return 2 * (width + height);
    }

    //Implement
    public double getArea(){
        return width * height;
    }

    //Implement
    public boolean validate(){
        return width > 0 && height > 0;
    }

    @Override
    public String toString() {
        return "Rectangle [" + width + ", " + height + "]";
    }
}
