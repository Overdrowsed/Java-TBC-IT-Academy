package figure;

public class Circle extends Figure {
    
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    //Implement
    public double getLength(){
        return 2 * Math.PI * radius;
    }

    //Implement
    public double getArea(){
        return Math.PI * radius * radius;
    }

    //Implement
    public boolean validate(){
        return this.radius > 0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Circle))
            return false;
        
        Circle other = (Circle) object;

        return this.getLength() == other.getLength();
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.getLength());
    }

    @Override
    public String toString() {
        return "Circle [" + radius + "]";
    }
}
