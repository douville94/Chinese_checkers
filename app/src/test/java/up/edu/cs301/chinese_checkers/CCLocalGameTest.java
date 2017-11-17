package up.edu.cs301.chinese_checkers;

import android.view.View;

import org.junit.Test;

import up.edu.cs301.game.HumanPlayer;
import up.edu.cs301.game.MainActivity;
import up.edu.cs301.game.Player;
import up.edu.cs301.game.infoMsg.CCInfo;
import up.edu.cs301.chinese_checkers.CCLocalGame;

import static org.junit.Assert.*;

/**
 * Created by sion18 on 11/9/2017.
 */
public class CCLocalGameTest {
    private JumpAction ja;
    private MoveAction ma;
    private QuitAction qa;
    private SaveAction sa;
    @Test
    public void sendUpdatedStateTo() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        //Check if player's game state is equal to cgs

    }

    @Test
    public void canMove() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        assertTrue("unable to move",lg.canMove(0));
    }

    @Test
    public void checkIfGameOver() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        //

    }

    @Test
    public void makeMove() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        assertTrue("unable to move piece", lg.makeMove(ja));
        assertTrue("unable to move piece", lg.makeMove(ma));
        assertTrue("unable to reset", lg.makeMove(qa));
        //checks to see if if able to move
    }

    @Test
    public void confirmMove() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        assertTrue("unable to move piece", lg.makeMove(sa));
        //checks to see if if able to confirm move
        //check game state if player id changed
    }

    @Test
    public void cancelMove() throws Exception {
        CCGameState cgs = new CCGameState();
        CCLocalGame lg = new CCLocalGame();
        //save cgs.board
        //check if board/
    }

}