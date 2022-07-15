package figure.method;

public enum FigureMethod{
    GET_LENGTH("getLength"),
    GET_AREA("getArea");

    public final String methodName;

    private FigureMethod(String methodName){
        this.methodName = methodName;
    }
}