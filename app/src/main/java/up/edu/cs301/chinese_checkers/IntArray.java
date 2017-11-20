package up.edu.cs301.chinese_checkers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by sion18 on 11/19/2017.
 */

public class IntArray
{//extends SurfaceView {
//    public boolean[][] CCBoard;
    public int[][] CCBoard;

    public IntArray()
    {
        /*As per Vegdahl's recommendations on 11/20/2017:
        * Factor playerId (from Marble class) into CCBoard so that -2 is invalid, -1 is empty,
        * 0 designates player 1, 1 designates player two, and so on.*/
        CCBoard = new int[][]{
                { -2, -2, -2, -2, -2, -2,  -1, -2, -2, -2, -2, -2, -2 }, // row 0

                { -2, -2, -2, -2, -2,  -1,  -1, -2, -2, -2, -2, -2, -2 }, // row 1

                { -2, -2, -2, -2, -2,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 2

                { -2, -2, -2, -2,  -1,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 3

                {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }, // row 4

                {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 5

                { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 6

                { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 7

                { -2, -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 8 -----

                { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 9

                { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 1-1

                {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 11

                {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }, // row 12

                { -2, -2, -2, -2,  -1,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 13

                { -2, -2, -2, -2, -2,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 14

                { -2, -2, -2, -2, -2,  -1,  -1, -2, -2, -2, -2, -2, -2 }, // row 15

                { -2, -2, -2, -2, -2, -2,  -1, -2, -2, -2, -2, -2, -2 }, // row 16
        };
    }

//    public void setCCBoard(boolean[][] argBoard, Marble argMarble)
    public void setTopCorner(Marble argMarble) {
        //set a Marble to a true position on the CCBoard (defined above)
        //we need a distinction between false and empty
//        for(int i = x; i < 13; i++)
//        {
//            for(int j = y; j < 4; j++) {
//                if (CCBoard[i][j] == true) {
//                    argMarble.setRow(i);
//                    argMarble.setCol(j);
//                }
//            }
//        }

        for (int i = 0; i < 13; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.RED);
                }
            }
        }
    }

    public void setTopRightCorner(Marble argMarble)
    {
        for (int i = 9; i < 13; i++)
        {
            for(int j = 4; j < 8; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.YELLOW);
                }
            }
        }
    }

    public void setBottomRightCorner(Marble argMarble)
    {
        for (int i = 9; i < 13; i++)
        {
            for(int j = 13; j < 17; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.GREEN);
                }
            }
        }
    }

    public void setBottomCorner(Marble argMarble)
    {
        for (int i = 4; i < 8; i++)
        {
            for(int j = 13; j < 17; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.CYAN);
                }
            }
        }
    }

    public void setBottomLeftCorner(Marble argMarble)
    {
        for (int i = 0; i < 4; i++)
        {
            for(int j = 13; j < 17; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.BLUE);
                }
            }
        }
    }

    public void setTopLeftCorner(Marble argMarble)
    {
        for (int i = 0; i < 4; i++)
        {
            for(int j = 4; j < 8; j++)
            {
                if(i != -2 && j != -2)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.MAGENTA);
                }
            }
        }
    }

//    public IntArray(Context context){
//        super(context);
//    }
//    public void onDraw(){
//
//    }
//
//    public IntArray(Context context, AttributeSet attrs ){
//        super(context, attrs);
//    }
//
//    public IntArray(Context context, AttributeSet attrs , int defStyleAttr){
//        super(context, attrs, defStyleAttr);
//    }
//
//    public void onDraw(Canvas c){
//
//    }

}
