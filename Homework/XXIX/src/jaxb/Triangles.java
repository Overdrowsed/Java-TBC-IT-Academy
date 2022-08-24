package jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"triangle"})
@XmlRootElement(name = "Triangles")
public class Triangles {

    @XmlElement(name = "Triangle", required = true)
    private List<Triangles.Triangle> triangle;
    
    public List<Triangles.Triangle> getTriangles() {
        if (triangle == null) {
            triangle = new ArrayList<Triangles.Triangle>();
        }
        return this.triangle;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"a", "b", "c"})
    public static class Triangle {
        private int a, b, c;

        public int getA() {
            return a;
        }

        public void setA(int value) {
            this.a = value;
        }

        public int getB() {
            return b;
        }

        public void setB(int value) {
            this.b = value;
        }

        public int getC() {
            return c;
        }

        public void setC(int value) {
            this.c = value;
        }
    }
}
