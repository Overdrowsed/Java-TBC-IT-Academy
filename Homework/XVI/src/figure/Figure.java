package figure;

public abstract class Figure implements Comparable<Figure> {
    
    public abstract double getLength();

    public abstract boolean validate();

    //Implement
    public int compareTo(Figure other){
        return Double.compare(this.getLength(), other.getLength());
    }
}
