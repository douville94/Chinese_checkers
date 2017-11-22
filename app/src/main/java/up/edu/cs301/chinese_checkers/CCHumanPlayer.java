package up.edu.cs301.chinese_checkers;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import up.edu.cs301.game.HumanPlayer;
import up.edu.cs301.game.MainActivity;
import up.edu.cs301.game.infoMsg.GameInfo;

/**
 * Created by sizhecao on 11/12/17.
 */

public class CCHumanPlayer extends HumanPlayer implements View.OnTouchListener {


    // the current activity
    private Activity myActivity;

    // the surface view
    //private CCSurfaceView surfaceView;

    // the ID for the layout to use
    private int layoutId;

    private TextView turnTextView, currentPlayerTextView;
    private BoardSurfaceView bsf;
    private Button confirm, cancel, save, quit;

    private ConfirmAction conf;
    private CancelAction canc;
    private SaveAction saveAction;
    private QuitAction quitAction;

    private Intent myIntent;

    /**
     * constructor
     *
     * @param name
     * 		the player's name
     */
//     * @param layoutId
//     *      the id of the layout to use
//     */
    public CCHumanPlayer(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
    }

    /**
     * Callback method, called when player gets a message
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

        /*if (surfaceView == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            // if the move was out of turn or otherwise illegal, flash the screen
            surfaceView.flash(Color.RED, 50);
        }
        else if (!(info instanceof GameState))
            // if we do not have a GameState, ignore
            return;
        else {
            surfaceView.setState((GameState)info);
            surfaceView.invalidate();
            Log.i("human player", "receiving");
        }*/
    }

    /**
     * sets the current player as the activity's GUI
     */
//    public void setAsGui(CCMainActivity activity) {
    @Override
    public void setAsGui(MainActivity activity) {

        // remember our activity
        myActivity = activity;

        // Load the layout resource for the new configuration
        activity.setContentView(layoutId);

        // set the surfaceView instance variable
        //surfaceView = (CCSurfaceView)myActivity.findViewById(R.id.surfaceView);
        Log.i("set listener","OnTouch");
        turnTextView = (TextView)myActivity.findViewById(R.id.turnTextView);
        currentPlayerTextView = (TextView)myActivity.findViewById(R.id.currentPlayerTextView);
        bsf = (BoardSurfaceView)myActivity.findViewById(R.id.boardSurfaceView);
        confirm = (Button)myActivity.findViewById(R.id.confirm);
        confirm.setOnClickListener(new confirmButtonListener());
        cancel = (Button)myActivity.findViewById(R.id.cancel);
        cancel.setOnClickListener(new cancelButtonListener());
        save = (Button)myActivity.findViewById(R.id.save);
        save.setOnClickListener(new saveButtonListener());
        quit = (Button)myActivity.findViewById(R.id.quit);
        quit.setOnClickListener(new quitButtonListener());
        //surfaceView.setOnTouchListener(this);
    }

    /**
     * returns the GUI's top view
     *
     * @return
     * 		the GUI's top view
     */
    @Override
    public View getTopView() {
        return myActivity.findViewById(R.id.activity_main);
    }

    /**
     * perform any initialization that needs to be done after the player
     * knows what their game-position and opponents' names are.
     */
    protected void initAfterReady() {
        myActivity.setTitle("Tic-Tac-Toe: "+allPlayerNames[0]+" vs. "+allPlayerNames[1]);
    }

    /**
     * callback method when the screen it touched. We're
     * looking for a screen touch (which we'll detect on
     * the "up" movement" onto a tic-tac-tie square
     *
     * @param event
     * 		the motion event that was detected
     */
    public boolean onTouch(View v, MotionEvent event) {
        // ignore if not an "up" event
        if (event.getAction() != MotionEvent.ACTION_UP) return true;
        // get the x and y coordinates of the touch-location;
        // convert them to square coordinates (where both
        // values are in the range 0..2)
        int x = (int) event.getX();
        int y = (int) event.getY();
        //Point p = surfaceView.mapPixelToSquare(x, y);

        // if the location did not map to a legal square, flash
        // the screen; otherwise, create and send an action to
        // the game
        /*if (p == null) {
            //surfaceView.flash(Color.RED, 50);
        } else {
            TTTMoveAction action = new TTTMoveAction(this, p.y, p.x);
            Log.i("onTouch", "Human player sending TTTMA ...");
            game.sendAction(action);
            surfaceView.invalidate();
        }*/

        // register that we have handled the event
        return true;

    }

    private class confirmButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //if confirm button is clicked,
            conf = new ConfirmAction(CCHumanPlayer.this);
            game.sendAction(conf);
        }
    }

    private class cancelButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            canc = new CancelAction(CCHumanPlayer.this);
            game.sendAction(canc);
        }
    }

    private class saveButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            saveAction = new SaveAction(CCHumanPlayer.this);
            game.sendAction(saveAction);
        }
    }

    private class quitButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            /*This quits the entire app, which isn't what we want.  Still including this, may be useful later.*/
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(1);

            /*Return to main menu*/
            quitAction = new QuitAction(CCHumanPlayer.this);//, marble);
            game.sendAction(quitAction);
            layoutId = R.layout.main_menu;
            myActivity.setContentView(layoutId);

        }
    }
}
