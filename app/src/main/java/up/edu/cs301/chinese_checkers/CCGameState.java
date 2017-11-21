package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.CCMainActivity;
import up.edu.cs301.game.CCPlayer;
import up.edu.cs301.game.infoMsg.CCInfo;
import up.edu.cs301.game.infoMsg.CCState;

/**
 * Created by qihangwu on 11/5/17.
 */

public class CCGameState extends CCState {

    /*As per Vegdahl's recommendations on 11/20/2017:
        * Factor playerId (from Marble class) into intArray so that -2 is invalid, -1 is empty,
        * 0 designates player 1, 1 designates player two, and so on.*/
    protected int[][] intArray = new int[][]
    {
        { -2, -2, -2, -2, -2, -2,  -1, -2, -2, -2, -2, -2, -2 }, // row 0

        { -2, -2, -2, -2, -2,  -1,  -1, -2, -2, -2, -2, -2, -2 }, // row 1

        { -2, -2, -2, -2, -2,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 2

        { -2, -2, -2, -2,  -1,  -1,  -1,  -1, -2, -2, -2, -2, -2 }, // row 3

        {  -1, -1, -1, -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }, // row 4

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

    //instance variables
    public CCGameState(CCGameState state) {
        super();
    }

    public CCGameState()
    {
        super();
    }
    public int getWhoseMove () {
        return 0;
    }
}
