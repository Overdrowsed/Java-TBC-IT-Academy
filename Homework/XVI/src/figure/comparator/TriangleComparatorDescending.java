package figure.comparator;

import java.util.Comparator;

import figure.Triangle;

public class TriangleComparatorDescending implements Comparator<Triangle>{

    @Override
    public int compare(Triangle first, Triangle second) {
        return -1 * Double.compare(first.getLength(), second.getLength());
    }
    
}
