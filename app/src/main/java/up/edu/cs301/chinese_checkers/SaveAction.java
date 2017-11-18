package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class SaveAction extends GameAction
{
    private Player player;

    public SaveAction(Player p)
    {
        super(p);
        this.player = p;
    }
}
