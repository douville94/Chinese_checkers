package up.edu.cs301.chinese_checkers;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.TextView;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import java.util.ArrayList;

import up.edu.cs301.game.MainActivity;
import up.edu.cs301.game.LocalGame;
import up.edu.cs301.game.Player;
import up.edu.cs301.game.config.GameConfig;
import up.edu.cs301.game.config.GamePlayerType;

public class CCMainActivity extends MainActivity //AppCompatActivity
{
    private TextView turnTextView;
    private TextView currentPlayerTextView;
    private SurfaceView surface;
//    private GamePlayerType[] gpt;
    private ArrayList<GamePlayerType> gpt;
    private GameConfig defaultConfig;

    /*Insert port number to use over network play.*/
    /*May need to change port number later; copied this port number over from TttGame repository.*/
    private static final int PORT_NUMBER = 5213;

    @Override
    public GameConfig createDefaultConfig()
    {
//        gpt = new GamePlayerType[6];
//        gpt[0] = new GamePlayerType("Local Human Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new CCHumanPlayer(name);//, R.layout.activity_main);
//            }
//        };
//        gpt[1] = new GamePlayerType("Dumb Computer Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new DumbAI(name);
//            }
//        };
//        gpt[2] = new GamePlayerType("Smart Computer Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new SmartAI(name);
//            }
//        };

//        gpt = new ArrayList<GamePlayerType>();
//        gpt.add(new GamePlayerType("Local Human Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new CCHumanPlayer(name);
//            }
//        });
//        gpt.add(new GamePlayerType("Dumb Computer Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new DumbAI(name);
//            }
//        });
//        gpt.add(new GamePlayerType("Smart Computer Player")
//        {
//            public Player createPlayer(String name)
//            {
//                return new SmartAI(name);
//            }
//        });
//
//        defaultConfig = new GameConfig(gpt, 2, 6, "Chinese checkers", PORT_NUMBER);
//
//        /*Add the default players.*/
//        defaultConfig.addPlayer("Human", 0);
//        defaultConfig.addPlayer("Dumb Computer Player", 1);
//
//        /*Set the initial value for the remote player.*/
//        defaultConfig.setRemoteData("Remote Player", "", 2);
//
        return defaultConfig;
    }

    @Override
    public LocalGame createLocalGame()
    {
        return new CCLocalGame();
    }
}
