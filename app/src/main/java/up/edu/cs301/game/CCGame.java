package up.edu.cs301.game;

import up.edu.cs301.game.actionMsg.CCAction;

/**
 * To support remote play, this game framework has two types of Games: local
 * games and remote games that are represented by a proxy. Both types adhere to
 * this common interface.
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version July 2013
 * @see CCLocalGame
 * @see ProxyGame
 */

public interface CCGame
{

    /**
     * starts the game
     *
     * @param players the players who are in the game
     */
    public abstract void start(CCPlayer[] players);

    /**
     * sends the given action to the Game object.
     *
     * @param action the action to send
     */
    public abstract void sendAction(CCAction action);

}
