package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.LocalGame;
import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Charlie Wu on 10/30/17.
 */

public class CCLocalGame extends LocalGame {

    // the game's state
    protected CCGameState state;

    // the marks for player 0 and player 1, respectively
    private final static char[] mark = {'X','O'};

    // the number of moves that have been played so far, used to
    // determine whether the game is over
    protected int moveCount;

    private CCHumanPlayer chp;

    /**
     * Constructor for the LocalGame.
     */
    public CCLocalGame() {

        // perform superclass initialization
        super();

        // create a new, unfilled-in CCGameState object
        state = new CCGameState(state);
    }

    /**
     * Notify the given player that its state has changed. This should involve sending
     * a GameInfo object to the player. If the game is not a perfect-information game
     * this method should remove any information from the game that the player is not
     * allowed to know.
     *
     * @param p
     * 			the player to notify
     */
    @Override
    protected void sendUpdatedStateTo(Player p) {
        // make a copy of the state, and send it to the player
        p.sendInfo(new CCGameState(state));
    }

    /**
     * Tell whether the given player is allowed to make a move at the
     * present point in the game.
     *
     * @param playerID
     * 		the player's player-number (ID)
     * @return
     * 		true iff the player is allowed to move
     */
    @Override
    protected boolean canMove(int playerID) {
        return playerID == state.getWhoseMove();
    }

    /**
     * Check if the game is over. It is over, return a string that tells
     * who the winner(s), if any, are. If the game is not over, return null;
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {return null; }

    /**
     * Makes a move on behalf of a player.
     *
     * @param action
     * 			The move that the player has sent to the game
     * @return
     * 			Tells whether the move was a legal one.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        // get the row and column position of the player's move
        MoveAction tm = (MoveAction) action;
        int row = tm.getRow();
        int col = tm.getCol();

        // get the player id of our player
        int playerId = getPlayerIdx(tm.getPlayer());

        // if that space is not blank, indicate an illegal move
        if (state.getMarble(row, col) != null) {
            return false;
        }

        // get the player id of the player whose move it is
        int whoseMove = state.getWhoseMove();

        // place the player's piece on the selected square
//        state.setBoard(row, col, whoseMove);

        return false;
    }

    protected boolean confirmMove(ConfirmAction action) {
        //still need the confirm action.
//        ConfirmAction confirmMove = new ConfirmAction(chp);
        ConfirmAction confirmMove = action;
        return true;
    }

    protected boolean cancelMove(CancelAction action) {
        //still need the cancel action
        return false;
    }

    protected boolean saveMove(SaveAction action) {
        //still need the save action be modified.
        return false;
    }

    protected boolean quitAction(QuitAction action) {
        //still need the quit action be modified.
        return false;
    }
}
