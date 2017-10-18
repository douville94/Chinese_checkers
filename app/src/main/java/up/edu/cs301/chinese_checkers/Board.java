package up.edu.cs301.chinese_checkers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Path;

/**
 * Created by Luke D. Douville on 10/17/17.
 */

/*Class for drawing the board.*/
public class Board
{
    protected Path board;
    protected Paint myPaint;

    public Board()
    {

    }

    public void draw(Canvas c)
    {
        myPaint.setColor(Color.BLACK);
        /*Draw top triangle.*/
        board.moveTo(500, 200);
        board.lineTo(600, 100);
        board.lineTo(700, 200);

        /*After all Path points set:*/
        c.drawPath(board, myPaint);
    }
}
