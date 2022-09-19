package polygon;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"width", "height"})
public class Rectangle{
    private int width, height;
    
    public Rectangle(){}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDiagonal(){
        return (int)Math.sqrt(width * width + height * height);
    }

    public int getPerimeter(){
        return 2 * (width + height);
    }

    public int getArea(){
        return width * height;
    }

    public boolean validate(){
        return width > 0 && height > 0;
    }

    @Override
    public String toString() {
        return "Rectangle [" + width + ", " + height + "]";
    }
}
