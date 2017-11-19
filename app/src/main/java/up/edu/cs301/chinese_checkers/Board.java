package up.edu.cs301.chinese_checkers;

/**
 * Created by sizhecao on 11/18/17.
 */

public class Board {
    //create spaces in the board to hold marbles
    public boolean[][] CCBoard = {
            { false, false, false, false, false, false, true, false, false, false, false, false, false }, // row 0

            { false, false, false, false, false,  true, true, false, false, false, false, false, false }, // row 1

            { false, false, false, false, false,  true, true,  true, false, false, false, false, false }, // row 2

            { false, false, false, false,  true,  true, true,  true, false, false, false, false, false }, // row 3

            {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true }, // row 4

            {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 5

            { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 6

            { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 7

            { false, false,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 8 -----

            { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true, false, false }, // row 7

            { false,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 6

            {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true, false }, // row 5

            {  true,  true,  true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true }, // row 4

            { false, false, false, false,  true,  true, true,  true, false, false, false, false, false }, // row 3

            { false, false, false, false, false,  true, true,  true, false, false, false, false, false }, // row 2

            { false, false, false, false, false,  true, true, false, false, false, false, false, false }, // row 1

            { false, false, false, false, false, false, true, false, false, false, false, false, false }, // row 0
    };

    public Board (){

    }
}
