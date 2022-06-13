import java.util.Comparator;

public class RectangleCompArea implements Comparator{
    
    @Override
    public int compare(Object objectOne, Object objectTwo){
        Rectangle first = (Rectangle) objectOne;
        Rectangle second = (Rectangle) objectTwo;

        return Integer.compare(first.getArea(), second.getArea());
    }
}