package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class SaveAction extends GameAction
{
    private Player player;
    private int x, y;

    public SaveAction(Player p)//, Marble m)
    {
        super(p);
        this.player = p;

//        x = m.getRow();
//        y = m.getCol();
    }

//    public int getXPosition()
//    {
//        return x;
//    }
//
//    public int getYPosition()
//    {
//        return y;
//    }
}
