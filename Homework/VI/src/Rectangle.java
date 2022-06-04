public class Rectangle extends Figure{
    
    private int width, height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public double calculateDiagonal(){
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public double getPerimeter(){
        return 2 * (width + height);
    }
    
    @Override
    public double getArea(){
        return width * height;
    }

    @Override
    public String toString(){
        return "Rectangle with area " + this.getArea() + ", perimeter " + this.getPerimeter() + " and diagonal " + this.calculateDiagonal();
    }

    @Override
    public boolean equals(Object comparator){
        if(!(comparator instanceof Rectangle))
            return false;
        
        Rectangle other = (Rectangle)comparator;

        return this.getArea() == other.getArea();
    }
}
