package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.ComputerPlayer;
import up.edu.cs301.game.infoMsg.GameInfo;

/**
 * Created by douvillionaire on 10/25/17.
 */

public class SmartAI extends ComputerPlayer
{
    private GameInfo info;

    public SmartAI(String name)
    {
        super(name);
    }

    @Override
    public void receiveInfo(GameInfo i)
    {
        this.info = i;
    }
}
