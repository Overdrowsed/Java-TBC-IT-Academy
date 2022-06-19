public class Rectangle extends Figure {

    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        if(width * height > 10000)
            throw new AreaTooLargeException();

        return width * height;
    }

    //implement
    public boolean validate() throws RectangleValidateException{
        if(width > 0 && height > 0)
            return true;
            
        throw new RectangleValidateException();
    }
}
