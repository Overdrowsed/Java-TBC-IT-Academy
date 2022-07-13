package figure.exceptions;

public class FigureValidatorException extends Exception{
    public FigureValidatorException(){
        super("Invalid rectangle configuration");
    }
}
