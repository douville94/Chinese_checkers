package up.edu.cs301.chinese_checkers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

/**
 * Created by Luke D. Douville on 10/17/17.
 */

public class BoardSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    protected Path tri1Path, tri2Path, tri3Path, tri4Path, tri5Path, tri6Path, hexPath;
    protected Paint tri1Paint, tri2Paint, tri3Paint, tri4Paint, tri5Paint, tri6Paint, hexPaint;
    protected Paint centerBoardPaint, player1Paint, player2Paint, player3Paint, player4Paint, player5Paint, player6Paint;
//    private Canvas tempCanvas;
//    private LinearLayout boardSurfaceViewParent;
//    private IntArray ia;
    private CCGameState cgs = new CCGameState();
    private int[][] myXYs;//[13][17] myXYs;
    private int width, height, a, b;
    private float radius, range;

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
//        cgs = new CCGameState();
    }

    /*Have to clean project after project is built with draw instead of onDraw.*/
    @Override
    public void onDraw(Canvas c)
    {
//        Log.i("Canvas Height",""+c.getWidth());
//        Log.i("Canvas Height",""+c.getHeight());
        width = c.getWidth()/2;
        height = c.getHeight()/2;
        radius = (50/3)*(float)Math.sqrt(3.0);
        range = 350/8;
        centerBoardPaint = new Paint();
        centerBoardPaint.setColor(Color.BLACK);
        player1Paint = new Paint();
        player1Paint.setColor(Color.BLUE);
        player2Paint = new Paint();
        player2Paint.setColor(Color.GREEN);
        player3Paint = new Paint();
        player3Paint.setColor(Color.YELLOW);
        player4Paint = new Paint();
        player4Paint.setColor(Color.RED);
        player5Paint = new Paint();
        player5Paint.setColor(Color.rgb(255, 119, 0));//orange
        player6Paint = new Paint();
        player6Paint.setColor(Color.rgb(174, 23, 179));//purple

        int[][] intArray = new int[][]{
                {-2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2}, // row 0

                {-2, -2, -2, -2, -2, -1, -1, -2, -2, -2, -2, -2, -2}, // row 1

                {-2, -2, -2, -2, -2, -1, -1, -1, -2, -2, -2, -2, -2}, // row 2

                {-2, -2, -2, -2, -1, -1, -1, -1, -2, -2, -2, -2, -2}, // row 3

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // row 4

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 5

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 6

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 7

                {-2, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 8 -----

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 9

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 10

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 11

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // row 12

                {-2, -2, -2, -2, -1, -1, -1, -1, -2, -2, -2, -2, -2}, // row 13

                {-2, -2, -2, -2, -2, -1, -1, -1, -2, -2, -2, -2, -2}, // row 14

                {-2, -2, -2, -2, -2, -1, -1, -2, -2, -2, -2, -2, -2}, // row 15

                {-2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2}, // row 16
        };
        Log.i("1stbox",""+intArray.length);
        Log.i("2nd box",""+intArray[0].length);
        int x = 200;
        int y =40;
        boolean offset = false;
        float[][] xposition = new float[17][13];
        float[][] yposition = new float[17][13];
        Log.i("1stbox",""+xposition.length);
        Log.i("2nd box",""+xposition[0].length);
        //iterate first row
        for(int i = 0; i < 17; i++)
        {
            //
            y+=100;
            if(offset){
                x = 250;
            }
            else{
                x = 200;
            }
           // iterate each column


            for(int j = 0; j < 13; j++)
            {
                int z = intArray[i][j];
                switch (z){
                    case -2:// invalid don't draw anything
                        xposition[i][j] = 0;
                        yposition[i][j] = 0;
                        break;
                    case -1: //empty
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 0: //player1
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 1: //player2
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 2: //player3
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 3: //player4
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 4: //player5
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 5: //player6
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    default:
                        break;
                }
                x+=95;
                y-=1;
                Log.i("xposition",""+xposition[i][j]);
                Log.i("yposition",""+yposition[i][j]);
            }
            offset = !offset;
        }


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

    public void compareArrays()
    {
        for(int i = 4; i < 8; i++)
        {
            for(int j = 0; j < 4; j++)
            {

            }
        }

        for(int i = 9; i < 13; i++)
        {
            for(int j = 4; j < 8; j++)
            {

            }
        }
    }

    public int getX(int[][] array)
    {

        return 1;
    }
}
