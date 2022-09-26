package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import polygon.Triangle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"triangle"})
@XmlRootElement(name = "triangles")
public class Triangles {

    @XmlElement(name = "triangle", required = true)
    private List<Triangle> triangle;

    public Triangles() {
        triangle = new ArrayList<>();
    }

    public Triangles(List<Triangle> triangle) {
        this.triangle = triangle;
    }

    public List<Triangle> getTriangles() {
        return triangle;
    }

    public void add(Triangle triangle){
        this.triangle.add(triangle);
    }
}
