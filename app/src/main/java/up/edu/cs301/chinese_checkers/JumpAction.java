package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.CCAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class JumpAction extends CCAction
{
    private Player player;
    private int playerNum;
    private Marble m;
    private int currPos;
    private int goalPos;

    public JumpAction(Player p, int playerNum, Marble m, int currPos, int goalPos)
    {
        super(p);
        this.player = p;
        this.playerNum = playerNum;
        this.m = m;
        this.currPos = currPos;
        this.goalPos = goalPos;
    }
}
