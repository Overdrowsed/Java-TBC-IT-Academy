import java.util.Comparator;

public class RectangleCompPerimeterDesc implements Comparator{
   
    @Override
    public int compare(Object one, Object two){
        Rectangle first = (Rectangle) one;
        Rectangle second = (Rectangle) two;

        return -1 * Integer.compare(first.getPerimeter(), second.getPerimeter());
    }
}
