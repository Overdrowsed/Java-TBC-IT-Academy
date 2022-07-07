package figure.comparator;

import java.util.Comparator;

import figure.Circle;

public class CircleComparatorAscending implements Comparator<Circle>{

    @Override
    public int compare(Circle first, Circle second) {
        return Double.compare(first.getLength(), second.getLength());
    }
    

}
