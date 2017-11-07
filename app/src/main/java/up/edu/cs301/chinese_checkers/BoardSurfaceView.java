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
    protected Paint tri1Paint, tri2Paint, tri3Paint, tri4Paint, tri5Paint, tri6Paint, hexPaint;
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

        /*Draw the top triangle.*/
        tri1Paint.setColor(Color.BLUE);//set the color
        tri1Path.moveTo(550, 400);
        tri1Path.lineTo(750, 50);
        tri1Path.lineTo(950, 400);
        tri1Path.lineTo(550, 400);

        /*For larger top triangle.*/
//        tri1Path.moveTo(500, 400);
//        tri1Path.lineTo(750, 46);
//        tri1Path.lineTo(1000, 400);
//        tri1Path.lineTo(500, 400);
        c.drawPath(tri1Path, tri1Paint);

        /*Draw the top-right triangle.*/
        tri2Paint.setColor(Color.GREEN);//set the color
        tri2Path.moveTo(950, 400);
        tri2Path.lineTo(1450, 400);
        tri2Path.lineTo(1100, 700);
        tri2Path.lineTo(950, 400);
        c.drawPath(tri2Path, tri2Paint);

        /*Draw the bottom-right triangle.*/
        tri3Paint.setColor(Color.YELLOW);
        tri3Path.moveTo(1100, 700);
        tri3Path.lineTo(1450, 948);
        tri3Path.lineTo(950, 973);
        tri2Path.lineTo(1100, 700);
        c.drawPath(tri3Path, tri3Paint);

        /*Draw the bottom triangle.*/
        tri4Paint.setColor(Color.RED);
        tri4Path.moveTo(950, 973);
        tri4Path.lineTo(750, 1323);
        tri4Path.lineTo(550, 973);
        tri4Path.lineTo(950, 973);

        /*For larger bottom triangle*/
//        tri4Path.moveTo(1000, 948);
//        tri4Path.lineTo(750, 1298);
//        tri4Path.lineTo(500, 948);
//        tri4Path.lineTo(1000, 948);
        c.drawPath(tri4Path, tri4Paint);

        /*Draw the bottom-left triangle.*/
        tri5Paint.setColor(Color.rgb(245, 120, 11));
        tri5Path.moveTo(550, 973);
        tri5Path.lineTo(150, 1000);
        tri5Path.lineTo(400, 700);
        tri5Path.lineTo(550, 973);
        c.drawPath(tri5Path, tri5Paint);

        /*Draw the top-left triangle.*/
        tri6Paint.setColor(Color.rgb(159, 11, 245));
        tri6Path.moveTo(400, 700);
        tri6Path.lineTo(50, 400);
        tri6Path.lineTo(550, 400);
        tri6Path.lineTo(400, 700);
        c.drawPath(tri6Path, tri6Paint);

        /*Draw the central space.*/
//        hexPaint.setColor(Color.WHITE);
//        hexPath.moveTo(550, 400);
//        hexPath.lineTo(950, 400);
//        hexPath.lineTo(1250, 624);
//        hexPath.lineTo(950, 948);
//        hexPath.lineTo(550, 948);
//        hexPath.lineTo(350, 624);
//        hexPath.lineTo(550, 400);
//        c.drawPath(hexPath, hexPaint);
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
