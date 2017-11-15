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
    Hashtable<Integer,Color> ColorPlayerTable;

    public CCGameState() {
        super();
    }

    public CCGameState(CCGameState state) {
        super();
    }

    public Marble[][] getBoard(){
        return board;
    }

    public Marble getMarble(int x, int y){
        if(x > board.length){
            if(y > board[0].length){
                return null;
            }
        }
        return board[x][y];
    }

    public int getId(){
        return id;
    }

    public Hashtable<Integer,Color> getCPT(){
        return ColorPlayerTable;
    }

    public void setBoard(Marble[][] b){
        board = b;
    }

    public void setId(int i){
        id = i;
    }

    public void setCPT(Hashtable<Integer,Color> cpt){
        ColorPlayerTable = cpt;
    }

    public int getWhoseMove () {
        return 0;
    }

}