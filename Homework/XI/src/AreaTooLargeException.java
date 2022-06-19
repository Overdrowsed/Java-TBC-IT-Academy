public class AreaTooLargeException extends RuntimeException{
    public AreaTooLargeException(){
        super("Exceeded rectangle area limit of 10000");
    }
}
