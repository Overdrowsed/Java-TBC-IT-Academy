package figure;

/**
 * {@code Circle} class to represent the circle shape.
 * <p>
 * Contains a single private field {@code radius}
 * 
 * @version 1.0
 * @author Luka Lomidze
 */
public class Circle extends Figure {
    
    private double radius;

    /**
     * Constructor for the {@code Circle} class.
     * 
     * @param radius radius of the constructed circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * A getter method for the radius of the circle.
     * 
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * A getter method for the length of the circle.
     * 
     * @return the length of the circle
     */
    @Override
    public double getLength(){
        return 2 * Math.PI * radius;
    }

    /**
     * A getter method for the area of the circle.
     * 
     * @return the area of the circle
     */
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

    /**
     * Validates that the circle was constructed with a valid {@code radius} value.
     * 
     * @return {@code true} if the radius has a valid value, {@code false} if the radius has an invalid value
     */
    @Override
    public boolean validate(){
        return this.radius > 0;
    }

    @Override
    public String toString() {
        return "Circle [" + radius + "]";
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
    @Deprecated(since = "0.9", forRemoval = false)
    public static double getLengthStatic(Figure f){
        return f.getLength(); 
    }
}
