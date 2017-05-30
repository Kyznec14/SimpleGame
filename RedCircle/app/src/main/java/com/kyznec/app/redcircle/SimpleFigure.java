package com.kyznec.app.redcircle;

/**
 * Created by root on 5/19/17.
 */

public class SimpleFigure {

    protected int x;
    protected int y;
    protected int radius;
    protected int color;


    public int getX() {
        return x;
    }

    SimpleFigure(int x, int y,int radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }


    public int getRadius() {
        return radius;
    }

    public int getY() {
        return y;
    }


    public int getColor() {
        return color;
    }
    public  void setColor(int color){
        this.color=color;
    }
}
