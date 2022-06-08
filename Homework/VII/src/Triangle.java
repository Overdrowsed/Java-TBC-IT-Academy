import java.util.Arrays;

public class Triangle extends Figure{
    private int sideA, sideB, sideC;

    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void printFigureData(){
        System.out.println("Triangle with sides " + this.sideA + " " + this.sideB + " and " + this.sideC);
    }

    public void sayHelloToFigure(){
        System.out.println("Hello from triangle");
    }

    public boolean validateFigure(){
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    @Override
    public double getPerimeter(){
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea(){
        int p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
