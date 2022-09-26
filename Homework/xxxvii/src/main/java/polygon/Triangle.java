package polygon;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"a", "b", "c"})
public class Triangle {    
    private int a, b, c;

    public Triangle(){}
    
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }   
}