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
//    private SurfaceView boardSurfaceView;
//    private SurfaceHolder boardSurfaceHolder;
//    private Board b;
    protected Path boardPath;
    protected Paint boardPaint;
//    private Canvas tempCanvas;
//    private LinearLayout boardSurfaceViewParent;
//    private Context context;

    public BoardSurfaceView(Context context)
    {

        super(context);
    }

    public BoardSurfaceView(Context context, AttributeSet as)
    {
        super(context, as);
        if(!isInEditMode())
        {
            init();//context);
        }

//        TypedArray ta = context.getTheme().obtainStyledAttributes(as, R.styleable.BoardSurfaceView, 0, 0);
//        try
//        {
//
//        }

//        boardSurfaceHolder = boardSurfaceView.getHolder();
//        boardSurfaceHolder.addCallback(this);
//        boardSurfaceView.setWillNotDraw(false);
//        boardSurfaceView.invalidate();
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
//        this.context = context;
        boardPaint = new Paint();
//        boardPaint.setColor(Color.BLUE);
        boardPath = new Path();
//        boardSurfaceViewParent = (LinearLayout)findViewById(R.id.ll1);
//        if(this.getHeight() == 0)
//        {
//            this.setMinimumHeight(boardSurfaceViewParent.getHeight());
//        }
//        if(boardSurfaceView.getWidth() == 0)
//        {
//            boardSurfaceView.setMinimumWidth(boardSurfaceViewParent.getWidth());
//        }
        /*Draw top triangle.*/
//        boardPath.moveTo(100, 200);
//        boardPath.lineTo(200, 100);
//        boardPath.lineTo(300, 200);
//        boardPath.lineTo(100, 200);
//        boardSurfaceHolder = boardSurfaceView.getHolder();
//        boardSurfaceHolder.addCallback(this);
//        boardSurfaceView.setWillNotDraw(false);
////        boardSurfaceView.invalidate();
//        tempCanvas = boardSurfaceHolder.lockCanvas();
    }

//    @Override
//    public void onSizeChanged(int currWidth, int currHeight, int oldWidth, int oldHeight)
//    {
//        currWidth = oldWidth;
//        currHeight = oldHeight;
//    }

    /*Have to clean project after project is built with draw instead of onDraw.*/
    /*XML layout builder throws a NullPointerException at the first line of code in the onDraw method.*/
    @Override
    public void onDraw(Canvas c)
//    public void draw(Canvas c)
    {
//        c = boardSurfaceHolder.lockCanvas();
//        super.onDraw(c);
//        c = boardSurfaceHolder.lockCanvas();
//        b = new Board();
//        b.draw(c);
//        boardSurfaceHolder = boardSurfaceView.getHolder();
//        surfaceCreated(boardSurfaceHolder);
//        boardSurfaceHolder.addCallback(this);
//        boardSurfaceView.setWillNotDraw(false);
//        boardSurfaceView.invalidate();
//        c.drawColor(Color.WHITE);
//        boardPaint = new Paint();

        /*Working code*/
//        boardPaint.setColor(Color.BLUE);
//        /*Draw top triangle.*/
//        boardPath.moveTo(500, 200);
//        boardPath.lineTo(600, 100);
//        boardPath.lineTo(700, 200);
//        boardPath.lineTo(500, 200);

//        boardSurfaceViewParent = (LinearLayout)findViewById(R.id.ll1);
//        if(this.getHeight() == 0)
//        {
//            this.setMinimumHeight(boardSurfaceViewParent.getHeight());
//        }
//        if(boardSurfaceView.getWidth() == 0)
//        {
//            boardSurfaceView.setMinimumWidth(boardSurfaceViewParent.getWidth());
//        }

        /*Working code*/
//        c.drawPath(boardPath, boardPaint);
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
//        boardPaint.setColor(Color.BLUE);
//        /*Draw top triangle.*/
//        boardPath.moveTo(500, 200);
//        boardPath.lineTo(600, 100);
//        boardPath.lineTo(700, 200);
//        boardPath.lineTo(500, 200);

//        tempCanvas = sh.lockCanvas();
//        draw(tempCanvas);

//        boardSurfaceHolder = boardSurfaceView.getHolder();
//        boardSurfaceHolder.addCallback(this);
//        boardSurfaceView.setWillNotDraw(false);
//        tempCanvas = boardSurfaceHolder.lockCanvas();
//        onDraw(tempCanvas);//error:  suspicious call; should probably call "draw" rather than "onDraw"
//        boardSurfaceView.invalidate();
    }
}
