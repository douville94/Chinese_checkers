package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.actionMsg.CCAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class SaveAction extends CCAction
{
    private CCPlayer player;

    public SaveAction(CCPlayer p)
    {
        super(p);
        this.player = p;
    }
}
