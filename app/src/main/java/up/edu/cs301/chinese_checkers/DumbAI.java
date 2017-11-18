package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.ComputerPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;
import up.edu.cs301.game.infoMsg.NotYourTurnInfo;

/**
 * Created by douvillionaire on 10/25/17.
 */

public class DumbAI extends ComputerPlayer
{
    private CCInfo info;
    public DumbAI(String name) {
        super(name);
    }

    @Override
    public void receiveInfo(CCInfo info)
    {
        // if it was a "not your turn" message, just ignore it
        if (info instanceof NotYourTurnInfo) return;


        sleep(1000);
        game.sendAction(new MoveAction(this));

    }
}
