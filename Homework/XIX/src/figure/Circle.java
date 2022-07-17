package figure;

public class Circle extends Figure {
    
    private int radius;

    @SuppressWarnings("unused")
    private Circle(int radius) {
        this.radius = radius;
    }

    public Circle(){}

    public int getRadius() {
        return this.radius;
    }
    
    //Implement
    public int getLength(){
        return (int)(2 * Math.PI * radius);
    }

    //Implement
    public int getArea(){
        return (int)(Math.PI * radius * radius);
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
