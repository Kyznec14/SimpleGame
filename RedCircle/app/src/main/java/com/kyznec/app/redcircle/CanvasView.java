package com.kyznec.app.redcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


public class CanvasView extends View implements ICanvasView{
    private GameManager gameManager;
    private static int width;
    private static int heigth;
    private Paint paint;
    private Canvas canvas;
    private Toast toast;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidthAnHeigth(context);
        initPaint();
        gameManager=new GameManager(this, width, heigth);

    }

    private void initWidthAnHeigth(Context context) {
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display= windowManager.getDefaultDisplay();
        Point point= new Point();
        display.getSize(point);
        width=point.x;
        heigth=point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        gameManager.onDraw();
        }

    @Override
    public void drawCircle(SimpleFigure circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(),circle.getY(),circle.getRadius(),paint);
    }
    private void initPaint() {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            gameManager.onTouchEvent(x,y);
        }
        invalidate();
        return true;
        //return super.onTouchEvent(event);
    }
    @Override
    public void reDraw(){
        invalidate();

    }

    @Override
    public void showMessege(String text) {
        if (toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(getContext(),text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

}
