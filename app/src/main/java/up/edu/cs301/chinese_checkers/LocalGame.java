package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCLocalGame;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.actionMsg.CCAction;

/**
 * Created by qihangwu on 10/30/17.
 */

public class LocalGame extends CCLocalGame {
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
