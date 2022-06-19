public class LimitException extends RuntimeException{
    public LimitException(){
        super("Exceeded figure instance limit of 10");
    }
}
