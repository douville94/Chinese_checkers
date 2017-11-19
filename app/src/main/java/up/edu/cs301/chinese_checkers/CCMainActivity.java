package up.edu.cs301.chinese_checkers;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.TextView;
import android.graphics.Canvas;
import android.graphics.Bitmap;

import up.edu.cs301.game.LocalGame;
import up.edu.cs301.game.config.GameConfig;

public class CCMainActivity extends up.edu.cs301.game.MainActivity //AppCompatActivity
{
    private TextView turnTextView;
    private TextView currentPlayerTextView;

    private GameConfig g;
    private LocalGame c;
    private SurfaceView surface;


    /*Insert port number to use over network play.*/
//    private static final int PORT_NUMBER =

    @Override
    public GameConfig createDefaultConfig()
    {
        return g;
    }

    @Override
    public LocalGame createLocalGame()
    {
        return c;
    }


}
