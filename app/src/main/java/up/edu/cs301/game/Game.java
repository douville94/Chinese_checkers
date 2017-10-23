package up.edu.cs301.game;

import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by C.J. Cao, Charlie Wu, Emmanuel Sion, & Luke Douville on 10/23/17.
 * To support remote play, this game framework has two types of Games: local
 * games and remote games that are represented by a proxy. Both types adhere to
 * this common interface.
 */

public interface Game
{
    public abstract void start(GamePlayer[] players);

    public abstract void sendAction(GameAction action);
}
