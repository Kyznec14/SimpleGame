package com.kyznec.app.redcircle;

import java.util.Random;

import static android.graphics.Color.*;


public class EnemyCircle extends SimpleFigure{

    public static final int FROM_RADIUS=10;
    public static final int TO_RADIUS=110;
    public static final int ENEMY_COLOR = RED;
    public  static final int FOOD_COLOR=rgb(0,200,0);
    public  static final int RANDOM_SPEED=10;
    private int dx;
    private int dy;
    EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx=dx;
        this.dy=dy;
        //setColor(OUR_COLOR);
    }

    public static EnemyCircle getRandomCircle() {
        Random random=new Random();
        int x=random.nextInt(GameManager.getWidth());
        int y=random.nextInt(GameManager.getHeigth());
        int dx=1+random.nextInt(RANDOM_SPEED);
        int dy=1+random.nextInt(RANDOM_SPEED);

        int radius= FROM_RADIUS+random.nextInt(TO_RADIUS-FROM_RADIUS);
        EnemyCircle enemyCircle=new EnemyCircle(x,y,radius,dx,dy);
        enemyCircle.setColor(ENEMY_COLOR);
        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)){
            setColor(FOOD_COLOR);

        }
        else{
            setColor(ENEMY_COLOR);
        }
    }

    public boolean isSmallerThan(SimpleFigure mainCircle) {
        if(this.radius < mainCircle.getRadius()){
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        this.y+=dy;
        this.x+=dx;
        checkDounds();
    }

    private void checkDounds() {
        if (x>GameManager.getHeigth()||x<0){
            dx=-dx;
        }
        if (y>GameManager.getWidth()||y<0){
            dy=-dy;
        }
    }

}
