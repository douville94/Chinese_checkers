package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.actionMsg.GameAction;
import up.edu.cs301.game.Player;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class QuitAction extends GameAction
{
    private Player player;

    public QuitAction(Player p)
    {
        super(p);
        this.player = p;
    }
}
