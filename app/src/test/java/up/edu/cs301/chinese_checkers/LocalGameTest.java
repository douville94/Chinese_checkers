package up.edu.cs301.chinese_checkers;

import android.view.View;

import org.junit.Test;

import up.edu.cs301.game.CCHumanPlayer;
import up.edu.cs301.game.CCMainActivity;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;

import static org.junit.Assert.*;

/**
 * Created by sion18 on 11/9/2017.
 */
public class LocalGameTest {
    @Test
    public void sendUpdatedStateTo() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        //Check if player's game state is equal to cgs

    }

    @Test
    public void canMove() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        assertTrue("unable to move",lg.canMove(0));
    }

    @Test
    public void checkIfGameOver() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        //

    }

    @Test
    public void makeMove() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        assertTrue("unable to move piece", lg.makeMove(JumpAction));
        assertTrue("unable to move piece", lg.makeMove(MoveAction));
        assertTrue("unable to reset", lg.makeMove(QuitAction ));
        //checks to see if if able to move
    }

    @Test
    public void confirmMove() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        assertTrue("unable to move piece", lg.makeMove(SaveAction));
        //checks to see if if able to confirm move
        //check game state if player id changed
    }

    @Test
    public void cancelMove() throws Exception {
        CCGameState cgs = new CCGameState();
        LocalGame lg = new LocalGame();
        //save cgs.board
        //check if board/
    }

}