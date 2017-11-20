package up.edu.cs301.chinese_checkers;

import java.util.Random;

import up.edu.cs301.game.ComputerPlayer;
import up.edu.cs301.game.infoMsg.GameInfo;
import up.edu.cs301.game.infoMsg.NotYourTurnInfo;

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

//    private Marble m;
    /*MoveAction needs to have a Marble object but then we have initialize a Marble object in this class
    so that we can pass it in.
     */


    @Override
    public void receiveInfo(GameInfo info)
    {
        // if it was a "not your turn" message, just ignore it
        if (info instanceof NotYourTurnInfo) return;

        Random random = new Random();


        sleep(1000);
        game.sendAction(new MoveAction(this));
//        game.sendAction(new MoveAction(this, m));
    }
}
