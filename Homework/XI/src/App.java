public class App {
    public static void main(String[] args) throws Exception{
        Figure rectangle = new Rectangle(0, 0);
        Figure rectangle2 = new Rectangle(16, 9);
        Figure triangle = new Triangle(0, 0, 0);
        Figure triangle2 = new Triangle(3, 4, 5);

        try{
            //მეცხრე პუნქტი
            try {
                try{
                    System.out.println(rectangle.validate());
                }
                catch (RectangleValidateException exception){
                    System.out.println(exception.getMessage());
                }
                catch (TriangleValidateException exception){
                    System.out.println(exception.getMessage());
                }
                catch (ValidateException exception){
                    System.out.println(exception.getMessage());
                }
            } finally {}

            try {
                System.out.println(rectangle2.validate());
            }
            catch (RectangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (TriangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (ValidateException exception){
                System.out.println(exception.getMessage());
            }

            //მეათე პუნქტი
            try{
                try{
                    System.out.println(triangle.validate());
                }
                finally{
                    System.out.println("Validation finished unsuccessfully");
                }
            }
            catch (RectangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (TriangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (ValidateException exception){
                System.out.println(exception.getMessage());
            }

            try {
                System.out.println(triangle2.validate());
            }
            catch (RectangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (TriangleValidateException exception){
                System.out.println(exception.getMessage());
            }
            catch (ValidateException exception){
                System.out.println(exception.getMessage());
            }
            
            
            Rectangle rectangle3 = new Rectangle(5000, 3);
            
            try{
                rectangle3.getArea();
            }
            catch (AreaTooLargeException exception){
                System.out.println(exception.getMessage());
    
                throw exception;
            }
    
            Figure[] limitExceptionFigures = {
                new Rectangle(16, 9),
                new Rectangle(4, 3),
                new Triangle(3, 4, 5),
                new Triangle(19, 6, 25),
                new Rectangle(30, 25),
                new Rectangle(5, 4),
                new Rectangle(19, 16)
            };
        }
        finally {
            System.out.println("Goodbye figures");
        }
    }
}
