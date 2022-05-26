public class Main {
    public static void main(String[] args) {
        Rectangle rectangle;

        //System.out.println(rectangle.getPerimeter());

        rectangle = null;

        //System.out.println(rectangle.getPerimeter());

        rectangle = new Rectangle();

        System.out.println(rectangle.getWidth());

        Rectangle rectangleTwo = new Rectangle();

        //false
        System.out.println(rectangle == rectangleTwo);

        rectangleTwo = rectangle;

        //true
        System.out.println(rectangle == rectangleTwo);

        rectangle.setHeight(5);
        rectangleTwo.setHeight(7);

        //rectangleTwo სეტერი ცვლის rectangle გეტერს რადგან ერთსა და იმავე ობიექტზე მიუთითებენ
        System.out.println(rectangle.getHeight());

        //ფართობების შედარება
        rectangleTwo = new Rectangle();

        rectangle.setWidthHeight(5,4);
        rectangleTwo.setWidthHeight(7,4);

        System.out.println(rectangle.compareArea(rectangleTwo));



        int from, to;

        //from += 5; to *= 2;

        from = 1; to = 5;

        countFromTo(from, to);
    }

    //იმავე დასახელების სხვა ცვლადები
    static void countFromTo(int from, int to)
    {
        for(int i = from; i <= to; i++)
            System.out.print(i + " ");

        System.out.println();
    }
}

class Rectangle {
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

    public int getPerimeter()
    {
        return 2 * (width + height);
    }

    public int getArea()
    {
        return width * height;
    }

    public int compareArea(Rectangle other)
    {
        return this.getArea() > other.getArea() ? 1 : this.getArea() < other.getArea() ? -1 : 0;
    }
}