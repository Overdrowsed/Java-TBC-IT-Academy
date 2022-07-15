package figure;

import java.util.Arrays;

public class Triangle extends Figure {
    private int sideA, sideB, sideC;

    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(){}

    public int getSideA() {
        return this.sideA;
    }

    public int getSideB() {
        return this.sideB;
    }

    public int getSideC() {
        return this.sideC;
    }

    //Implement
    public int getLength(){
        return sideA + sideB + sideC;
    }

    //Implement
    public int getArea(){
        float p = (sideA + sideB + sideC) / 2;

        return (int) Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    //Implement
    public boolean validate(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    @SuppressWarnings("unused")
    private boolean isRightTriangle(){
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }

    @Override
    public String toString() {
        return "Triangle [" + sideA + ", " + sideB + ", " + sideC + "]";
    }
}
