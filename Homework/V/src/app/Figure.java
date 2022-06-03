package app;

public class Figure {

    public Figure(){}

    public Figure(String s){
        System.out.println(s);
    }

    public static final void sayHello(){
        System.out.println("Hello");
    }

    protected int getPerimeter(){
        return -1;
    }

    protected int getArea(){
        return -1;
    }
}
