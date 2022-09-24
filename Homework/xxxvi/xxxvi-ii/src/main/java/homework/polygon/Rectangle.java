package homework.polygon;

public class Rectangle{
    public final int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getDiagonal(){
        return (int)Math.sqrt(width * width + height * height);
    }

    public int getPerimeter(){
        return 2 * (width + height);
    }

    public int getArea(){
        return width * height;
    }

    public boolean validate(){
        return width > 0 && height > 0;
    }

    @Override
    public String toString() {
        return "Rectangle [" + width + ", " + height + "]";
    }
}
