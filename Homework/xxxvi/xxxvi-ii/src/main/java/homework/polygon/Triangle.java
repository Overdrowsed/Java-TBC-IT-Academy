package homework.polygon;

import java.util.Arrays;

public class Triangle {    
    public final int a, b, c;
    
    public Triangle(int sideA, int sideB, int sideC){
        this.a = sideA;
        this.b = sideB;
        this.c = sideC;
    }

    public int getPerimeter(){
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle [" + a + ", " + b + ", " + c + "]";
    }

    public boolean validate(){
        if(a <= 0 || b <= 0 || c <= 0)
            return false;

        int[] sides = {a, b, c};
        Arrays.sort(sides);
        
        return sides[0] + sides[1] > sides[2];
    }   
}