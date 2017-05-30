package com.kyznec.app.redcircle;


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

    public SimpleFigure getCircleArea() {
        return new SimpleFigure(this.x,this.y,this.radius*2);
    }

    public boolean isIntersect(SimpleFigure mainCircleArea) {
        return radius+mainCircleArea.radius>=Math.sqrt(Math.pow(x-mainCircleArea.x,2)+Math.pow(y-mainCircleArea.y,2));
    }
}
