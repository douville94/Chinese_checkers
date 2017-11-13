package up.edu.cs301.chinese_checkers;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class Marble
{
    int color, position, playerNum;

    public Marble(int color, int position, int playerNum)
    {
        this.color = color;
        this.position = position;
        this.playerNum = playerNum;
    }

    public int getColor()
    {
        return color;
    }

    public int getPosition()
    {
        return position;
    }

    public int getPlayerNum()
    {
        return playerNum;
    }
}
