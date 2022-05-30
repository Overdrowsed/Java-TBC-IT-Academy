package second;

public class Rectangle {
    private int width, height;

    public void setWidthHeight(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    protected int getPerimeter()
    {
        return 2 * (width + height);
    }

    public int comparePerimeter(Rectangle first, Rectangle second)
    {
        return first.getPerimeter() > second.getPerimeter() ? 1 : second.getPerimeter() > first.getPerimeter() ? -1 : 0;
    }
}