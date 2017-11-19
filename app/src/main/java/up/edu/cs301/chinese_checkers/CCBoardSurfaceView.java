package up.edu.cs301.chinese_checkers;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by sion18 on 11/19/2017.
 */

public class CCBoardSurfaceView {//extends SurfaceView {
    public boolean[][] CCBoard;
//    public int[][] CCBoard;

    public CCBoardSurfaceView()
    {
        CCBoard = new boolean[][]{
                { false, false, false, false, false, false, true, false, false, false, false, false, false }, // row 0

                { false, false, false, false, false,  true, true, false, false, false, false, false, false }, // row 1

                { false, false, false, false, false,  true, true,  true, false, false, false, false, false }, // row 2

                { false, false, false, false,  true,  true, true,  true, false, false, false, false, false }, // row 3

                {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true }, // row 4

                {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 5

                { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 6

                { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 7

                { false, false,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 8 -----

                { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 7

                { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 6

                {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 5

                {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true }, // row 4

                { false, false, false, false,  true,  true, true,  true, false, false, false, false, false }, // row 3

                { false, false, false, false, false,  true, true,  true, false, false, false, false, false }, // row 2

                { false, false, false, false, false,  true, true, false, false, false, false, false, false }, // row 1

                { false, false, false, false, false, false, true, false, false, false, false, false, false }, // row 0
        };
    }

//    public void setCCBoard(boolean[][] argBoard, Marble argMarble)
    public void setCCBoard(int x, int y, Marble argMarble) {
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

        for (int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
//                if(CCBoard[i][j] == true)
//                {
//
//                }
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
