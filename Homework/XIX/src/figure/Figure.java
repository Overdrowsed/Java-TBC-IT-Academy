package figure;

public abstract class Figure implements Comparable<Figure>{
    
    public abstract int getLength();

    public abstract int getArea();

    public abstract boolean validate();

    @Override
    public int compareTo(Figure other) {
        return Integer.compare(this.getLength(), other.getLength());
    }
}
