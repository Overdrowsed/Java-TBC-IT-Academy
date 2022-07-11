package figure;

import java.util.Arrays;

public class Triangle extends Figure {
    private int sideA, sideB, sideC;

    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

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
    public boolean validate(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    @Override
    public String toString() {
        return "Triangle [" + sideA + ", " + sideB + ", " + sideC + "]";
    }
}
