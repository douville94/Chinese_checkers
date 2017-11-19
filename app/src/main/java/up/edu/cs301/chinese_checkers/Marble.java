package up.edu.cs301.chinese_checkers;

import android.graphics.Color;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class Marble
{
    int row, col, id;
    Color color;

    public Marble(Color color, int row, int col, int id)
    {
        this.color = color;
        this.row = row;
        this.col = col;
        this.id = id;
    }

    public Color getColor()
    {
        return color;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol() { return col; }

    public int getPlayerNum()
    {
        return id;
    }

    public void setColor(Color c){

    }

    public void setRow(int i ){row = i;}

    public void setCol(int i ){col = i;}

    public void setId(int i ){id = i;}
}
