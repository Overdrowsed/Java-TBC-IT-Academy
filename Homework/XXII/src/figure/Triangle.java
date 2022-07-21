package figure;

import java.util.Arrays;

import converter.annotation.CustomStringSerializable;
import converter.annotation.SkipSerialization;
import converter.annotation.Validator;

@CustomStringSerializable
public class Triangle extends Figure {
    private double sideA;
    @Validator(min=5) 
    private double sideB;
    @SkipSerialization
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    //Implement
    public double getLength(){
        return sideA + sideB + sideC;
    }

    //Implement
    public double getArea(){
        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    //Implement
    @Validator
    public boolean validate(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    public boolean isRightTriangle(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }

    @Override
    public String toString() {
        return "Triangle [" + sideA + ", " + sideB + ", " + sideC + "]";
    }
}
