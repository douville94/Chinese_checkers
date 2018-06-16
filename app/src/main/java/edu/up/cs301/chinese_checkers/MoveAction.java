package edu.up.cs301.chinese_checkers;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * A move action that a chinese checker player sends his move to the game.
 *
 * @author Luke D.
 */

public class MoveAction extends GameAction
{
    private int startCol;
    private int startRow;
    private int touchedInt;
    private int endCol;
    private int endRow;
    private int changedInt;

    /**
     * Constructor for MoveAction
     *
     * @param gamePlayer
     * @param startX
     * @param startY
     * @param touched
     * @param endX
     * @param endY
     * @param changed
     */
    public MoveAction(GamePlayer gamePlayer, int startX, int startY, int touched, int endX,
                      int endY, int changed) {
        super(gamePlayer);
        this.startRow = startX;
        this.startCol = startY;
        this.touchedInt = touched;
        this.endRow = endX;
        this.endCol = endY;
        this.changedInt = changed;
    }

    /**
     * get the object's start row
     *
     * @return the row selected
     */
    public int getStartRow() {return startRow; }

    /**
     * get the object's start column
     *
     * @return the column selected
     */
    public int getStartCol() {return startCol; }

    /**
     * get the object's touched Int
     *
     * @return the int touched
     */
    public int getTouchedInt() {return touchedInt; }

    /**
     * get the object's ended row
     *
     * @return the row ended
     */
    public int getEndRow() {return endRow; }

    /**
     * get the object's ended col
     *
     * @return the col ended
     */
    public int getEndCol() {return endCol; }

    /**
     * get the object's changed int
     *
     * @return the changed int
     */
    public int getChangedInt() {return changedInt; }

}
