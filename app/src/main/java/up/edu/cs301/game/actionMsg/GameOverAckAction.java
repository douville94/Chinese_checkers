package up.edu.cs301.game.actionMsg;

import up.edu.cs301.game.CCPlayer;

/**
 * An action by which the player acknowledges that the game is over.
 *
 * @author Steven R. Vegdahl
 * @version July 2013
 */
public class GameOverAckAction extends CCAction
{

    // to satisfy the Serializable interface
    private static final long serialVersionUID = 4096230060363451102L;

    /**
     * constructor
     *
     * @param p the player to sent the action
     */
    public GameOverAckAction(CCPlayer p)
    {
        super(p);
    }
}
