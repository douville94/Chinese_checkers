package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by Luke Douville on 11/18/17.
 */

public class ConfirmAction extends GameAction
{
    private Player player;
    private CCState state;

    public ConfirmAction(Player p)
    {
        super(p);
        this.player = p;
    }
}
