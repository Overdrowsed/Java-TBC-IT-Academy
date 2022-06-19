public abstract class Figure {
    private static int instanceCount;

    public Figure(){
        try{
            if(instanceCount >= 10){
                throw new LimitException();
            }
        }
        catch (LimitException exception){
            System.out.println(exception.getMessage());

            throw new RuntimeException(exception.getMessage(), exception);
        }

        instanceCount++;
    }

    public abstract boolean validate() throws ValidateException;
}
