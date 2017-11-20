package up.edu.cs301.chinese_checkers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by sion18 on 11/19/2017.
 */

public class CCBoardSurfaceView {//extends SurfaceView {
//    public boolean[][] CCBoard;
    public int[][] CCBoard;

    public CCBoardSurfaceView()
    {
        CCBoard = new int[][]{
                { -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1 }, // row 0

                { -1, -1, -1, -1, -1,  0,  0, -1, -1, -1, -1, -1, -1 }, // row 1

                { -1, -1, -1, -1, -1,  0,  0,  0, -1, -1, -1, -1, -1 }, // row 2

                { -1, -1, -1, -1,  0,  0,  0,  0, -1, -1, -1, -1, -1 }, // row 3

                {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }, // row 4

                {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 }, // row 5

                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 }, // row 6

                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1 }, // row 7

                { -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1 }, // row 8 -----

                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1 }, // row 9

                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 }, // row 10

                {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 }, // row 11

                {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 }, // row 12

                { -1, -1, -1, -1,  0,  0,  0,  0, -1, -1, -1, -1, -1 }, // row 13

                { -1, -1, -1, -1, -1,  0,  0,  0, -1, -1, -1, -1, -1 }, // row 14

                { -1, -1, -1, -1, -1,  0,  0, -1, -1, -1, -1, -1, -1 }, // row 15

                { -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1 }, // row 16
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
                if(i != -1 && j != -1)
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
                if(i != -1 && j != -1)
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
                if(i != -1 && j != -1)
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
                if(i != -1 && j != -1)
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
                if(i != -1 && j != -1)
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
                if(i != -1 && j != -1)
                {
                    argMarble.setRow(i);
                    argMarble.setCol(j);
                    CCBoard[i][j] = 1;
                    argMarble.setColor(Color.MAGENTA);
                }
            }
        }
    }

//    public CCBoardSurfaceView(Context context){
//        super(context);
//    }
//    public void onDraw(){
//
//    }
//
//    public CCBoardSurfaceView(Context context, AttributeSet attrs ){
//        super(context, attrs);
//    }
//
//    public CCBoardSurfaceView(Context context, AttributeSet attrs , int defStyleAttr){
//        super(context, attrs, defStyleAttr);
//    }
//
//    public void onDraw(Canvas c){
//
//    }

}
