package figure;

import java.util.Arrays;

public class Triangle {    
    public final int sideA, sideB, sideC;
    
    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "Triangle [" + sideA + ", " + sideB + ", " + sideC + "]";
    }

    public boolean isRightTriangle(){
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }   
}