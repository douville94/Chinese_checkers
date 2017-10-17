package up.edu.cs301.chinese_checkers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.SurfaceView;
import android.graphics.Path;

public class MainActivity extends AppCompatActivity
{
    private TextView turnTextView;
    private TextView currentPlayerTextView;
    private SurfaceView boardSurfaceView;
//    private Path board;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turnTextView = (TextView)findViewById(R.id.turnTextView);
        currentPlayerTextView = (TextView)findViewById(R.id.currentPlayerTextView);
    }
}
