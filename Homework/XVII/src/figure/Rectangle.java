package figure;

public class Rectangle extends Figure{

    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    //Implement
    public int getLength(){
        return 2 * (width + height);
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
