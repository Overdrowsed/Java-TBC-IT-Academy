package jaxb;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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

    public Triangles(List<Triangle> triangles){
        this.triangle = triangles;
    }

    public void add(Triangle triangle){
        this.triangle.add(triangle);
    }

    public List<Triangle> getTriangles() {
        return triangle;
    }
}