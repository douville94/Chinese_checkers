package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.actionMsg.GameAction;
import up.edu.cs301.game.Player;

/**
 * Created by Luke Douville on 11/18/17.
 */

public class CancelAction extends GameAction
{
    Player player;

    public CancelAction(Player p)
    {
        super(p);
        this.player = p;
    }
}
