package edu.up.cs301.chinese_checkers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.util.FlashSurfaceView;

/**
 *
 * A SurfaceView which allows which an animation to be drawn on it by a
 * Animator.
 *
 *
 *
 * Created by Luke D. Douville on 10/17/17.
 */

public class BoardSurfaceView extends FlashSurfaceView {//implements SurfaceHolder.Callback {
    private float radius;
    protected Paint centerBoardPaint = new Paint(), player0Paint = new Paint(), player1Paint = new Paint(),
            player2Paint = new Paint(), player3Paint = new Paint(), player4Paint = new Paint(),
            player5Paint = new Paint();
    protected CCGameState cgs;
    private float[][] xposition = new float[17][13];
    private float[][] yposition = new float[17][13];
    private int[][] intArray;


    /**
     * Constructor for the BoardSurfaceView class.
     *
     * @param context - a reference to the activity this animation is run under
     */
    public BoardSurfaceView(Context context) {
        super(context);
        init();
    }

    /**
     * An alternate constructor for use when a subclass is directly specified
     * in the layout.
     *
     * @param context - a reference to the activity this animation is run under
     * @param as   - set of attributes passed from system
     */

    public BoardSurfaceView(Context context, AttributeSet as) {
        super(context, as);
        if(!isInEditMode())
        {
            init();
        }
    }


    /**
     * Helper-method for the constructors
     * Initialize the color of different pieces.
     */
    private void init() {
        player0Paint.setColor(Color.BLUE);
        player1Paint.setColor(Color.GREEN);
        player2Paint.setColor(Color.YELLOW);
        player3Paint.setColor(Color.rgb(255, 255, 255));//white
        player4Paint.setColor(Color.rgb(255, 119, 0));//orange
        player5Paint.setColor(Color.rgb(174, 23, 179));//purple
    }

    @Override
    public void onDraw(Canvas c) {
        if (cgs == null) {
            return;
        }
        //variables for coordinate
        intArray = cgs.getIntArray();
        radius = (50/3)*(float) Math.sqrt(3.0);

        int x;
        int y = 40;
        boolean offset = false;

        //iterate each row
        for(int i = 0; i < 17; i++) {
            //iterate each row
            y+=100;
            if(offset) {
                x = 250;
            }
            else {
                x = 200;
            }
           // iterate each column
            for(int j = 0; j < 13; j++) {
                int z = intArray[i][j];
                switch (z) {
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
                        c.drawCircle(x, y, radius, player0Paint);//on touch, turns white at j = 7
                        xposition[i][j] = (float) x;
                        yposition[i][j] = (float) y;
                        break;
                    case 1: //player2
                        c.drawCircle(x,y, radius, player1Paint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 2: //player3
                        c.drawCircle(x,y, radius, player2Paint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 3: //player4
                        c.drawCircle(x,y, radius, player3Paint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 4: //player5
                        c.drawCircle(x,y, radius, player4Paint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    case 5: //player6
                        c.drawCircle(x,y, radius, player5Paint);
                        xposition[i][j] = (float)x;
                        yposition[i][j] = (float)y;
                        break;
                    default:
                        break;
                }
                x+=95;
                y-=1;
            }
            offset = !offset;
        }
    }

    public void setState(CCGameState CCGameState){
        cgs = CCGameState;
    }

    public int mapPixelToMarble(float x, float y) {
        intArray = cgs.getIntArray();
        int[][] tempXPosition = cgs .xPositions;
        int[][] tempYPosition = cgs.yPositions;
        for (int i=0; i<17; i++) {
            for (int j=0; j<13; j++) {
                int myX = tempXPosition[i][j];
                int myY = tempYPosition[i][j];
                double dx = myX - x;
                double dy = myY - y;
                if (Math.sqrt(dx * dx + dy * dy) < 80) {
                    return intArray[i][j];
                }
            }
        }
        return -2;
    }

    public int mapPixelToColPosition(float x, float y) {
        intArray = cgs.getIntArray();
        int[][] tempXPosition = cgs.xPositions;
        int[][] tempYPosition = cgs.yPositions;
        for (int i=0; i<17; i++) {
            for (int j=0; j<13; j++) {
                int myX = tempXPosition[i][j];
                int myY = tempYPosition[i][j];
                double dx = myX - x;
                double dy = myY - y;
                if (Math.sqrt(dx * dx + dy * dy) < 80) {
                    return j;
                }
            }
        }
        return 0;
    }

    public int mapPixelToRowPosition(float x, float y) {
        intArray = cgs.getIntArray();
        int[][] tempXPosition = cgs.xPositions;
        int[][] tempYPosition = cgs.yPositions;
        for (int i=0; i<17; i++) {
            for (int j=0; j<13; j++) {
                int myX = tempXPosition[i][j];
                int myY = tempYPosition[i][j];
                double dx = myX - x;
                double dy = myY - y;
                if (Math.sqrt(dx * dx + dy * dy) < 80) {
                    return i;
                }
            }
        }
        return 0;
    }

    public void redrawWithoutUpdatingState(int startX,int startY,int startValue,
                                           int endX, int endY, int endValue) {
        intArray[endX][endY] = startValue;
        intArray[startX][startY] = endValue;
//        this.invalidate();
    }
}
