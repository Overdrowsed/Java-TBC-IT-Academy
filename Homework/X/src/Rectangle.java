public class Rectangle extends Figure {
    
    public static int counter;

    private int width, height;

    public Rectangle(int width, int height) {
        if(counter > 5)
            throw new LimitException();
        
        this.width = width;
        this.height = height;

        counter++;
    }

    //implement
    public boolean validate() throws RectangleValidateException{
        if(width > 0 && height > 0)
            return true;
            
        throw new RectangleValidateException();
    }
}
