package up.edu.cs301.chinese_checkers;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Paint;
import android.icu.text.DisplayContext;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Luke D. Douville on 10/17/17.
 */

public class BoardSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    protected Path tri1Path, tri2Path, tri3Path, tri4Path, tri5Path, tri6Path, hexPath;
    protected Paint tri1Paint, tri2Paint, tri3Paint, tri4Paint, tri5Paint, tri6Paint, hexPaint, boardPaint;
    private Canvas tempCanvas;
    private LinearLayout boardSurfaceViewParent;

    public BoardSurfaceView(Context context)
    {
        super(context);
        init();
    }

    public BoardSurfaceView(Context context, AttributeSet as)
    {
        super(context, as);
        if(!isInEditMode())
        {
            init();//context);
        }
    }

    public BoardSurfaceView(Context context, AttributeSet as, int defStyle)
    {
        super(context, as, defStyle);
        if(!isInEditMode())
        {
            init();//context);
        }
    }

    private void init()//Context context)
    {

    }

    /*Have to clean project after project is built with draw instead of onDraw.*/
    /*XML layout builder throws a NullPointerException at the first line of code in the onDraw method.*/
    @Override
    public void onDraw(Canvas c)
    {
        /*Layout editor is unhappy if you instantiate boardPaint and boardPath in the init method.*/
        tri1Paint = new Paint();
        tri2Paint = new Paint();
        tri3Paint = new Paint();
        tri4Paint = new Paint();
        tri5Paint = new Paint();
        tri6Paint = new Paint();
        hexPaint = new Paint();
        tri1Path = new Path();
        tri2Path = new Path();
        tri3Path = new Path();
        tri4Path = new Path();
        tri5Path = new Path();
        tri6Path = new Path();
        hexPath = new Path();
        int width = c.getWidth()/2;
        int height = c.getHeight()/2;
        float radius = 350/8;
        boardPaint = new Paint();
        boardPaint.setColor(Color.BLACK);



        /*Draw the top triangle.*/
        tri1Paint.setColor(Color.BLUE);//set the color
        tri1Path.moveTo(width, height-750);
        tri1Path.lineTo(width+200, height-400);
        tri1Path.lineTo(width-200, height-400);
        tri1Path.lineTo(width, height-750);
        c.drawPath(tri1Path, tri1Paint);

        c.drawCircle((float)width,(height-750)+radius,radius,boardPaint);           //row 1
        c.drawCircle((float)width+50,(height-750)+3*radius,radius,boardPaint);  //row 2
        c.drawCircle((float)width-50,(height-750)+3*radius,radius,boardPaint);  //row 2
        c.drawCircle((float)width-100,(height-750)+5*radius,radius,boardPaint); //row 3
        c.drawCircle((float)width,(height-750)+5*radius,radius,boardPaint);         //row 3
        c.drawCircle((float)width+100,(height-750)+5*radius,radius,boardPaint); //row 3
        c.drawCircle((float)width-150,(height-400)-radius,radius,boardPaint);   //row 4
        c.drawCircle((float)width-50,(height-400)-radius,radius,boardPaint);    //row 4
        c.drawCircle((float)width+50,(height-400)-radius,radius,boardPaint);    //row 4
        c.drawCircle((float)width+150,(height-400)-radius,radius,boardPaint);   //row 4





        /*Draw the top-right triangle.*/
        tri2Paint.setColor(Color.GREEN);//set the color
        tri2Path.moveTo(width+200, height-400);
        tri2Path.lineTo(width+600, height-400);
        tri2Path.lineTo(width+400, height-50);
        tri2Path.lineTo(width+200, height-400);
        c.drawPath(tri2Path, tri2Paint);

        /*Draw the bottom-right triangle.*/
        tri3Paint.setColor(Color.YELLOW);
        tri3Path.moveTo(width+400, height-50);
        tri3Path.lineTo(width+600, height+300);
        tri3Path.lineTo(width+200, height+300);
        tri2Path.lineTo(width+400, height-50);
        c.drawPath(tri3Path, tri3Paint);

        /*Draw the bottom triangle.*/
        tri4Paint.setColor(Color.RED);
        tri4Path.moveTo(width+200, height+300);
        tri4Path.lineTo(width, height+650);
        tri4Path.lineTo(width-200, height+300);
        tri4Path.lineTo(width+200, height+300);
        c.drawPath(tri4Path, tri4Paint);

        /*Draw the bottom-left triangle.*/
        int orange = Color.rgb(245, 120, 11);
        tri5Paint.setColor(orange);
        tri5Path.moveTo(width-200, height+300);
        tri5Path.lineTo(width-600, height+300);
        tri5Path.lineTo(width-400, height-50);
        tri5Path.lineTo(width-200, height+300);
        c.drawPath(tri5Path, tri5Paint);

        /*Draw the top-left triangle.*/
        int purple = Color.rgb(159, 11, 245);
        tri6Paint.setColor(purple);
        tri6Path.moveTo(width-400, height-50);
        tri6Path.lineTo(width-600, height-400);
        tri6Path.lineTo(width-200, height-400);
        tri6Path.lineTo(width-400, height-50);
        c.drawPath(tri6Path, tri6Paint);

        /*Draw the central space.*/
        hexPaint.setColor(Color.WHITE);
        hexPath.moveTo(width-200, height-400);
        hexPath.lineTo(width+200, height-400);
        hexPath.lineTo(width+400, height-50);
        hexPath.lineTo(width+200, height+300);
        hexPath.lineTo(width-200, height+300);
        hexPath.lineTo(width-400, height-50);
        hexPath.lineTo(width-200, height-400);
        c.drawPath(hexPath, hexPaint);
    }

    /*Needed all three of these abstract methods or else the class wouldn't compile.*/
    public void surfaceChanged(SurfaceHolder sh, int a, int b, int c)
    {

    }

    public void surfaceDestroyed(SurfaceHolder sh)
    {

    }

    public void surfaceCreated(SurfaceHolder sh)
    {

    }
}
