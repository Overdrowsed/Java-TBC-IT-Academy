public class Rectangle extends Figure{
    
    private int width, height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void printFigureData(){
        System.out.println("Rectangle with width " + this.width + " and height " + this.height);
    }

    public void sayHelloToFigure(){
        System.out.println("Hello from rectangle");
    }

    public boolean validateFigure(){
        return width > 0 && height > 0;
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
    public boolean equals(Object comparator){
        if(!(comparator instanceof Rectangle))
            return false;
        
        Rectangle other = (Rectangle)comparator;

        return this.getArea() == other.getArea();
    }
}
