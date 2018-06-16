package edu.up.cs301.chinese_checkers;

import android.util.Log;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.infoMsg.GameState;

/**
 *
 * Contains the state of a Chinese Checker game.  Sent by the game when
 * a player wants to enquire about the state of the game.  (E.g., to display
 * it, or to help figure out its next move.)
 *
 *
 * Created by Charlie Wu on 11/5/17.
 */

public class CCGameState extends GameState {

    //instance variables
    private int playerID;
    int[][] intArray;
    int[][] xPositions;
    int[][] yPositions;


    /**
     * Constructor
     */
    CCGameState()
    {
        super();
        this.setIntArray();
        xPositions = new int[17][13];
        yPositions = new int[17][13];
        this.initXYPos();
        playerID = 0;
    }

    /**
     * Copy constructor for class TTTState
     *
     * @param state
     * 		the CCGameState object that we want to clone
     */
    CCGameState(CCGameState state) {
        super();
        this.intArray = new int[17][13];
        for(int i = 0; i<17; i++){
            for(int j = 0; j<13; j++) {
                this.intArray[i][j] = state.intArray[i][j];
            }
        }
        xPositions = state.xPositions;
        yPositions = state.yPositions;
        this.playerID = state.playerID;
    }

    /**
     * Standard getter method for id. Also used to see whose turn it is.
     *
     * @return returns id which represents whose turn it is.
     */
    public int getId() {
        return playerID;
    }
    

    /**
     * Standard getter method for instance variable intArray
     *
     * @return intArray
     */
    int[][] getIntArray() {
        return intArray;
    }

    /**
     * Standard setter method for instance variable intArray
     */
    private void setIntArray() {
        intArray = new int[][]{
                {-2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2}, // row 0

                {-2, -2, -2, -2, -2, -1, -1, -2, -2, -2, -2, -2, -2}, // row 1

                {-2, -2, -2, -2, -2, -1, -1, -1, -2, -2, -2, -2, -2}, // row 2

                {-2, -2, -2, -2, -1, -1, -1, -1, -2, -2, -2, -2, -2}, // row 3

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // row 4

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 5

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 6

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 7

                {-2, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 8 -----

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}, // row 9

                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 10

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, // row 11

                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // row 12

                {-2, -2, -2, -2, -1, -1, -1, -1, -2, -2, -2, -2, -2}, // row 13

                {-2, -2, -2, -2, -2, -1, -1, -1, -2, -2, -2, -2, -2}, // row 14

                {-2, -2, -2, -2, -2, -1, -1, -2, -2, -2, -2, -2, -2}, // row 15

                {-2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2}, // row 16
        };
    }

    /**
     * Standard setter method for instance variable id
     *
     * @param i takes an int. Sets id to i
     */
    public void setId(int i){
        playerID = i;
    }

    /////////////////////////////////////////////////////////////////////////////
    // LOOK HERE NOT BORING GETTER AND SETTER METHODS
    /////////////////////////////////////////////////////////////////////////////


    /**
     * method to get whose turn is this turn.
     *
     * @return the gamePlayer ID that is moving this turn.
     */
    int getWhoseMove(){
        return getId();
    }


    /**
     * method to initialize the IntArray according to the configuration that user inputted.
     * its hard coded and ugly but it works.
     *
     * @param numberOfPlayers how many people are playing in this game.
     */
    public void initialIntArray(int numberOfPlayers) {
        int playerConfig = numberOfPlayers;
        //2 gamePlayers' case

        if (playerConfig == 2) {
            //init player 1 (top corner)
            for (int i=0; i<4; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 1;
                    }
                }
            }
            //init player 0 (bottom corner)
            for (int i=13; i<17; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 0;
                    }
                }
            }
        }
        //3 gamePlayers' case
        if (playerConfig == 3) {

            //init player 0 (bottom corner)
            for (int i=13; i<17; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 0;
                    }
                }
            }

            //init player 1 (top left corner)
            for (int i=4; i<7; i++) {
                for (int j=0; j<3; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 1;
                    }
                }
            }
            intArray[4][3] = 1;
            intArray[7][1] = 1;

            //init player 2 (top right corner)
            for (int i=4; i<8; i++) {
                for (int j=10; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 2;
                    }
                }
            }
            intArray[4][9] = 2;
            intArray[5][9] = 2;
        }

        //4 player
        if(playerConfig == 4){
            //init player 2 (top corner)
            for (int i=0; i<4; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 2;
                    }
                }
            }

            //init player 3 (top right corner)
            for (int i=4; i<8; i++) {
                for(int j = 9; j < 13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 3;
                    }
                }
            }

            intArray[6][9] = -1;
            intArray[7][9] = -1;

            //init player 0 (bottom corner)
            for (int i=13; i<17; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 0;
                    }
                }
            }

            //init player 1 (bottom left corner)
            for (int i=9; i<13; i++) {
                for(int j = 0; j < 4; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 1;
                    }
                }
            }
            intArray[9][2] = -1;
            intArray[9][3] = -1;
            intArray[10][3] = -1;
            intArray[11][3] = -1;

        }

        //6 player config
        if(playerConfig == 6){
            //init player 0 (bottom corner)
            for (int i=13; i<17; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 0;
                    }
                }
            }

            //init player 1 (bottom left corner)
            for (int i=10; i<13; i++) {
                for (int j=0; j<3; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 1;
                    }
                }
            }
            intArray[9][1] = 1;
            intArray[12][3] = 1;

            //init player 2 (top left corner)
            for (int i=4; i<7; i++) {
                for (int j=0; j<3; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 2;
                    }
                }
            }
            intArray[4][3] = 2;
            intArray[7][1] = 2;


            //init player 3 (top corner)
            for (int i=0; i<4; i++) {
                for (int j=0; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 3;
                    }
                }
            }

            //init player 4 (top right corner)
            for (int i=4; i<8; i++) {
                for (int j=10; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 4;
                    }
                }
            }
            intArray[4][9] = 4;
            intArray[5][9] = 4;


            //init player 5 (bottom right corner)
            for (int i=9; i<13; i++) {
                for (int j=10; j<13; j++) {
                    if (intArray[i][j] != -2) {
                        intArray[i][j] = 5;
                    }
                }
            }
            intArray[11][9] = 5;
            intArray[12][9] = 5;
        }
    }

    /**
     * Helper method to initialize instance variables @xPositions and @yPositions
     * Requires that instance variable @intArray is initialized to default value first.
     * MUST BE CALLED BEFORE initialArray IN ORDER TO WORK PROPERLY
     */
    /*Move xPositions and yPositions to CCHumanPlayer or BoardSurfaceView?*/
    private void initXYPos() {
        int x;
        int y = 40;
        boolean offset = false;

        for(int i = 0; i < 17; i++) {
            //iterate each row
            y+=100;
            if(offset){
                x = 250;
            }
            else{
                x = 200;
            }
            // iterate each column
            for(int j = 0; j < 13; j++) {
                int z = intArray[i][j];
                switch (z){
                    case -2:// Set the position to be 0
                        xPositions[i][j] = 0;
                        yPositions[i][j] = 0;
                        break;
                    case -1: //empty
                        xPositions[i][j] = x;
                        yPositions[i][j] = y;
                        break;
                    default:
                        break;
                }
                x+=95;
                y-=1;
            }
            offset = !offset;
        }

    }


    /**
     * Swap the intArray value after a move is made.
     *
     * @param startX
     * @param startY
     * @param touched
     * @param endX
     * @param endY
     * @param changed
     */
    void swapIntArray(int startX, int startY, int touched, int endX, int endY, int changed){
        intArray[startX][startY] = changed;
        intArray[endX][endY] = touched;
    }

    /**
     * setter method for playerID
     * @param playerId
     */
    public void setWhoseMove(int playerId) { playerID = playerId; }
}