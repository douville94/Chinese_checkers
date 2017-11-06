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
    protected Path boardPath;
    protected Paint boardPaint;
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
        boardPaint = new Paint();
        boardPath = new Path();

        /*Working code*/
        boardPaint.setColor(Color.BLUE);
        /*Draw top triangle.*/
        boardPath.moveTo(500, 200);
        boardPath.lineTo(600, 100);
        boardPath.lineTo(700, 200);
        boardPath.lineTo(500, 200);

        /*Working code*/
        c.drawPath(boardPath, boardPaint);
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
