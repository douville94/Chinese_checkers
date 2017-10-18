package up.edu.cs301.chinese_checkers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.SurfaceView;
import android.graphics.Path;
import android.graphics.Canvas;

public class MainActivity extends AppCompatActivity
{
    private TextView turnTextView;
    private TextView currentPlayerTextView;
    private SurfaceView boardSurfaceView;
//    private Path board;
    private Board b;
//    private Canvas c;
//    private BoardSurfaceView bsf;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turnTextView = (TextView)findViewById(R.id.turnTextView);
        currentPlayerTextView = (TextView)findViewById(R.id.currentPlayerTextView);
        boardSurfaceView = (SurfaceView)findViewById(R.id.boardSurfaceView);
//        BoardSurfaceView bsf = (BoardSurfaceView)findViewById(R.id.boardSurfaceView);
//        b = new Board();
//        c = new Canvas();/*These two lines cause program to crash*/
//        b.draw(c);
        boardSurfaceView.invalidate();
//        bsf.invalidate();
    }
}
