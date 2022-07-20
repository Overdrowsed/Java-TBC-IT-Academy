package figure;
/**
 * {@code Figure} class that represent a blueprint for shapes.
 * Contains methods that the shapes should inherit.
 * 
 * @version 1.0
 * @author Luka Lomidze
 */
public class Figure implements Comparable<Figure>{

    /**
     * A getter method for the perimeter of the shape.
     * 
     * @return perimeter of the shape
     */
    public double getLength() { return -1;}

    /**
     * A getter method for the area of the shape.
     * 
     * @return area of the shape
     */
    public double getArea(){ return -1;}

    /**
     * Validates that the shape has a valid configuration.
     * 
     * @return {@code true} if the shape has a valid configuration, {@code false} otherwise
     */
    public boolean validate(){ return false;}

    @Override
    public int compareTo(Figure other) {
        return Double.compare(this.getLength(), other.getLength());
    }
}
