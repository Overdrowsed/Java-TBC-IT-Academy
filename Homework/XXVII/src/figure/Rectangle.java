package figure;

public class Rectangle extends Figure{

    private int width, height;

    public Rectangle(){}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDiagonal(){
        return (int)Math.sqrt(width * width + height * height);
    }

    //Implement
    public int getLength(){
        return 2 * (width + height);
    }

    //Implement
    public int getArea(){
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
