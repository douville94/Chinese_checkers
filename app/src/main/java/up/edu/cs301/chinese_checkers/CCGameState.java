package up.edu.cs301.chinese_checkers;

import android.graphics.Color;

import java.util.Hashtable;

import up.edu.cs301.chinese_checkers.CCMainActivity;
import up.edu.cs301.game.HumanPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by Charlie Wu on 11/5/17.
 */

public class CCGameState extends CCState {

    //instance variables
    Marble[][] board;
    int id;
    Hashtable<Integer,Color> colorPlayerTable;

    /**
     * Constructor
     */
    public CCGameState() {
        super();
    }


    /**
     * Copy Constructor. Copies the values from the parameter state into the new instance.
     */
    public CCGameState(CCGameState state) {
        super();
    }

    public Marble[][] getBoard(){
        return board;
    }

    /**
     * Standard getter method for id. Also used to see whose turn it is.
     * @return returns id which represents whose turn it is.
     */
    public int getId(){
        return id;
    }

    /**
     * Standard getter method for ColorPlayerTable. Used by GUI to properly set the color to a player.
     * @return returns id which represents whose turn it is.
     */
    public Hashtable<Integer,Color> getCPT(){
        return colorPlayerTable;
    }

    /**
     * Standard setter method for instance variable board
     */
    public void setBoard(Marble[][] b){
        board = b;
    }

    /**
     * Standard setter method for instance variable id
     * @param i takes an int. Sets id to i
     */
    public void setId(int i){
        id = i;
    }

    /**
     * Standard setter method for instance variable colorPlayerTable
     * @param cpt takes a Hashtable<Integer,Color>. Sets colorPlayerTable to i
     */
    public void setCPT(Hashtable<Integer,Color> cpt){
        colorPlayerTable = cpt;
    }



    /////////////////////////////////////////////////////////////////////////////
    // LOOK HERE NOT BORING GETTER AND SETTER METHODS
    /////////////////////////////////////////////////////////////////////////////


    /**
     * This will assign an object to certain spot on the board
     * Checks to see if the inputs x and y are within the bounds of the board. Then will assign the
     * b to the position into the array. Can take in null objects into the array.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param b Marble object to put into the board. !!!!!!!!!!!!!!!!!!!!!!!!!!! WILL WE ABLE TO TAKE INT NULL OBJECTS?
     */
    public boolean add2Board(int x, int y, Marble b){
        if(x > board.length){
            if(y > board[0].length){
                return false;
            }
        }
        board[x][y] = b;
        return true;
    }

    /**
     * Returns a marble at a given coordinate on the board
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return returns a Marble object at position x and y
     */
    public Marble getMarble(int x, int y){
        if(x > board.length){
            if(y > board[0].length){
                return null;
            }
        }
        return board[x][y];
    }


    public int getWhoseMove(){
        return 0;
    }


}