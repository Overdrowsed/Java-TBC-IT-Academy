package app;

public class Rectangle extends Figure{
    
    private int width, height;

    public Rectangle(){
        this(4, 3);
    }

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getPerimeter(){
        return 2 * (width + height);
    }
    
    @Override
    protected int getArea(){
        return width * height;
    }

    //Overload
    protected int getPerimeter(int width, int height){
        return 2 * (width + height);
    }
    
    //Overload
    protected int getArea(int width, int height){
        return width * height;
    }
}
