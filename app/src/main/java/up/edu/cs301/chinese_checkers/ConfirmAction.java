package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke Douville on 11/18/17.
 */

public class ConfirmAction extends GameAction
{
    Player player;

    public ConfirmAction(Player p)
    {
        super(p);
        this.player = p;
    }
}
