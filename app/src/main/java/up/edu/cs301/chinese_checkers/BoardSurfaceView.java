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
        /*Layout editor is unhappy if you instantiate centerBoardPaint and boardPath in the init method.*/
//        tri1Paint = new Paint();
//        tri2Paint = new Paint();
//        tri3Paint = new Paint();
//        tri4Paint = new Paint();
//        tri5Paint = new Paint();
//        tri6Paint = new Paint();
//        hexPaint = new Paint();
//        tri1Path = new Path();
//        tri2Path = new Path();
//        tri3Path = new Path();
//        tri4Path = new Path();
//        tri5Path = new Path();
//        tri6Path = new Path();
//        hexPath = new Path();
        Log.i("Canvas Height",""+c.getWidth());
        Log.i("Canvas Height",""+c.getHeight());
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

        /*myXYs is an array of all possible positions on the board, including invalid positions.*/
        /*You may want to initialize myXYs before entering any method.  Initializing it here in the
         onDraw method can interfere with gameplay by slowing down the GUI.*/
        //min x coord = width - 300
        //max x coord = width + 600
        //min y coord = (height - 750) + (int)range
        //max y coord = (height + 500) + (int)range
        myXYs = new int[][]
                {
                        //row 1
                        {width - 600, height - 750},
                        {width - 500, height - 750},
                        {width - 400, height - 750},
                        {width - 300, height - 750},
                        {width - 200, height - 750},
                        {width - 100, height - 750},
                        {width, height - 750},
                        {width + 100, height - 750},
                        {width + 200, height - 750},
                        {width + 300, height - 750},
                        {width + 400, height - 750},
                        {width + 500, height - 750},
                        {width + 600, height - 750},

                        //row 2
                        {width - 600, (height - 750) + (int)(3 * range)},
                        {width - 500, (height - 750) + (int)(3 * range)},
                        {width - 400, (height - 750) + (int)(3 * range)},
                        {width - 300, (height - 750) + (int)(3 * range)},
                        {width - 200, (height - 750) + (int)(3 * range)},
                        {width - 50, (height - 750) + (int)(3 * range)},
                        {width + 50, (height - 750) + (int)(3 * range)},
                        {width + 200, (height - 750) + (int)(3 * range)},
                        {width + 300, (height - 750) + (int)(3 * range)},
                        {width + 400, (height - 750) + (int)(3 * range)},
                        {width + 500, (height - 750) + (int)(3 * range)},
                        {width + 600, (height - 750) + (int)(3 * range)},

                        //row 3
                        {width - 600, (height - 750) + (int)(5 * range)},
                        {width - 500, (height - 750) + (int)(5 * range)},
                        {width - 400, (height - 750) + (int)(5 * range)},
                        {width - 300, (height - 750) + (int)(5 * range)},
                        {width - 200, (height - 750) + (int)(5 * range)},
                        {width - 100, (height - 750) + (int)(5 * range)},
                        {width, (height - 750) + (int)(5 * range)},
                        {width + 100, (height - 750) + (int)(5 * range)},
                        {width + 200, (height - 750) + (int)(5 * range)},
                        {width + 300, (height - 750) + (int)(5 * range)},
                        {width + 400, (height - 750) + (int)(5 * range)},
                        {width + 500, (height - 750) + (int)(5 * range)},
                        {width + 600, (height - 750) + (int)(5 * range)},

                        //row 4
                        {width - 600, (height - 400) - (int)range},
                        {width - 500, (height - 400) - (int)range},
                        {width - 400, (height - 400) - (int)range},
                        {width - 300, (height - 400) - (int)range},
                        {width - 150, (height - 400) - (int)range},
                        {width - 50, (height - 400) - (int)range},
                        {width + 50, (height - 400) - (int)range},
                        {width + 150, (height - 400) - (int)range},
                        {width + 300, (height - 400) - (int)range},
                        {width + 400, (height - 400) - (int)range},
                        {width + 500, (height - 400) - (int)range},
                        {width + 600, (height - 400) - (int)range},

                        //row 5
                        {width - 600, (height - 400) + (int)range},
                        {width - 500, (height - 400) + (int)range},
                        {width - 400, (height - 400) + (int)range},
                        {width - 300, (height - 400) + (int)range},
                        {width - 200, (height - 400) + (int)range},
                        {width - 100, (height - 400) + (int)range},
                        {width, (height - 400) + (int)range},
                        {width + 100, (height - 400) + (int)range},
                        {width + 200, (height - 400) + (int)range},
                        {width + 300, (height - 400) + (int)range},
                        {width + 400, (height - 400) + (int)range},
                        {width + 500, (height - 400) + (int)range},
                        {width + 600, (height - 400) + (int)range},

                        //row 6
                        {width - 600, (height - 325) + (int)range},
                        {width - 550, (height - 325) + (int)range},
                        {width - 450, (height - 325) + (int)range},
                        {width - 350, (height - 325) + (int)range},
                        {width - 200, (height - 325) + (int)range},
                        {width - 100, (height - 325) + (int)range},
                        {width, (height - 325) + (int)range},
                        {width + 100, (height - 325) + (int)range},
                        {width + 200, (height - 325) + (int)range},
                        {width + 350, (height - 325) + (int)range},
                        {width + 450, (height - 325) + (int)range},
                        {width + 550, (height - 325) + (int)range},
                        {width + 600, (height - 325) + (int)range},

                        //row 7
                        {width - 600, (height - 250) + (int)range},
                        {width - 500, (height - 250) + (int)range},
                        {width - 400, (height - 250) + (int)range},
                        {width - 300, (height - 250) + (int)range},
                        {width - 200, (height - 250) + (int)range},
                        {width - 100, (height - 250) + (int)range},
                        {width, (height - 250) + (int)range},
                        {width + 100, (height - 250) + (int)range},
                        {width + 200, (height - 250) + (int)range},
                        {width + 300, (height - 250) + (int)range},
                        {width + 400, (height - 250) + (int)range},
                        {width + 500, (height - 250) + (int)range},
                        {width + 600, (height - 250) + (int)range},

                        //row 8
                        {width - 600, (height + 200) + (int)range},
                        {width - 500, (height + 200) + (int)range},
                        {width - 400, (height + 200) + (int)range},
                        {width - 300, (height + 200) + (int)range},
                        {width - 200, (height + 200) + (int)range},
                        {width - 100, (height + 200) + (int)range},
                        {width, (height + 200) + (int)range},
                        {width + 100, (height + 200) + (int)range},
                        {width + 200, (height + 200) + (int)range},
                        {width + 300, (height + 200) + (int)range},
                        {width + 400, (height + 200) + (int)range},
                        {width + 500, (height + 200) + (int)range},
                        {width + 600, (height + 200) + (int)range},

                        //row 9
                        {width - 600, (height + 125) + (int)range},
                        {width - 550, (height + 125) + (int)range},
                        {width - 450, (height + 125) + (int)range},
                        {width - 350, (height + 125) + (int)range},
                        {width - 200, (height + 125) + (int)range},
                        {width - 100, (height + 125) + (int)range},
                        {width, (height + 125) + (int)range},
                        {width + 100, (height + 125) + (int)range},
                        {width + 200, (height + 125) + (int)range},
                        {width + 350, (height + 125) + (int)range},
                        {width + 450, (height + 125) + (int)range},
                        {width + 550, (height + 125) + (int)range},
                        {width + 600, (height + 125) + (int)range},

                        //row 10
                        {width - 600, (height - 50) + (int)range},
                        {width - 500, (height - 50) + (int)range},
                        {width - 400, (height - 50) + (int)range},
                        {width - 300, (height - 50) + (int)range},
                        {width - 200, (height - 50) + (int)range},
                        {width - 100, (height - 50) + (int)range},
                        {width, (height - 50) + (int)range},
                        {width + 100, (height - 50) + (int)range},
                        {width + 200, (height - 50) + (int)range},
                        {width + 300, (height - 50) + (int)range},
                        {width + 400, (height - 50) + (int)range},
                        {width + 500, (height - 50) + (int)range},
                        {width + 600, (height - 50) + (int)range},

                        //row 11
                        {width - 600, (height - 20) + (int)range},
                        {width - 500, (height - 20) + (int)range},
                        {width - 450, (height - 20) + (int)range},
                        {width - 300, (height - 20) + (int)range},
                        {width - 200, (height - 20) + (int)range},
                        {width - 100, (height - 20) + (int)range},
                        {width, (height - 20) + (int)range},
                        {width + 100, (height - 20) + (int)range},
                        {width + 200, (height - 20) + (int)range},
                        {width + 300, (height - 20) + (int)range},
                        {width + 450, (height - 20) + (int)range},
                        {width + 500, (height - 20) + (int)range},
                        {width + 600, (height - 20) + (int)range},

                        //row 12
                        {width - 600, (height + 275) + (int)range},
                        {width - 500, (height + 275) + (int)range},
                        {width - 400, (height + 275) + (int)range},
                        {width - 300, (height + 275) + (int)range},
                        {width - 200, (height + 275) + (int)range},
                        {width - 150, (height + 275) + (int)range},
                        {width - 50, (height + 275) + (int)range},
                        {width + 50, (height + 275) + (int)range},
                        {width + 150, (height + 275) + (int)range},
                        {width + 200, (height + 275) + (int)range},
                        {width + 300, (height + 275) + (int)range},
                        {width + 400, (height + 275) + (int)range},
                        {width + 500, (height + 275) + (int)range},
                        {width + 600, (height + 275) + (int)range},

                        //row 13
                        {width - 600, (height + 350) + (int)range},
                        {width - 500, (height + 350) + (int)range},
                        {width - 400, (height + 350) + (int)range},
                        {width - 300, (height + 350) + (int)range},
                        {width - 200, (height + 350) + (int)range},
                        {width - 100, (height + 350) + (int)range},
                        {width, (height + 350) + (int)range},
                        {width + 100, (height + 350) + (int)range},
                        {width + 200, (height + 350) + (int)range},
                        {width + 300, (height + 350) + (int)range},
                        {width + 400, (height + 350) + (int)range},
                        {width + 500, (height + 350) + (int)range},
                        {width + 600, (height + 350) + (int)range},

                        //row 14
                        {width - 600, (height + 500) + (int)range},
                        {width - 500, (height + 500) + (int)range},
                        {width - 300, (height + 500) + (int)range},
                        {width - 200, (height + 500) + (int)range},
                        {width - 50, (height + 500) + (int)range},
                        {width, (height + 500) + (int)range},
                        {width+50, (height + 500) + (int)range},
                        {width+200, (height + 500) + (int)range},
                        {width+300, (height + 500) + (int)range},
                        {width+400, (height + 500) + (int)range},
                        {width+500, (height + 500) + (int)range},
                        {width+600, (height + 500) + (int)range},

                };
        Log.i("ArrayLength", "" + myXYs.length);
        cgs = new CCGameState();

        /*Draw the top triangle.*/
        /*tri1Paint.setColor(Color.BLUE);//set the color
        tri1Path.moveTo(width, height-750);
        tri1Path.lineTo(width+200, height-400);
        tri1Path.lineTo(width-200, height-400);
        tri1Path.lineTo(width, height-750);
        c.drawPath(tri1Path, tri1Paint);*/

//        c.drawCircle((float)width,(height-750)+range,radius,centerBoardPaint);           //row 0
//        c.drawCircle((float)width+50,(height-750)+3*range,radius,centerBoardPaint);  //row 1
//        c.drawCircle((float)width-50,(height-750)+3*range,radius,centerBoardPaint);  //row 1
//        c.drawCircle((float)width-100,(height-750)+5*range,radius,centerBoardPaint); //row 2
//        c.drawCircle((float)width,(height-750)+5*range,radius,centerBoardPaint);         //row 2
//        c.drawCircle((float)width+100,(height-750)+5*range,radius,centerBoardPaint); //row 2
//        c.drawCircle((float)width-150,(height-400)-range,radius,centerBoardPaint);   //row 3
//        c.drawCircle((float)width-50,(height-400)-range,radius,centerBoardPaint);    //row 3
//        c.drawCircle((float)width+50,(height-400)-range,radius,centerBoardPaint);    //row 3
//        c.drawCircle((float)width+150,(height-400)-range,radius,centerBoardPaint);   //row 3

        /*Loop through myXYs as per Dr. Vegdahl's recommendation.*/
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

        int x = 200;
        int y =40;
        boolean offset = false;
//        float[][] validPos = new[13][17];
        //iterate first row
        for(int i = 0; i < 17; i++)
        {
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
                    case -2:
                        break;
                    case -1:
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        break;
                    case 0:
                        c.drawCircle(x,y, radius, centerBoardPaint);
                        break;
                    case 1:
                    default:
                        break;
                }

                x+=95;
                y-=1;
            }
            offset = !offset;
        }

        /*Draw the top-right triangle.*/
        /*tri2Paint.setColor(Color.GREEN);//set the color
        tri2Path.moveTo(width+200, height-400);
        tri2Path.lineTo(width+600, height-400);
        tri2Path.lineTo(width+400, height-50);
        tri2Path.lineTo(width+200, height-400);
        c.drawPath(tri2Path, tri2Paint);*/

//        c.drawCircle((float)width+300,(height-400)+range,radius,centerBoardPaint);   //row 4
//        c.drawCircle((float)width+400,(height-400)+range,radius,centerBoardPaint);   //row 4
//        c.drawCircle((float)width+500,(height-400)+range,radius,centerBoardPaint);   //row 4
//        c.drawCircle((float)width+600,(height-400)+range,radius,centerBoardPaint);   //row 4
//        c.drawCircle((float)width+350,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width+450,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width+550,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width+400,(height-250)+range,radius,centerBoardPaint);   //row 6
//        c.drawCircle((float)width+500,(height-250)+range,radius,centerBoardPaint);   //row 6
//        c.drawCircle((float)width+450,(height-175)+range,radius,centerBoardPaint);   //row 7
//
//        /*Draw the bottom-right triangle.*/
//        /*tri3Paint.setColor(Color.YELLOW);
//        tri3Path.moveTo(width+400, height-50);
//        tri3Path.lineTo(width+600, height+300);
//        tri3Path.lineTo(width+200, height+300);
//        tri2Path.lineTo(width+400, height-50);
//        c.drawPath(tri3Path, tri3Paint);*/
//
//        c.drawCircle((float)width+450, (height-25)+range, radius, centerBoardPaint);   //row 9
//        c.drawCircle((float)width+400,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width+500,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width+350,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width+450,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width+550,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width+300,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width+400,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width+500,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width+600,(height+200)+range,radius,centerBoardPaint);    //row 12
//
//        /*Draw the bottom triangle.*/
//        /*tri4Paint.setColor(Color.RED);
//        tri4Path.moveTo(width+200, height+300);
//        tri4Path.lineTo(width, height+650);
//        tri4Path.lineTo(width-200, height+300);
//        tri4Path.lineTo(width+200, height+300);
//        c.drawPath(tri4Path, tri4Paint);*/
//
//        c.drawCircle((float)width, (height+500)+range, radius, centerBoardPaint);        //row 16
//        c.drawCircle(width+50,(height+425)+range, radius, centerBoardPaint);         //row 15
//        c.drawCircle(width-50,(height+425)+range, radius, centerBoardPaint);         //row 15
//        c.drawCircle((float)width-100,(height+350)+range, radius, centerBoardPaint); //row 14
//        c.drawCircle((float)width,(height+350)+range,radius,centerBoardPaint);           //row 14
//        c.drawCircle((float)width+100,(height+350)+range,radius,centerBoardPaint);   //row 14
//        c.drawCircle((float)width-150,(height+275)+range,radius,centerBoardPaint);   //row 13
//        c.drawCircle((float)width-50,(height+275)+range,radius,centerBoardPaint);    //row 13
//        c.drawCircle((float)width+50,(height+275)+range,radius,centerBoardPaint);    //row 13
//        c.drawCircle((float)width+150,(height+275)+range,radius,centerBoardPaint);   //row 13
//
//        /*Draw the bottom-left triangle.*/
//        /*int orange = Color.rgb(245, 120, 11);
//        tri5Paint.setColor(orange);
//        tri5Path.moveTo(width-200, height+300);
//        tri5Path.lineTo(width-600, height+300);
//        tri5Path.lineTo(width-400, height-50);
//        tri5Path.lineTo(width-200, height+300);
//        c.drawPath(tri5Path, tri5Paint);*/
//
//        c.drawCircle((float)width-450,(height-20)+range, radius, centerBoardPaint);   //row 9
//        c.drawCircle((float)width-500,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width-400,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width-550,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width-450,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width-350,(height+125)+range,radius,centerBoardPaint);    //row 11
//        c.drawCircle((float)width-300,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width-400,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width-500,(height+200)+range,radius,centerBoardPaint);    //row 12
//        c.drawCircle((float)width-600,(height+200)+range,radius,centerBoardPaint);    //row 12
//
//        /*Draw the top-left triangle.*/
//        /*int purple = Color.rgb(159, 11, 245);
//        tri6Paint.setColor(purple);
//        tri6Path.moveTo(width-400, height-50);
//        tri6Path.lineTo(width-600, height-400);
//        tri6Path.lineTo(width-200, height-400);
//        tri6Path.lineTo(width-400, height-50);
//        c.drawPath(tri6Path, tri6Paint);*/
////        c.drawPath(tri6Path, centerBoardPaint);
//
//        c.drawCircle((float)width-300,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-400,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-500,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-600,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-350,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width-450,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width-550,(height-325)+range,radius,centerBoardPaint);   //row 5
//        c.drawCircle((float)width-400,(height-250)+range,radius,centerBoardPaint);   //row 6
//        c.drawCircle((float)width-500,(height-250)+range,radius,centerBoardPaint);   //row 6
//        c.drawCircle((float)width-450,(height-175)+range,radius,centerBoardPaint);   //row 7
//
//        /*Draw the central space.*/
//        /*hexPaint.setColor(Color.WHITE);
//        hexPath.moveTo(width-200, height-400);
//        hexPath.lineTo(width+200, height-400);
//        hexPath.lineTo(width+400, height-50);
//        hexPath.lineTo(width+200, height+300);
//        hexPath.lineTo(width-200, height+300);
//        hexPath.lineTo(width-400, height-50);
//        hexPath.lineTo(width-200, height-400);*/
////        c.drawPath(hexPath, hexPaint);
//
//        c.drawCircle((float)width+100,(height+200)+range,radius,centerBoardPaint);     //row 12
//        c.drawCircle((float)width+200,(height+200)+range,radius,centerBoardPaint);     //row 12
//        c.drawCircle((float)width-100,(height+200)+range,radius,centerBoardPaint);     //row 12
//        c.drawCircle((float)width-200,(height+200)+range,radius,centerBoardPaint);     //row 12
//        c.drawCircle((float)width,(height+200)+range,radius,centerBoardPaint);             //row 12
//        c.drawCircle((float)width-150,(height+125)+range,radius,centerBoardPaint);     //row 11
//        c.drawCircle((float)width-50,(height+125)+range,radius,centerBoardPaint);      //row 11
//        c.drawCircle((float)width+50,(height+125)+range,radius,centerBoardPaint);      //row 11
//        c.drawCircle((float)width+150,(height+125)+range,radius,centerBoardPaint);     //row 11
//        c.drawCircle((float)width+250,(height+125)+range,radius,centerBoardPaint);     //row 11
//        c.drawCircle((float)width-250,(height+125)+range,radius,centerBoardPaint);     //row 11
//        c.drawCircle((float)width,(height+50)+range,radius,centerBoardPaint);             //row 10
//        c.drawCircle((float)width+100,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width-100,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width-200,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width+200,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width-300,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width+300,(height+50)+range,radius,centerBoardPaint);     //row 10
//        c.drawCircle((float)width+50,(height-25)+range,radius,centerBoardPaint);      //row 9
//        c.drawCircle((float)width-50,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width+150,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width-150,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width+250,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width-250,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width+350,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width-350,(height-25)+range,radius,centerBoardPaint);     //row 9
//        c.drawCircle((float)width,(height-100)+range,radius,centerBoardPaint);             //row 8
//        c.drawCircle((float)width+100,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width-100,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width-200,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width+200,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width-300,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width+300,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width+400,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width-400,(height-100)+range,radius,centerBoardPaint);     //row 8
//        c.drawCircle((float)width+50,(height-175)+range,radius,centerBoardPaint);      //row 7
//        c.drawCircle((float)width-50,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width+150,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width-150,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width+250,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width-250,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width+350,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width-350,(height-175)+range,radius,centerBoardPaint);     //row 7
//        c.drawCircle((float)width,(height-250)+range,radius,centerBoardPaint);             //row 6
//        c.drawCircle((float)width+100,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width-100,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width-200,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width+200,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width-300,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width+300,(height-250)+range,radius,centerBoardPaint);     //row 6
//        c.drawCircle((float)width-150,(height-325)+range,radius,centerBoardPaint);     //row 5
//        c.drawCircle((float)width-50,(height-325)+range,radius,centerBoardPaint);      //row 5
//        c.drawCircle((float)width+50,(height-325)+range,radius,centerBoardPaint);      //row 5
//        c.drawCircle((float)width+150,(height-325)+range,radius,centerBoardPaint);     //row 5
//        c.drawCircle((float)width+250,(height-325)+range,radius,centerBoardPaint);     //row 5
//        c.drawCircle((float)width-250,(height-325)+range,radius,centerBoardPaint);     //row 5
//        c.drawCircle((float)width+100,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width+200,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-100,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width-200,(height-400)+range,radius,centerBoardPaint);     //row 4
//        c.drawCircle((float)width,(height-400)+range,radius,centerBoardPaint);             //row 4









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
