package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCLocalGame;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.actionMsg.CCAction;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by qihangwu on 10/30/17.
 */

public class LocalGame extends CCLocalGame {

    // the game's state
    protected CCGameState state;

    // the marks for player 0 and player 1, respectively
    //private final static char[] mark = {'X','O'};

    // the number of moves that have been played so far, used to
    // determine whether the game is over
    //protected int moveCount;

    /**
     * Constructor for the LocalGame.
     */
    public LocalGame() {

        // perform superclass initialization
        super();

        // create a new, unfilled-in CCGameState object
        state = new CCGameState();
    }

    @Override
    protected void sendUpdatedStateTo(CCPlayer p) {
        
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(CCAction action) {
        return false;
    }

    protected boolean confirmMove(CCAction action) {
        return false;
    }

    protected boolean cancelMove(CCAction action) {
        return false;
    }
}
