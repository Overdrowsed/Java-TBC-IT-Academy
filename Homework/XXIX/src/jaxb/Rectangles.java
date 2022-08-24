package jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"rectangle"})
@XmlRootElement(name = "Rectangles")
public class Rectangles {

    @XmlElement(name = "Rectangle", required = true)
    private List<Rectangles.Rectangle> rectangle;
    
    public List<Rectangles.Rectangle> getRectangles() {
        if (rectangle == null) {
            rectangle = new ArrayList<Rectangles.Rectangle>();
        }
        return this.rectangle;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"a", "b"})
    public static class Rectangle {
        private int a, b;

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
    }
}
