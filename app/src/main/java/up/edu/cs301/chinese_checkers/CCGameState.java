package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCMainActivity;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by qihangwu on 11/5/17.
 */

public class CCGameState extends CCState {

    public CCGameState(CCGameState state) {
        super();
    }
    public int getWhoseMove () {
        return 0;
    }
}
