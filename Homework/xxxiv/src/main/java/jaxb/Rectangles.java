package jaxb;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import polygon.Rectangle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"rectangle"})
@XmlRootElement(name = "rectangles")
public class Rectangles {

    @XmlElement(name = "rectangle", required = true)
    private List<Rectangle> rectangle;

    public Rectangles() {
        rectangle = new ArrayList<>();
    }

    public Rectangles(List<Rectangle> rectangles){
        this.rectangle = rectangles;
    }

    public void add(Rectangle rectangle){
        this.rectangle.add(rectangle);
    }

    public List<Rectangle> getRectangles() {
        return rectangle;
    }
}

