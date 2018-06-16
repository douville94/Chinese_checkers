package edu.up.cs301.chinese_checkers;

import android.util.Log;
import android.view.SurfaceView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.config.GameConfig;
import edu.up.cs301.game.config.GamePlayerType;

/**
 * this is the primary activity for Chinese Checker game
 *
 * @author Emmanuel Sion
 *
 */
public class CCMainActivity extends GameMainActivity //AppCompatActivity/
{
    /*Insert port number to use over network play.*/
    /*May need to change port number later; copied this port number over from TttGame repository.*/
    private static final int PORT_NUMBER = 5213;
    /**
     * a chinese checker game is for up to players. The default is human vs. one computer
     */
    @Override
    public GameConfig createDefaultConfig() {
        //define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // Local Human Player GUI
        playerTypes.add(new GamePlayerType("Local Human Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new CCHumanPlayer(name);
            }
        });

        //add dumbAI
        playerTypes.add(new GamePlayerType("Dumb AI") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new DumbAI(name);
            }
        });

        //add smartAI
        playerTypes.add(new GamePlayerType("Smart AI") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new SmartAI(name);
            }
        });

        // Create a game configuration class for chinese checkers
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,6,
                "Chinese Checkers", PORT_NUMBER);

        //add default players
        defaultConfig.addPlayer("Human",0);
        defaultConfig.addPlayer("Computer",1);

        //set remote player
        defaultConfig.setRemoteData("Remote Player","",1);

        return defaultConfig;
    }

    /**
     * createLocalGame
     *
     * Creates a new game that runs on the server tablet,
     *
     * @return a new, game-specific instance of a sub-class of the LocalGame
     *         class.
     */
    @Override
    public LocalGame createLocalGame() { return new CCLocalGame(); }
}
