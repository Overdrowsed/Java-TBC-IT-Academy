public class Rectangle implements Comparable{
    
    private int width, height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }

    public int getPerimeter(){
        return 2 * (width + height);
    }
    
    public int getArea(){
        return width * height;
    }

    @Override
    public boolean equals(Object comparator){
        if(!(comparator instanceof Rectangle))
            return false;
        
        Rectangle other = (Rectangle)comparator;

        return this.width == other.width && this.height == other.height;
    }

    @Override
    public String toString(){
        return "width: " + this.width + " height: " + this.height;
    }

    @Override
    public int compareTo(Object comparator){
        Rectangle other = (Rectangle)comparator;

        return this.equals(other)
               ? 0
               : Integer.compare(this.getArea(), other.getArea());
    }

    @Override
    public int hashCode(){
        return this.getArea();
    }
}

