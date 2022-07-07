package figure;

public class Rectangle extends Figure implements Comparable<Rectangle>{

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    //Implement
    public double getLength(){
        return 2 * (width + height);
    }

    //Implement
    public boolean validate(){
        return width > 0 && height > 0;
    }

    //Implement
    public int compareTo(Rectangle other){
        return Double.compare(this.getLength(), other.getLength());
    }
}
