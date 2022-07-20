package figure;

/**
 * {@code Rectangle} class to represent the rectangle shape.
 * <p>
 * Contains two private fields: {@code width} and {@code height}
 * 
 * @version 1.0
 * @author Luka Lomidze
 */
public class Rectangle extends Figure{

    private double width, height;

    /**
     * Constructor for the {@code Rectangle} class.
     * 
     * @param width width of the constructed rectangle
     * @param height height of the constructed rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /** 
     * A getter method for the width of the rectangle.
     * 
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * A getter method for the height of the rectangle
     * 
     * @return the height of the rectangle
     */
    public double getHeight() {
        return height;
    }
    
    /** 
     * A getter method for the diagonal of the rectangle
     * 
     * @return the diagonal of the rectangle
     */
    public double getDiagonal(){
        return Math.sqrt(width * width + height * height);
    }

    
    /** 
     * A getter method for the perimeter of the rectangle
     * 
     * @return the perimeter of the rectangle
     */
    @Override
    public double getLength(){
        return 2 * (width + height);
    }

    /** 
     * A getter method for the area of the rectangle
     * 
     * @return the area of the rectangle
     */
    @Override
    public double getArea(){
        return width * height;
    }
    
    /**
     * Validates that the rectangle was constructed with valid {@code width} and {@code height} values.
     * 
     * @return {@code true} if width and height have a valid value, {@code false} if width, height or both have an invalid value
     */
    @Override
    public boolean validate(){
        return width > 0 && height > 0;
    }

    @Override
    public String toString() {
        return "Rectangle [" + width + ", " + height + "]";
    }

    /**
     * @deprecated as of version 1.0 as the better alternative is to define {@code getLength}
     * as a non-static method of the class, but will not be removed 
     * in order to maintain backward compatibility.
     * use {@link #getLength()} instead.
     * <p>
     * Returns the perimeter of the function arguement.
     * 
     * @param f the perimeter of the {@code Figure} to obtain
     */
    @Deprecated(since = "1.0", forRemoval = false)
    public static double getLengthStatic(Figure f){
        return f.getLength(); 
    }
}
