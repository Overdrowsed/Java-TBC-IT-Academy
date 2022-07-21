package figure;

public abstract class Figure implements Comparable<Figure>{
    
    public abstract double getLength();

    public abstract double getArea();

    public abstract boolean validate();

    @Override
    public int compareTo(Figure other) {
        return Double.compare(this.getLength(), other.getLength());
    }
}
