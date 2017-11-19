package up.edu.cs301.chinese_checkers;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class Marble
{
    int color, row, col, playerNum;

    public Marble(int color, int row, int col, int playerNum)
    {
        this.color = color;
        this.row = row;
        this.col = col;
        this.playerNum = playerNum;
    }

    public int getColor()
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
        return playerNum;
    }
}
