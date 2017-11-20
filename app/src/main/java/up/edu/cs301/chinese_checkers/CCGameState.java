package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.infoMsg.GameState;

/**
 * Created by Charlie Wu on 11/5/17.
 */

public class CCGameState extends GameState
{

    //instance variables
    Marble[][] board;
    int id;
    private IntArray ia;
//    private Hashtable<Integer,Color> colorPlayerTable;
    private int[][] myXYs;
    private int width, height, range;
    /*As per Vegdahl's recommendations on 11/20/2017:
        * Factor playerId (from Marble class) into intArray so that -2 is invalid, -1 is empty,
        * 0 designates player 1, 1 designates player two, and so on.*/
    private int[][] intArray = new int[][]{
    { -2, -2, -2, -2, -2, -2,  -1, -2, -2, -2, -2, -2, -2 }, // row 0

    { -2, -2, -2, -2, -2,  -1,  -1, -2, -2, -2, -2, -2, -2 }, // row 1

    { -2, -2, -2, -2, -2,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 2

    { -2, -2, -2, -2,  -1,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 3

    {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }, // row 4

    {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 5

    { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 6

    { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 7

    { -2, -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 8 -----

    { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2, -2 }, // row 9

    { -2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 1-1

    {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, -2 }, // row 11

    {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }, // row 12

    { -2, -2, -2, -2,  -1,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 13

    { -2, -2, -2, -2, -2,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 14

    { -2, -2, -2, -2, -2,  -1,  -1, -2, -2, -2, -2, -2, -2 }, // row 15

    { -2, -2, -2, -2, -2, -2,  -1, -2, -2, -2, -2, -2, -2 }, // row 16
};

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

//    public Marble[][] getBoard(){
//        return board;
//    }

    public int[][] getBoard()
    {
        return myXYs;
    }

    /**
     * Standard getter method for id. Also used to see whose turn it is.
     * @return returns id which represents whose turn it is.
     */
    public int getId(){
        return id;
    }

//    /**
//     * Standard getter method for ColorPlayerTable. Used by GUI to properly set the color to a player.
//     * @return returns id which represents whose turn it is.
//     */
////    public Hashtable<Integer,Color> getCPT(){
////        return colorPlayerTable;
////    }

    /**
     * Standard setter method for instance variable board
     */
//    public void setBoard(Marble[][] b){
    public void setBoard() {
//        board = b;
//        ia = new IntArray();
//        width = 1536 / 2;
//        height = 1742 / 2;
//        range = 350 / 8;




//        for(int i = 0; i < 13; i++)
//        {
//            for(int j = 0; j < 17; j++)
//            {
//                if(i > 3 && i < 9 && j > 0 && j < 4)
//                {
//                    ia.setTopCorner(board[i][j]);
//                }
//                else if(i > 8 && i < 13 && j > 3 && j < 8)
//                {
//                    ia.setTopRightCorner(board[i][j]);
//                }
//                else if(i > 8 && i < 13 && j > 7 && j < 13)
//                {
//                    ia.setBottomRightCorner(board[i][j]);
//                }
//                else if(i > 3 && i < 9 && j > 12 && j < 17)
//                {
//                    ia.setBottomCorner(board[i][j]);
//                }
//                else if(i > 0 && i < 4 && j > 7 && j < 13)
//                {
//                    ia.setBottomLeftCorner(board[i][j]);
//                }
//                else if(i > 0 && i < 4 && j > 3 && j < 8)
//                {
//                    ia.setTopLeftCorner(board[i][j]);
//                }
//            }
//        }

        for(int i = 0; i < 13; i++)
        {
            for(int j = 0; j < 17; j++)
            {
                /*If configuration is two players*/
                ia.setTopCorner(board[i][j]);
                ia.setBottomCorner(board[i][j]);

                /*If configuration is three players*/
                ia.setTopCorner(board[i][j]);
                ia.setBottomRightCorner(board[i][j]);
                ia.setBottomLeftCorner(board[i][j]);

                /*If configuration is four players*/
                ia.setTopRightCorner(board[i][j]);
                ia.setBottomRightCorner(board[i][j]);
                ia.setBottomLeftCorner(board[i][j]);
                ia.setTopLeftCorner(board[i][j]);

                /*If configuration is six players*/
                ia.setTopCorner(board[i][j]);
                ia.setTopRightCorner(board[i][j]);
                ia.setBottomRightCorner(board[i][j]);
                ia.setBottomCorner(board[i][j]);
                ia.setBottomLeftCorner(board[i][j]);
                ia.setTopLeftCorner(board[i][j]);
            }
        }

    }

    /**
     * Standard setter method for instance variable id
     * @param i takes an int. Sets id to i
     */
    public void setId(int i){
        id = i;
    }

//    /**
//     * Standard setter method for instance variable colorPlayerTable
//     * @param cpt takes a Hashtable<Integer,Color>. Sets colorPlayerTable to i
//     */
//    public void setCPT(Hashtable<Integer,Color> cpt){
//        colorPlayerTable = cpt;
//    }



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
     * @return returns true if added succesfully and false if it did not add the object.
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