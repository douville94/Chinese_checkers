package up.edu.cs301.chinese_checkers;

import up.edu.cs301.game.Player;
import up.edu.cs301.game.actionMsg.GameAction;

/**
 * Created by Luke D. Douville on 10/25/17.
 */

public class MoveAction extends GameAction
{
    //private Player player;
    private int row;
    private int col;

    public MoveAction(Player player)
    {
        super(player);

        // set the row and column as passed to us
        this.row = Math.max(0, Math.min(2, row));
        this.col = Math.max(0, Math.min(2, col));
    }

    /**
     * get the object's row
     *
     * @return the row selected
     */
    public int getRow() {return row;}

    /**
     * get the object's column
     *
     * @return the column selected
     */
    public int getCol() {return col;}

}
