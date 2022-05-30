package first;

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

    int getPerimeter()
    {
        return 2 * (width + height);
    }

    int getArea()
    {
        return width * height;
    }

    public int compareArea(Rectangle other)
    {
        return this.getArea() > other.getArea() ? 1 : other.getArea() > this.getArea() ? -1 : 0;
    }
}