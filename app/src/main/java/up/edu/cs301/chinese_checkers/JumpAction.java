package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.actionMsg.CCAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class JumpAction extends CCAction
{
    private CCPlayer player;

    public JumpAction(CCPlayer p)
    {
        super(p);
        this.player = p;
    }
}
