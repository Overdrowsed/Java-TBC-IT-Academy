package figure;

import java.util.Arrays;

public class Triangle extends Figure {
    private double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return this.sideA;
    }

    public double getSideB() {
        return this.sideB;
    }

    public double getSideC() {
        return this.sideC;
    }

    //Implement
    public double getLength(){
        return sideA + sideB + sideC;
    }

    //Implement
    public boolean validate(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }
}
