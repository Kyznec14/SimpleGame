package com.kyznec.app.redcircle;

import android.graphics.Color;

import java.util.Random;

import static android.graphics.Color.*;


public class EnemyCircle extends SimpleFigure{

    public static final int FROM_RADIUS=10;
    public static final int TO_RADIUS=110;
    public static final int ENEMY_COLOR = RED;
    public  static final int FOOD_COLOR=rgb(0,200,0);
    EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
        //setColor(OUR_COLOR);
    }

    public static EnemyCircle getRandomCircle() {
        Random random=new Random();
        int x=random.nextInt(GameManager.getWidth());
        int y=random.nextInt(GameManager.getHeigth());
        int radius= FROM_RADIUS+random.nextInt(TO_RADIUS-FROM_RADIUS);
        EnemyCircle enemyCircle=new EnemyCircle(x,y,radius);
        enemyCircle.setColor(ENEMY_COLOR);
        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerTham(mainCircle)){
            setColor(FOOD_COLOR);

        }
        else{
            setColor(ENEMY_COLOR);
        }
    }

    private boolean isSmallerTham(SimpleFigure mainCircle) {
        if(this.radius < mainCircle.getRadius()){
            return true;
        }
        return false;
    }
}
