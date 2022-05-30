package shapes;

public class Rectangle {
    private static final int maxWidth, maxHeight;

    private int width, height;

    static {
        maxWidth = 30;
        maxHeight = 20;
    }

    public Rectangle(int height)
    {
        if(height < maxHeight)
            this.height = height;
        else
            this.height = maxHeight;
    }

    public Rectangle(int width, int height)
    {
        if(width < maxWidth)
            this.width = width;
        else
            this.width = maxWidth;
        
        if(height < maxHeight)
            this.height = height;
        else
            this.height = maxHeight;
    }

    public Rectangle()
    {
        final int width = 20;

        if(width < maxWidth)
            this.width = width;
        else
            this.width = maxWidth;
    }

    public String getWidthHeight()
    {
        return this.width + " " + this.height;
    }

    public int getArea()
    {
        return width * height;
    }

    public static Rectangle maxArea(Rectangle[] rectangles)
    {
        int maxAreaIndex = 0, maxArea = 0;

        for(int i = 0; i < rectangles.length; i++)
        {
            if(rectangles[i].getArea() > maxArea)
            {
                maxAreaIndex = i;
                maxArea = rectangles[i].getArea();
            }
        }

        return rectangles[maxAreaIndex];
    }
}