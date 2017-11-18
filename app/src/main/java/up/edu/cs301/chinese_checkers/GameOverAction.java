package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class GameOverAction extends GameAction
{
    private Player player;

    public GameOverAction(Player p)
    {
        super(p);
        this.player = p;
    }

    //get other variables for the state of the game
}
