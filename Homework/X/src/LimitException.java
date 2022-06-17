public class LimitException extends RuntimeException{
    public LimitException(){
        super("Exceeded rectangle instance limit of 5");
    }
}
