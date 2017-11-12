package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.ComputerPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;

/**
 * Created by douvillionaire on 10/25/17.
 */

public class SmartAI extends ComputerPlayer
{
    private CCInfo info;

    public SmartAI(String name)
    {
        super(name);
    }

    @Override
    public void receiveInfo(CCInfo i)
    {
        this.info = i;
    }
}
