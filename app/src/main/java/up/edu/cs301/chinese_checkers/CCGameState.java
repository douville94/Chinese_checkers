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
        ia = new IntArray();
        width = 1536 / 2;
        height = 1742 / 2;
        range = 350 / 8;
//        myXYs = new int[13][17];
        //min x coord = width - 300
        //max x coord = width + 600
        //min y coord = (height - 750) + range
        //max y coord = (height + 500) + range
        myXYs = new int[][]
                {
                        //row 1
                        {width - 600, height - 750},
                        {width - 500, height - 750},
                        {width - 400, height - 750},
                        {width - 300, height - 750},
                        {width - 200, height - 750},
                        {width - 100, height - 750},
                        {width, height - 750},
                        {width + 100, height - 750},
                        {width + 200, height - 750},
                        {width + 300, height - 750},
                        {width + 400, height - 750},
                        {width + 500, height - 750},
                        {width + 600, height - 750},

                        //row 2
                        {width - 600, (height - 750) + 3 * range},
                        {width - 500, (height - 750) + 3 * range},
                        {width - 400, (height - 750) + 3 * range},
                        {width - 300, (height - 750) + 3 * range},
                        {width - 200, (height - 750) + 3 * range},
//                        {width-100, (height-750)+3*range},
                        {width - 50, (height - 750) + 3 * range},
                        {width + 50, (height - 750) + 3 * range},
//                        {width+100, (height-750)+3*range},
                        {width + 200, (height - 750) + 3 * range},
                        {width + 300, (height - 750) + 3 * range},
                        {width + 400, (height - 750) + 3 * range},
                        {width + 500, (height - 750) + 3 * range},
                        {width + 600, (height - 750) + 3 * range},

                        //row 3
                        {width - 600, (height - 750) + 5 * range},
                        {width - 500, (height - 750) + 5 * range},
                        {width - 400, (height - 750) + 5 * range},
                        {width - 300, (height - 750) + 5 * range},
                        {width - 200, (height - 750) + 5 * range},
                        {width - 100, (height - 750) + 5 * range},
                        {width, (height - 750) + 5 * range},
                        {width + 100, (height - 750) + 5 * range},
                        {width + 200, (height - 750) + 5 * range},
                        {width + 300, (height - 750) + 5 * range},
                        {width + 400, (height - 750) + 5 * range},
                        {width + 500, (height - 750) + 5 * range},
                        {width + 600, (height - 750) + 5 * range},

                        //row 4
                        {width - 600, (height - 400) - range},
                        {width - 500, (height - 400) - range},
                        {width - 400, (height - 400) - range},
                        {width - 300, (height - 400) - range},
                        {width - 150, (height - 400) - range},
                        {width - 50, (height - 400) - range},
                        {width + 50, (height - 400) - range},
                        {width + 150, (height - 400) - range},
                        {width + 300, (height - 400) - range},
                        {width + 400, (height - 400) - range},
                        {width + 500, (height - 400) - range},
                        {width + 600, (height - 400) - range},

                        //top corner
//                        {width, height - 750},
//                        {width + 50, (height - 750) + 3 * range},
//                        {width - 50, (height - 750) + 3 * range},
//                        {width - 100, (height - 750) + 5 * range},
//                        {width, (height - 750) + 5 * range},
//                        {width + 100, (height - 750) + 5 * range},
//                        {width - 150, (height - 400) - range},
//                        {width - 50, (height - 400) - range},
//                        {width + 50, (height - 400) - range},
//                        {width + 150, (height - 400) - range},

                        //row 5
                        {width - 600, (height - 400) + range},
                        {width - 500, (height - 400) + range},
                        {width - 400, (height - 400) + range},
                        {width - 300, (height - 400) + range},
                        {width - 200, (height - 400) + range},
                        {width - 100, (height - 400) + range},
                        {width, (height - 400) + range},
                        {width + 100, (height - 400) + range},
                        {width + 200, (height - 400) + range},
                        {width + 300, (height - 400) + range},
                        {width + 400, (height - 400) + range},
                        {width + 500, (height - 400) + range},
                        {width + 600, (height - 400) + range},

                        //row 6
                        {width - 600, (height - 325) + range},
                        {width - 550, (height - 325) + range},
                        {width - 450, (height - 325) + range},
                        {width - 350, (height - 325) + range},
                        {width - 200, (height - 325) + range},
                        {width - 100, (height - 325) + range},
                        {width, (height - 325) + range},
                        {width + 100, (height - 325) + range},
                        {width + 200, (height - 325) + range},
                        {width + 350, (height - 325) + range},
                        {width + 450, (height - 325) + range},
                        {width + 550, (height - 325) + range},
                        {width + 600, (height - 325) + range},

                        //row 7
                        {width - 600, (height - 250) + range},
                        {width - 500, (height - 250) + range},
                        {width - 400, (height - 250) + range},
                        {width - 300, (height - 250) + range},
                        {width - 200, (height - 250) + range},
                        {width - 100, (height - 250) + range},
                        {width, (height - 250) + range},
                        {width + 100, (height - 250) + range},
                        {width + 200, (height - 250) + range},
                        {width + 300, (height - 250) + range},
                        {width + 400, (height - 250) + range},
                        {width + 500, (height - 250) + range},
                        {width + 600, (height - 250) + range},

                        //top-left corner
//                        {width-300, (height-400)+range},
//                        {width-400, (height-400)+range},
//                        {width-500, (height-400)+range},
//                        {width-600, (height-400)+range},
//                        {width-350, (height-325)+range},
//                        {width-450, (height-325)+range},
//                        {width-550, (height-325)+range},
//                        {width-400, (height-250)+range},
//                        {width-500, (height-250)+range},
//                        {width-450, (height-175)+range},

                        //top-right corner
//                        {width+300, (height-400)+range},
//                        {width+400, (height-400)+range},
//                        {width+500, (height-400)+range},
//                        {width+600, (height-400)+range},
//                        {width+350, (height-325)+range},
//                        {width+450, (height-325)+range},
//                        {width+550, (height-325)+range},
//                        {width+400, (height-250)+range},
//                        {width+500, (height-250)+range},
//                        {width+450, (height-175)+range},

                        //row 8
                        {width - 600, (height + 200) + range},
                        {width - 500, (height + 200) + range},
                        {width - 400, (height + 200) + range},
                        {width - 300, (height + 200) + range},
                        {width - 200, (height + 200) + range},
                        {width - 100, (height + 200) + range},
                        {width, (height + 200) + range},
                        {width + 100, (height + 200) + range},
                        {width + 200, (height + 200) + range},
                        {width + 300, (height + 200) + range},
                        {width + 400, (height + 200) + range},
                        {width + 500, (height + 200) + range},
                        {width + 600, (height + 200) + range},

                        //row 9
                        {width - 600, (height + 125) + range},
                        {width - 550, (height + 125) + range},
                        {width - 450, (height + 125) + range},
                        {width - 350, (height + 125) + range},
                        {width - 200, (height + 125) + range},
                        {width - 100, (height + 125) + range},
                        {width, (height + 125) + range},
                        {width + 100, (height + 125) + range},
                        {width + 200, (height + 125) + range},
                        {width + 350, (height + 125) + range},
                        {width + 450, (height + 125) + range},
                        {width + 550, (height + 125) + range},
                        {width + 600, (height + 125) + range},

                        //row 10
                        {width - 600, (height - 50) + range},
                        {width - 500, (height - 50) + range},
                        {width - 400, (height - 50) + range},
                        {width - 300, (height - 50) + range},
                        {width - 200, (height - 50) + range},
                        {width - 100, (height - 50) + range},
                        {width, (height - 50) + range},
                        {width + 100, (height - 50) + range},
                        {width + 200, (height - 50) + range},
                        {width + 300, (height - 50) + range},
                        {width + 400, (height - 50) + range},
                        {width + 500, (height - 50) + range},
                        {width + 600, (height - 50) + range},

                        //row 11
                        {width - 600, (height - 20) + range},
                        {width - 500, (height - 20) + range},
                        {width - 450, (height - 20) + range},
                        {width - 300, (height - 20) + range},
                        {width - 200, (height - 20) + range},
                        {width - 100, (height - 20) + range},
                        {width, (height - 20) + range},
                        {width + 100, (height - 20) + range},
                        {width + 200, (height - 20) + range},
                        {width + 300, (height - 20) + range},
                        {width + 450, (height - 20) + range},
                        {width + 500, (height - 20) + range},
                        {width + 600, (height - 20) + range},

                        //bottom-left corner
//                        {width-450, (height-20)+range},
//                        {width-500, (height+50)+range},
//                        {width-400, (height+50)+range},
//                        {width-550, (height+125)+range},
//                        {width-450, (height+125)+range},
//                        {width-350, (height+125)+range},
//                        {width-300, (height+200)+range},
//                        {width-400, (height+200)+range},
//                        {width-500, (height+200)+range},
//                        {width-600, (height+200)+range},

                        //bottom-right corner
//                        {width+450, (height-25)+range},
//                        {width+400, (height+50)+range},
//                        {width+500, (height+50)+range},
//                        {width+350, (height+125)+range},
//                        {width+450, (height+125)+range},
//                        {width+550, (height+125)+range},
//                        {width+300, (height+200)+range},
//                        {width+400, (height+200)+range},
//                        {width+500, (height+200)+range},
//                        {width+600, (height+200)+range},

                        //row 12
                        {width - 600, (height + 275) + range},
                        {width - 500, (height + 275) + range},
                        {width - 400, (height + 275) + range},
                        {width - 300, (height + 275) + range},
                        {width - 200, (height + 275) + range},
                        {width - 150, (height + 275) + range},
                        {width - 50, (height + 275) + range},
                        {width + 50, (height + 275) + range},
                        {width + 150, (height + 275) + range},
                        {width + 200, (height + 275) + range},
                        {width + 300, (height + 275) + range},
                        {width + 400, (height + 275) + range},
                        {width + 500, (height + 275) + range},
                        {width + 600, (height + 275) + range},

                        //row 13
                        {width - 600, (height + 350) + range},
                        {width - 500, (height + 350) + range},
                        {width - 400, (height + 350) + range},
                        {width - 300, (height + 350) + range},
                        {width - 200, (height + 350) + range},
                        {width - 100, (height + 350) + range},
                        {width, (height + 350) + range},
                        {width + 100, (height + 350) + range},
                        {width + 200, (height + 350) + range},
                        {width + 300, (height + 350) + range},
                        {width + 400, (height + 350) + range},
                        {width + 500, (height + 350) + range},
                        {width + 600, (height + 350) + range},

                        //row 14
                        {width - 600, (height + 500) + range},
                        {width - 500, (height + 500) + range},
                        {width - 300, (height + 500) + range},
                        {width - 200, (height + 500) + range},
                        {width-50, (height+500)+range},
                        {width, (height+500)+range},
                        {width+50, (height+500)+range},
                        {width+200, (height+500)+range},
                        {width+300, (height+500)+range},
                        {width+400, (height+500)+range},
                        {width+500, (height+500)+range},
                        {width+600, (height+500)+range},

                        //bottom corner
//                        {width, (height+500)+range},
//                        {width+50, (height+425)+range},
//                        {width-50, (height+425)+range},
//                        {width-100, (height+350)+range},
//                        {width, (height+350)+range},
//                        {width-100, (height+350)+range},
//                        {width-150, (height+275)+range},
//                        {width-50, (height+275)+range},
//                        {width+50, (height+275)+range},
//                        {width+150, (height+275)+range},




                };


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