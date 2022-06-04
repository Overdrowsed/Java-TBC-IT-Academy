import java.util.Arrays;

public class Triangle extends Figure{
    private int sideA, sideB, sideC, heightC, angleA, angleB;

    public Triangle(int sideA, int sideB, int sideC, int heightC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        this.heightC = heightC;
    }

    public int triangleType(){
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);

        int a = sides[0] * sides[0] + sides[1] * sides[1],
            b = sides[2] * sides[2];
        
        return a == b ? 0 : a < b ? -1 : 1;
    }

    @Override
    public double getPerimeter(){
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea(){
        return (sideC * heightC) / 2;
    }

    @Override
    public String toString(){
        return "Triangle with area " + this.getArea() + ", perimeter " + this.getPerimeter() + " and type " + this.triangleType();
    }

    @Override
    public boolean equals(Object comparator){
        if(!(comparator instanceof Triangle))
            return false;
        
        Triangle other = (Triangle)comparator;

        return this.getPerimeter() == other.getPerimeter();
    }
}
