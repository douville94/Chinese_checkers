package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCLocalGame;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.actionMsg.CCAction;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by Charlie Wu on 10/30/17.
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
        state = new CCGameState(state);
    }

    @Override
    protected void sendUpdatedStateTo(CCPlayer p) {
        // make a copy of the state, and send it to the player
        p.sendInfo(new CCGameState(state));
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == state.getWhoseMove();
    }

    @Override
    protected String checkIfGameOver() {return null; }

    @Override
    protected boolean makeMove(CCAction action) {
        return false;
    }

    protected boolean confirmMove(CCAction action) {
        //still need the confirm action.
        return false;
    }

    protected boolean cancelMove(CCAction action) {
        //still need the cancel action
        return false;
    }

    protected boolean saveMove(CCAction action) {
        //still need the save action be modified.
        return false;
    }

    protected boolean quitAction(CCAction action) {
        //still need the quit action be modified.
        return false;
    }
}
