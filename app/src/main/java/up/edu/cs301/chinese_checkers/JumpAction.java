package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class JumpAction extends GameAction
{
    private Player player;
    private int playerNum;
    private Marble m;
    private int[][] currPos;
    private int[][] goalPos;
    private int colorMarble, rowMarble, columnMarble, playerMarble;
    private int row, column;

    public JumpAction(Player p, int playerNum, Marble m, int[][] currPos, int[][] goalPos)
    {
        super(p);
        this.player = p;
        this.playerNum = playerNum;
        this.m = m;
        this.currPos = currPos;
        this.goalPos = goalPos;

        row = m.getRow();
        column = m.getCol();

    }

//    public boolean getMarble(Marble marble) {
//        colorMarble = marble.getColor();
//        rowMarble = marble.getRow();
//        columnMarble = marble.getCol();
//        playerMarble = marble.getPlayerNum();
//        return true;
//    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public int[][] getCurrentPosition()
    {
        return currPos;
    }

    public int[][] getGoalPosition()
    {
        return goalPos;
    }
}
