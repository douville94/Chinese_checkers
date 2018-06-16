package edu.up.cs301.chinese_checkers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.IllegalMoveInfo;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;

import static java.lang.Math.abs;

/**
 * A GUI that allows a human to play Chinese Checker. Moves are made by clicking
 * regions on a canvas
 *
 *
 * Created by sizhecao on 11/12/17.
 */

public class CCHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {

    // the current activity
    private Activity myActivity;
    private BoardSurfaceView bsf;
    private int tempStartRow=-1,tempStartCol=-1,tempStartValue=-2,
            actualStartRow=-1, actualStartCol=-1, actualStartValue=-2,
            finalEndRow=-1,finalEndCol=-1,finalEndValue=-2;
    private Button confirm;
    private CCGameState cgs, savedState;
    MoveAction moveAction;
    private boolean firstTouched = false, indicate = false, oneLegalMoveDone = false;
    private CCLocalGame clg;
    private GameMainActivity gma;

    /**
     * constructor
     *
     * @param name
     * 		the gamePlayer's name
     */

    public CCHumanPlayer(String name) {
        super(name);
        cgs = new CCGameState();
        savedState = new CCGameState();
    }

    /**
     * Callback method, called when gamePlayer gets a message
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

        if (bsf == null) return;

        /*If legal move, do savedState = new CCGameState(cgs)*/
        /*If an illegal move, do cgs = new CCGameState(savedState)*/
        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            /*savedState is the previous state of the game*/
            /*cgs is the current state of the game*/
            cgs = new CCGameState(savedState);//make a copy of the saved CCGameState (which is the CCGameState object savedState).  DO NOT WRITE cgs = savedState
            // if the move was out of turn or otherwise illegal, flash the screen
            bsf.flash(Color.RED, 500);
        } else if (!(info instanceof CCGameState)) return;
        else {
            bsf.setState((CCGameState)info);
//            savedState = new CCGameState((CCGameState)info);
            cgs = (CCGameState)info;
            bsf.invalidate();
            Log.i("human player", "receiving");
        }
    }

    /**
     * sets the current gamePlayer as the activity's GUI
     */
    public void setAsGui(GameMainActivity activity) {

        // remember our activity
        myActivity = activity;

        // Load the layout resource for the new configuration
        activity.setContentView(R.layout.activity_main);

        // set the surfaceView instance variable
//        turnTextView = (TextView)myActivity.findViewById(R.id.turnTextView);
//        currentPlayerTextView = (TextView)myActivity.findViewById(R.id.currentPlayerTextView);
        bsf = (BoardSurfaceView)myActivity.findViewById(R.id.boardSurfaceView);
        Log.i("set listener","OnTouch");
        bsf.setOnTouchListener(this);
        confirm = (Button)myActivity.findViewById(R.id.confirm);
        confirm.setOnClickListener(new confirmButtonListener());
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
     * perform any initialization that needs to be done after the gamePlayer
     * knows what their game-position and opponents' names are.
     *
     */
    protected void initAfterReady() {
        myActivity.setTitle("Chinese Checkers");
    }

    /**
     * callback method when the screen is touched. We're
     * look1ing for a screen touch on Chinese Checker piece.
     *
     * @param event
     * 		the motion event that was detected
     */
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getActionMasked();


        int endRow, endCol, endValue;

        // ignore if not an "up" event
        if (event.getAction() != MotionEvent.ACTION_UP) return true;
        Log.i("Action Up: ","Made");

        // get the x and y coordinates of the touch-location;
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (!firstTouched) {
            if (bsf.mapPixelToMarble(x,y)!= playerNum) {
//                game.sendAction(new MoveAction(CCHumanPlayer.this, actualStartRow, actualStartCol,
//                        actualStartValue, finalEndRow, finalEndCol, finalEndValue));
                bsf.flash(Color.RED,500);
                tempStartRow = -1; tempStartCol=-1; tempStartValue=-2;
                finalEndRow=-1; finalEndCol=-1; finalEndValue=-2;
                actualStartValue=-2; actualStartRow=-1; actualStartCol=-1;
                firstTouched = false;
                oneLegalMoveDone = false;
                return true;
            } else {
                tempStartValue = bsf.mapPixelToMarble(x, y);
                actualStartValue = bsf.mapPixelToMarble(x, y);
                tempStartCol = bsf.mapPixelToColPosition(x, y);
                actualStartCol = bsf.mapPixelToColPosition(x, y);
                tempStartRow = bsf.mapPixelToRowPosition(x, y);
                actualStartRow = bsf.mapPixelToRowPosition(x, y);
                indicate = true;
            }
        }

        if (firstTouched) {
            endValue = bsf.mapPixelToMarble(x, y);
            endCol = bsf.mapPixelToColPosition(x, y);
            endRow = bsf.mapPixelToRowPosition(x, y);
            if (endValue != -1) {
//                game.sendAction(new MoveAction(CCHumanPlayer.this, actualStartRow, actualStartCol,
//                        actualStartValue, 0,0 , -2));
                bsf.flash(Color.RED,500);
//                tempStartRow = -1; tempStartCol=-1; tempStartValue=-2;
//                finalEndRow=-1; finalEndCol=-1; finalEndValue=-2;
//                actualStartValue=-2; actualStartRow=-1; actualStartCol=-1;
                firstTouched = false;
                oneLegalMoveDone = false;
                return true;
            } /*else {
                finalEndRow = endRow;
                finalEndCol = endCol;
                finalEndValue = endValue;
            }*/
            int differentRow = endRow-tempStartRow;
            int differentCol = endCol-tempStartCol;
            /*check if it is a legal move*/
            if (tempStartRow%2==0) { //if the picked marble is in the even row
                //if the row or col difference between the picked marble and currently
                // testing empty slot is bigger then 1 or less then -1, which means
                // the current empty
                //slot is not at the surrounding of the picked marble.
                if (differentRow>1 || differentRow<-1 || differentCol>1 ||
                        differentCol<-1) {
                    if (differentCol>0) {
                        if (differentRow<0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow>0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow==0) {
                            if (cgs.getIntArray()[tempStartRow]
                                    [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }
                    } else if (differentCol<0) {
                        if (differentRow<0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+differentCol]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow>0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+differentCol]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow==0) {
                            if (cgs.getIntArray()[tempStartRow]
                                    [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }
                    }
                } else if (differentRow==-1&&differentCol==-1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==1&&differentCol==-1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==0&&differentCol==1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==0&&differentCol==-1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==1&&differentCol==0&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==-1&&differentCol==0&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                }
            } else {//if the picked marble is in the odd row
                //if the distance between the picked marble and the current testing empty
                //slot is greater than 1.
                if (differentRow>1 || differentRow<-1 || differentCol>1 ||
                        differentCol<-1) {
                    if (differentCol>0) {
                        if (differentRow<0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow + (differentRow/2)]
                                            [tempStartCol + differentCol]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow>0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+differentCol]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow==0) {
                            if (cgs.getIntArray()[tempStartRow]
                                    [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }
                    } else if (differentCol<0) {
                        if (differentRow<0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow>0) {
                            if (abs(differentRow)==(abs(differentCol)*2)&&
                                    cgs.getIntArray()[tempStartRow+(differentRow/2)]
                                            [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }else if (differentRow==0) {
                            if (cgs.getIntArray()[tempStartRow]
                                    [tempStartCol+(differentCol/2)]>=0) {
                                bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                                        endRow,endCol,endValue);
                                oneLegalMoveDone = true;
                                tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                                finalEndCol = endCol;finalEndValue = endValue;
                            }
                        }
                    }
                } else if (differentRow==1&&differentCol==1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==-1&&differentCol==1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==0&&differentCol==1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==0&&differentCol==-1&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==1&&differentCol==0&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                } else if (differentRow==-1&&differentCol==0&&!oneLegalMoveDone) {
                    bsf.redrawWithoutUpdatingState(tempStartRow, tempStartCol,tempStartValue,
                            endRow,endCol,endValue);
                    oneLegalMoveDone = true;
                    tempStartCol = endCol; tempStartRow = endRow;finalEndRow = endRow;
                    finalEndCol = endCol;finalEndValue = endValue;
                }
            }
        }

        if (indicate) {
            firstTouched = true;
        }

        bsf.invalidate();

        //register that we have handled the event
        return true;
    }


    public class confirmButtonListener implements View.OnClickListener {
        /**
         * ends human player's turn when clicks the confirm button and send the action to the game state.
         * @param v
         */
        public void onClick(View v) {
//            moveAction = new MoveAction(CCHumanPlayer.this, actualStartRow, actualStartCol,
//                    actualStartValue, finalEndRow, finalEndCol, finalEndValue);
            if (tempStartRow!=-1&&tempStartCol!=-1&&tempStartValue!=-2&&
            finalEndRow!=-1&&finalEndCol!=-1&&finalEndValue!=-2&&actualStartRow!=-1&&
                    actualStartCol!=-1&&actualStartValue!=-2) { game.sendAction(new MoveAction(
                            CCHumanPlayer.this, actualStartRow, actualStartCol,
                    actualStartValue, finalEndRow, finalEndCol, finalEndValue)); }
            tempStartRow = -1; tempStartCol=-1; tempStartValue=-2;
            finalEndRow=-1; finalEndCol=-1; finalEndValue=-2;
            actualStartValue=-2; actualStartRow=-1; actualStartCol=-1;
            firstTouched = false;
            oneLegalMoveDone = false;
        }
    }
}
