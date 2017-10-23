package up.edu.cs301.chinese_checkers;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.widget.TextView;
import android.view.SurfaceView;
import android.graphics.Path;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap;

public class MainActivity extends AppCompatActivity// implements SurfaceHolder.Callback
{
    private TextView turnTextView;
    private TextView currentPlayerTextView;
//    private SurfaceView boardSurfaceView;
//    private SurfaceHolder boardSurfaceHolder;
//    private Path board;
    private Board b;
    private Canvas c;
    private BoardSurfaceView bsf;
//    Path boardPath;//does not get assigned if "private" modifier used
//    Paint boardPaint;
    private Bitmap bm;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turnTextView = (TextView)findViewById(R.id.turnTextView);
        currentPlayerTextView = (TextView)findViewById(R.id.currentPlayerTextView);
//        boardSurfaceView = (SurfaceView)findViewById(R.id.boardSurfaceView);
        bsf = (BoardSurfaceView)findViewById(R.id.boardSurfaceView);
//        bsf = new BoardSurfaceView(this);
//        setContentView(bsf);
//        b = new Board();
//        c = new Canvas();/*These two lines cause program to crash*/
//        b.draw(c);
//        boardSurfaceHolder = boardSurfaceView.getHolder();
//        boardSurfaceHolder.addCallback(this);//this line only works if class implements SurfaceHolder.Callback interface
//        boardSurfaceView.setWillNotDraw(false);
//        boardSurfaceView.invalidate();
//        bsf.invalidate();
        /*Create a Bitmap object?*/
    }

//    protected void onDraw(Canvas c)
//    {
//        b = new Board();
//        boardSurfaceView.draw(c);
//        boardPaint.setColor(Color.BLUE);
//        /*Draw top triangle.*/
//        boardPath.moveTo(500, 200);
//        boardPath.lineTo(600, 100);
//        boardPath.lineTo(700, 200);
//        boardPath.lineTo(500, 200);
//
//        /*After all Path points set:*/
//        c.drawPath(boardPath, boardPaint);

//        c.drawRGB(255, 0, 255);
//    }

//    /*Needed all three of these abstract methods or else the class wouldn't compile.*/
//    @Override
//    public void surfaceChanged(SurfaceHolder sh, int a, int b, int c)
//    {
////        tryDrawing(sh);
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder sh)
//    {
//
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder sh)
//    {
//
//    }
}
