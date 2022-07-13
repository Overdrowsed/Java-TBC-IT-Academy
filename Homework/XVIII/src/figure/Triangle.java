package figure;

import java.util.Arrays;
import java.util.Iterator;
import figure.reader.FigureReader;

public class Triangle extends Figure {
    Triangle[] triangles;
    
    private int sideA, sideB, sideC;
    
    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    public Triangle(String filePath) {
        triangles = FigureReader.getTriangleArray(filePath);
    }
    
    public int getSideA() {
        return sideA;
    }
    
    public int getSideB() {
        return sideB;
    }
    
    public int getSideC() {
        return sideC;
    }

    //Implement
    public int getLength(){
        return sideA + sideB + sideC;
    }

    //Implement
    public boolean validate(){
        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        
        return (sides[0] + sides[1] > sides[2]) && sideA > 0 && sideB > 0 && sideC > 0;
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


    public void printRightTriangles(){
        RightTriangleIterator rightIterator = new RightTriangleIterator();

        while(rightIterator.hasNext()){
            System.out.println(rightIterator.next());
        }
    }

    class RightTriangleIterator implements Iterator<Triangle>{
        int nextIndex = 0;

        //Implement
        public boolean hasNext() {
            for(int i = nextIndex; i < triangles.length; i++){
                if(triangles[i].isRightTriangle()){
                    nextIndex = i;
                    return true;
                }
            }

            return false;
        }

        //Implement
        public Triangle next() {
            if(hasNext()){
                return triangles[nextIndex++];
            }

            return null;
        }   
    }

}
