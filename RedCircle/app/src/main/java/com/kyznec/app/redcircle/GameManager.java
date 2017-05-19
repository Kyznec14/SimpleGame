package com.kyznec.app.redcircle;


import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {

    private  MainCircle mainCircle;
    private Paint paint;
    private static int width;
    private static int heigth;
    private CanvasView canvasView;

    public GameManager(){
        initMainCircle();
    }

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView=canvasView;
        width=w;
        heigth=h;
        initMainCircle();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeigth() {
        return heigth;
    }

    public void onDraw() {

        canvasView.drawCircle(mainCircle);
    }

    private void initMainCircle() {
        mainCircle= new MainCircle(width/2,heigth/2);
    }


    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCercleWhenTougchAt(x,y);
    }
}
