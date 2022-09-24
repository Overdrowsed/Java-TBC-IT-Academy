package homework.polygon;

public class Circle {
    
    public final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    
    public int getLength(){
        return (int)(2 * Math.PI * radius);
    }

    public int getArea(){
        return (int)(Math.PI * radius * radius);
    }

    public boolean validate(){
        return this.radius > 0;
    }

    @Override
    public String toString() {
        return "Circle [" + radius + "]";
    }
}
