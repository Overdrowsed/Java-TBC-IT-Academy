package figure.validator;

import figure.Figure;
import figure.exceptions.FigureValidatorException;

public abstract class FigureValidator {

    public abstract void validate(Figure figure) throws FigureValidatorException;
}
