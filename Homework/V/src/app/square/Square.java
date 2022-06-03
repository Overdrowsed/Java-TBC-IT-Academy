package app.square;

import app.Rectangle;

public final class Square extends Rectangle{
    
    int side;

    public Square(int side){
        this.side = side;
    }
    
    @Override
    public int getPerimeter(){
        return super.getPerimeter(side, side);
    }

    @Override
    public int getArea(){
        return super.getArea(side, side);
    }
}