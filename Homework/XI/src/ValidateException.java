public class ValidateException extends Exception {
    public ValidateException(String shape){
        super("Invalid side lengths for a " + shape);
    }
}
