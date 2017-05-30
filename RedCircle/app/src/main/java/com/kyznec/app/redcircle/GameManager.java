package com.kyznec.app.redcircle;


import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class GameManager {

    private  MainCircle mainCircle;
    private Paint paint;
    private static int width;
    private final int  ENEMYCOUNT=10;
    private static int heigth;
    private CanvasView canvasView;
    private ArrayList<EnemyCircle> enemies;

    public GameManager(){
        initMainCircle();
    }

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView=canvasView;
        width=w;
        heigth=h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        enemies= new ArrayList<EnemyCircle>();
        for (int i=0;i<ENEMYCOUNT;i++){
            EnemyCircle circle;
            SimpleFigure mainCircleArea=mainCircle.getCircleArea();
            do{
            circle=EnemyCircle.getRandomCircle();}
            while (circle.isIntersect(mainCircleArea));
            enemies.add(circle);
        }
        calcilateAndSetCircleColor();
    }

    private void calcilateAndSetCircleColor() {
for(EnemyCircle circle:enemies){
    circle.setEnemyOrFoodColorDependsOn(mainCircle);
}
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeigth() {
        return heigth;
    }

    public void onDraw() {

        canvasView.drawCircle(mainCircle);
        for(EnemyCircle circle:enemies){
            canvasView.drawCircle(circle);
        }
    }

    private void initMainCircle() {
        mainCircle= new MainCircle(width/2,heigth/2);
    }


    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCercleWhenTougchAt(x,y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        SimpleFigure circleForDel=null;
        for(EnemyCircle circle:enemies){
            if (mainCircle.isIntersect(circle)){
                if(circle.isSmallerThan(mainCircle)){
                    mainCircle.growRadius(circle);
                    circleForDel=circle;
                    calcilateAndSetCircleColor();
                    break;
                } else {
                    gameEnd("YOU LOSE!");
                    return;
                }
            }

        }
        if(circleForDel!=null){
            enemies.remove(circleForDel);
        }
        if(enemies.isEmpty()){
            gameEnd("YOU WIN!!!");
        }
    }

    private void gameEnd(String text) {
        canvasView.showMessege(text);
        mainCircle.iniRadius();
        initEnemyCircles();
        canvasView.reDraw();
    }

    private void moveCircles(){
        for(EnemyCircle circle:enemies){
            circle.moveOneStep();

        }
    }
}
