import java.util.Arrays;

public class Triangle extends Figure {
    private int sideA, sideB, sideC;

    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    //implement
    public boolean validate() throws TriangleValidateException{
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        if((sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0)
            return true;

        throw new TriangleValidateException();
    }
}
