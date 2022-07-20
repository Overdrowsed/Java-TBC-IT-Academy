package figure;
/**
 * Abstract {@code Figure} class that represent a blueprint for shapes.
 * Contains methods that the shapes should inherit.
 * 
 * @version 1.0
 * @author Luka Lomidze
 */
public abstract class Figure implements Comparable<Figure>{

    /**
     * A getter method for the perimeter of the shape.
     * 
     * @return perimeter of the shape
     */
    public abstract double getLength();

    /**
     * A getter method for the area of the shape.
     * 
     * @return area of the shape
     */
    public abstract double getArea();

    /**
     * Validates that the shape has a valid configuration.
     * 
     * @return {@code true} if the shape has a valid configuration, {@code false} otherwise
     */
    public abstract boolean validate();

    @Override
    public int compareTo(Figure other) {
        return Double.compare(this.getLength(), other.getLength());
    }
}
