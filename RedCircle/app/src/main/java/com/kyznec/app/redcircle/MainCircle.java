package com.kyznec.app.redcircle;

import android.graphics.Color;



public class MainCircle extends SimpleFigure{

    public static final int MAIN_SPEED=30;
    public static final int INIT_RADIUS=50;
    public static final int OUR_COLOR= Color.BLUE;

    MainCircle(int x, int y){
        super(x,y,INIT_RADIUS);
        setColor(OUR_COLOR);
    }

    public void moveMainCercleWhenTougchAt(int x, int y) {
        int dx=(x-this.x)*MAIN_SPEED/GameManager.getWidth();
        int dy=(y-this.y)*MAIN_SPEED/GameManager.getHeigth();
        this.x+=dx;
        this.y+=dy;
    }
}
