package edu.up.cs301.chinese_checkers;

import android.content.Context;
import android.util.Log;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import static java.lang.Math.abs;

/**
 * Created by Charlie Wu on 10/30/17.
 */

public class CCLocalGame extends LocalGame {

    // the game's state
    protected CCGameState cgs;
    // the human gamePlayer
    private CCHumanPlayer chp;
    private GameMainActivity gma;
    private int playerInt;

    /**
     * Constructor for the LocalGame.
     */
    public CCLocalGame() {//int p) {
        super();// perform superclass initialization
        cgs = new CCGameState();// create a new, unfilled-in CCGameState object
    }

    /**
     *a start method
     *
     * @param players
     */
    public void start(GamePlayer[] players) {
        cgs.initialIntArray(players.length);
        super.start(players);
    }

    /**
     * Notify the given gamePlayer that its state has changed. This should involve sending
     * a GameInfo object to the gamePlayer. If the game is not a perfect-information game
     * this method should remove any information from the game that the gamePlayer is not
     * allowed to know.
     *
     * @param p
     * 			the gamePlayer to notify
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        // make a copy of the state, and send it to the gamePlayer
        p.sendInfo(new CCGameState(cgs));
    }

    /**
     * Tell whether the given gamePlayer is allowed to make a move at the
     * present point in the game.
     *
     * @param playerID
     * 		the gamePlayer's gamePlayer-number (ID)
     * @return
     * 		true iff the gamePlayer is allowed to move
     */
    @Override
    protected boolean canMove(int playerID) { return playerID == cgs.getWhoseMove(); }

    /**
     * Check if the game is over. It is over, return a string that tells
     * who the winner(s), if any, are. If the game is not over, return null;
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //capture initial configured intArray positions
        //compare with the current ones in the opposite corner of the board
        //current array of integers is cgs.intArray
        //initial array of integers is in the player classes

//        int[][] initCfgIntArray = ;
        int[][] currentIntArray = cgs.intArray;
        boolean m = false, q = true;
        boolean[][] boolArray0 = new boolean[17][13];
        boolean[][] boolArray1 = new boolean[17][13];
        boolean[][] boolArray2 = new boolean[17][13];
        boolean[][] boolArray3 = new boolean[17][13];
        boolean[][] boolArray4 = new boolean[17][13];
        boolean[][] boolArray5 = new boolean[17][13];

        switch(gma.playerCount)
        {
            /*Search top (player 1) and bottom (player 0) triangles on the board.*/
            case 2:
                switch(cgs.getId())
                {
                    case 0:
                        /*Check top corner.*/
                        for(int i = 0; i < 4; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 0 || currentIntArray[i][j] == -2)
                                {
                                    boolArray0[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 0; k < 4; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray0[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray0[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    case 1:
                        /*Check bottom corner*/
                        for(int i = 13; i < 17; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 1 || currentIntArray[i][j] == -2)
                                {
                                    boolArray1[i][j] = true;
                                }
                            }
                        }
                        for(int k = 0; k < 4; k++)
                        {
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray1[k][l])
                                {
                                    m = false;
                                    Log.i("checkIfGameOver()", "Game is not over.");
                                    return null;
                                }
                                else if(boolArray1[k][l])
                                {
                                    m = true;
                                }

                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                }
                /*Search bottom left, bottom right, and top triangles on the board.*/
            case 3:
                switch(cgs.getId())
                {
                    /*Check top corner.*/
                    case 0:
                        for(int i = 0; i < 4; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 0 || currentIntArray[i][j] == -2)
                                {
                                    boolArray0[i][j] = true;
                                }
                                else if(currentIntArray[i][j] != 0)
                                {
                                    boolArray0[i][j] = false;
                                }
                            }
                        }
                        q = true;
                        for(int k = 0; k < 4; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray0[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray0[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check bottom-left corner.*/
                    case 1:
                        for(int i = 9; i < 13; i++)
                        {
                            for(int j = 0; j < 4; j++)
                            {
                                /*Ignore currentIntArray[9][2], currentIntArray[9][3], currentIntArray[10][3],
                                * currentIntArray[11][3]*/
                                if(currentIntArray[i][j] == 1 || currentIntArray[i][j] == -2 ||
                                        (i == 9 && j == 2) || (i == 9 && j == 3) || (i == 10 && j == 3) ||
                                        (i == 11 && j == 3))
                                {
                                    boolArray1[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 9; k < 13; k++)
                        {
                            if(!q) break;
                            for(int l = 0; l < 4; l++)
                            {
                                if(!boolArray1[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray1[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check bottom-right corner.*/
                    case 2:
                        for(int i = 9; i < 13; i++)
                        {
                            for(int j = 9; j < 13; j++)
                            {
                                /*Ignore currentIntArray[9][9] and currentIntArray[10][9]*/
                                if(currentIntArray[i][j] == 2 || currentIntArray[i][j] == -2 || (i == 9 && j == 9) ||
                                        (i == 10 && j == 9))
                                {
                                    boolArray2[i][j] = true;
                                }
                            }
                        }
                        for(int k = 9; k < 13; k++)
                        {
                            for(int l = 9; l < 13; l++)
                            {
                                if(!boolArray2[k][l])
                                {
                                    m = false;
                                    Log.i("checkIfGameOver()", "Game is not over.");
                                    return null;
                                }
                                else if(boolArray2[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                }
            /*Search bottom, bottom-right, top, and top-left corners.*/
            case 4:
                switch(cgs.getId())
                {
                    /*Search top triangle.*/
                    case 0:
                        for(int i = 0; i < 4; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 0 || currentIntArray[i][j] == -2)
                                {
                                    boolArray0[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 0; k < 4; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray0[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray0[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Search top-left corner.*/
                    case 1:
                        for(int i = 4; i < 8; i++)
                        {
                            for(int j = 0; j < 4; j++)
                            {
                                /*Ignore currentIntArray[5][3], currentIntArray[6][3], currentIntArray[7][3],
                                * currentIntArray[7][2]*/
                                if(currentIntArray[i][j] == 1 || currentIntArray[i][j] == -2 || (i == 5 && j == 3) ||
                                        (i == 6 && j == 3) || (i == 7 && j == 3) || (i == 7 && j == 2))
                                {
                                    boolArray1[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 4; k < 8; k++)
                        {
                            if(!q) break;
                            for(int l = 0; l < 4; l++)
                            {
                                if(!boolArray1[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray1[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check bottom corner.*/
                    case 2:
                        for(int i = 13; i < 17; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 2 || currentIntArray[i][j] == -2)
                                {
                                    boolArray2[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 13; k < 17; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray2[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray2[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                        /*Check the bottom-right corner.*/
                    case 3:
                        for(int i = 9; i < 13; i++)
                        {
                            for(int j = 9; j < 13; j++)
                            {
                                /*Ignore currentIntArray[9][9] and currentIntArray[10][9]*/
                                if(currentIntArray[i][j] == 1 || currentIntArray[i][j] == -2 || (i == 9 && j == 9) ||
                                        (i == 10 && j == 9))
                                {
                                    boolArray1[i][j] = true;
                                }
                            }
                        }
                        for(int k = 9; k < 13; k++)
                        {
                            for(int l = 9; l < 13; l++)
                            {
                                if(!boolArray1[k][l])
                                {
                                    m = false;
                                    Log.i("checkIfGameOver()", "Game is not over.");
                                    return null;
                                }
                                else if(boolArray1[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                }
                /*Five-player games are not allowed!*/
                /*Check all six corners of the board.*/
            case 6:
                switch(cgs.getId())
                {
                    /*Check the top corner.*/
                    case 0:
                        for(int i = 0; i < 4; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 0 || currentIntArray[i][j] == -2)
                                {
                                    boolArray0[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 0; k < 4; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray0[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray0[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check the top-right corner.*/
                    case 1:
                        for(int i = 4; i < 8; i++)
                        {
                            for(int j = 9; j < 13; j++)
                            {
                                /*Ignore currentIntArray[6][9] and currentIntArray[7][9]*/
                                if(currentIntArray[i][j] == 5 || currentIntArray[i][j] == -2 || (i == 6 && j == 9) ||
                                        (i == 7 && j == 9))
                                {
                                    boolArray1[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 4; k < 8; k++)
                        {
                            if(!q) break;
                            for(int l = 9; l < 13; l++)
                            {
                                if(!boolArray1[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray1[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check the bottom-right corner.*/
                    case 2:
                        for(int i = 9; i < 13; i++)
                        {
                            for(int j = 9; j < 13; j++)
                            {
                                /*Ignore currentIntArray[9][8] and currentIntArray[10][8]*/
                                if(currentIntArray[i][j] == 2 || currentIntArray[i][j] == -2 || (i == 9 && j == 8) ||
                                        (i == 10 && j == 8))
                                {
                                    boolArray2[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 9; k < 13; k++)
                        {
                            if(!q) break;
                            for(int l = 9; l < 13; l++)
                            {
                                if(!boolArray2[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray2[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check the bottom corner.*/
                    case 3:
                        for(int i = 13; i < 17; i++)
                        {
                            for(int j = 4; j < 8; j++)
                            {
                                if(currentIntArray[i][j] == 3 || currentIntArray[i][j] == -2)
                                {
                                    boolArray3[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 13; k < 17; k++)
                        {
                            if(!q) break;
                            for(int l = 4; l < 8; l++)
                            {
                                if(!boolArray3[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray3[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check the bottom-left corner.*/
                    case 4:
                        for(int i = 9; i < 13; i++)
                        {
                            for(int j = 0; j < 4; j++)
                            {
                                /*Ignore currentIntArray[9][2], currentIntArray[9][3], currentIntArray[10][3],
                                * currentIntArray[11][3]*/
                                if(currentIntArray[i][j] == 4 || currentIntArray[i][j] == -2 || (i == 9 && j == 2) ||
                                        (i == 9 && j == 3) || (i == 10 && j == 3) || (i == 11 && j == 3))
                                {
                                    boolArray4[i][j] = true;
                                }
                            }
                        }
                        q = true;
                        for(int k = 9; k < 13; k++)
                        {
                            if(!q) break;
                            for(int l = 0; l < 4; l++)
                            {
                                if(!boolArray4[k][l])
                                {
                                    m = false;
                                    q = false;
                                    break;
                                }
                                else if(boolArray4[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                    /*Check the top-left corner.*/
                    case 5:
                        for(int i = 4; i < 8; i++)
                        {
                            for(int j = 0; j < 4; j++)
                            {
                                /*Ignore currentIntArray[5][3], currentIntArray[6][3], currentIntArray[7][3],
                                * currentIntArray[7][2]*/
                                if(currentIntArray[i][j] == 1 || currentIntArray[i][j] == -2 || (i == 5 && j == 3) ||
                                        (i == 6 && j == 3) || (i == 7 && j == 3) || (i == 7 && j == 2))
                                {
                                    boolArray5[i][j] = true;
                                }
                            }
                        }
                        for(int k = 4; k < 8; k++)
                        {
                            for(int l = 0; l < 4; l++)
                            {
                                if(!boolArray5[k][l])
                                {
                                    m = false;
                                    Log.i("checkIfGameOver()", "Game is not over.");
                                    return null;
                                }
                                else if(boolArray5[k][l])
                                {
                                    m = true;
                                }
                            }
                        }
                        if(m)
                        {
                            Log.i("checkIfGameOver()", "Game is over.");
                            return "Game is over.";
                        }
                }
        }
        return null;
    }

    /**
     * Makes a move on behalf of a gamePlayer.
     *
     * @param action
     * 			The move that the gamePlayer has sent to the game
     * @return
     * 			Tells whether the move was a legal one.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        /*get all the information that we need to move a marble*/
        MoveAction CCMoveAction = (MoveAction) action;
        /*returns an int for the x coordinate in the intArray closest to the touched location
          on the SurfaceView*/
        int startRow = CCMoveAction.getStartRow();
        /*returns an int for the y coordinate in the intArray closest to the touched location
          on the SurfaceView*/
        int startCol = CCMoveAction.getStartCol();
        /*Grab value (corresponding in intArray) of tapped marble from the game state,
          not the move action.*/
        int startValue = CCMoveAction.getTouchedInt();
        /*returns an int for the x coordinate in the intArray closest to the location
          where the Player "dropped" the marble*/
        int endRow = CCMoveAction.getEndRow();
        /*returns an int for the y coordinate in the intArray closest to the location
          where the Player "dropped" the marble*/
        int endCol = CCMoveAction.getEndCol();
        int changedValue = CCMoveAction.getChangedInt();
        /*get playerId*/
        int playerId = getPlayerIdx(CCMoveAction.getPlayer());
        /*get the difference between start row and end row, start column and end column*/
//        int differentRow = endRow-startRow;
//        int differentCol = endCol-startCol;

        /*Check if value of the tapped marble is the same as the playerId of whose move it is*/
        if (startValue != cgs.getWhoseMove()) { return false; }

        /*Check if ending position is empty and not invalid.*/
        if (cgs.intArray[endRow][endCol] != -1) { return false; }


        /*Check that the initial tapped piece belongs to the player whose turn it is*/
        if(startValue != playerId)
        {
            return false;
        }

        /*Execute the move*/
        cgs.swapIntArray(startRow, startCol, startValue, endRow, endCol, changedValue);

        /*Set the turn to the next player.*/
        cgs.setWhoseMove(playerId + 1);

        /*if the game gets to the last round for 1 turn switch back to the first player.*/
        if (cgs.getWhoseMove() == players.length) { cgs.setWhoseMove(0); }

        return true;
    }
}
