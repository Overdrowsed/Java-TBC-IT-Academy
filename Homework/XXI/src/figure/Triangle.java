package figure;

import java.util.Arrays;

/**
 * {@code Triangle} class to represent the triangle shape.
 * <p>
 * Contains three private fields: {@code sideA} {@code sideB} and {@code sideC}
 * 
 * @version 1.0
 * @author Luka Lomidze
 */
public class Triangle extends Figure {
    private double sideA, sideB, sideC;

    /**
     * Constructor for the {@code Triangle} class.
     * 
     * @param sideA side a of the constructed triangle
     * @param sideB side b of the constructed triangle
     * @param sideC side c of the constructed triangle
     */
    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /** 
     * A getter method for the side a of the triangle.
     * 
     * @return side a of the triangle
     */
    public double getSideA() {
        return sideA;
    }

    /** 
     * A getter method for the side b of the triangle.
     * 
     * @return side b of the triangle
     */
    public double getSideB() {
        return sideB;
    }

    /** 
     * A getter method for the side c of the triangle.
     * 
     * @return side c of the triangle
     */
    public double getSideC() {
        return sideC;
    }

    /** 
     * A getter method for the perimeter of the triangle.
     * 
     * @return perimeter of the triangle
     */
    @Override
    public double getLength(){
        return sideA + sideB + sideC;
    }

    /** 
     * A getter method for the area of the triangle.
     * 
     * @return area of the triangle
     */
    @Override
    public double getArea(){
        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Validates that the triangle was constructed with valid {@code sideA} {@code sideB} and {@code sideC} values.
     * 
     * @return {@code true} if all the sides have a valid value, {@code false} if any of the sides has an invalid value
     */
    @Override
    public boolean validate(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    /**
     * Checks if the triangle is a right triangle.
     * 
     * @return {@code true} if the triangle is a right triangle, {@code false} otherwise
     */
    public boolean isRightTriangle(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }

    @Override
    public String toString() {
        return "Triangle [" + sideA + ", " + sideB + ", " + sideC + "]";
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
