public class App {
    public static void main(String[] args) throws Exception{
        
        //RectangleValidateException
        Rectangle rectangle = new Rectangle(16, 9);
        System.out.println(rectangle.validate());
        
        Rectangle rectangle2 = new Rectangle(-5, 0);
        System.out.println(rectangle2.validate());
        

        //TriangleValidateException
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(triangle.validate());
        
        Triangle triangle2 = new Triangle(3, 4, 10);
        System.out.println(triangle2.validate());
        

        //LimitException
        Rectangle[] rectangles = {
            new Rectangle(4, 3),
            new Rectangle(16, 9),
            new Rectangle(5, 4),
            new Rectangle(10, 5),
            new Rectangle(6, 4),
            new Rectangle(4, 3)
        };
    }
}
