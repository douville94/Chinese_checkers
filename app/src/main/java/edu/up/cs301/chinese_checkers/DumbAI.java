package edu.up.cs301.chinese_checkers;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;

/**
 * A dumb computer player who makes only single random move.
 *
 *
 * Created by Luke Douville on 10/25/17.
 *
 */

public class DumbAI extends GameComputerPlayer
{
    /**
     * Constructor for DumbAI
     * @param name
     */
    public DumbAI(String name) {
        super(name);
    }


    /**
     * Called when the player receives a game-state (or other info) from the
     * game.
     *
     * @param info
     * 		the message from the game
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // if it was a "not your turn" message, just ignore it
        if (info instanceof NotYourTurnInfo) return;

        // if it's not a CCGameState message, ignore it; otherwise
        // cast it
        if (!(info instanceof CCGameState)) return;
        CCGameState cgs = (CCGameState) info;

        // if it's not our move, ignore it,just for double checking.
        if (cgs.getWhoseMove() != this.playerNum) return;

        sleep(500);

        ArrayList<Point> marbleCanMoveFrom = new ArrayList<Point>();
        ArrayList<Point> marbleCanMoveTo = new ArrayList<Point>();

        for (int i=1; i<16; i++) {
            for(int j=1; j<12; j++) {
                if (cgs.getIntArray()[i][j] == playerNum) {
                    //check up
                    if (cgs.getIntArray()[i-1][j] == -1) {
                        marbleCanMoveTo.add(new Point(i-1, j));
                    }
                    //check down
                    if (cgs.getIntArray()[i+1][j] == -1) {
                        marbleCanMoveTo.add(new Point(i+1, j));
                    }
                    //check left
                    if (cgs.getIntArray()[i][j-1] == -1) {
                        marbleCanMoveTo.add(new Point(i, j-1));
                    }
                    //check right
                    if (cgs.getIntArray()[i][j+1] == -1) {
                        marbleCanMoveTo.add(new Point(i, j+1));
                    }
//                    if (i%2==0) {
//                        //check up
//                        if (cgs.getIntArray()[i-1][j] == -1) {
//                            marbleCanMoveTo.add(new Point(i-1, j));
//                        }
//                        //check down
//                        if (cgs.getIntArray()[i+1][j] == -1) {
//                            marbleCanMoveTo.add(new Point(i+1, j));
//                        }
//                        //check left
//                        if (cgs.getIntArray()[i][j-1] == -1) {
//                            marbleCanMoveTo.add(new Point(i, j-1));
//                        }
//                        //check right
//                        if (cgs.getIntArray()[i][j+1] == -1) {
//                            marbleCanMoveTo.add(new Point(i, j+1));
//                        }
//                        if (cgs.getIntArray()[i+1][j+1] == -1) {
//                            marbleCanMoveTo.add(new Point(i+1,j+1));
//                        }
//                        if (cgs.getIntArray()[i-1][j+1] == -1) {
//                            marbleCanMoveTo.add(new Point(i-1,j+1));
//                        }
//                    } else if (i%2!=0) {
//                        //check up
//                        if (cgs.getIntArray()[i-1][j] == -1) {
//                            marbleCanMoveTo.add(new Point(i-1, j));
//                        }
//                        //check down
//                        if (cgs.getIntArray()[i+1][j] == -1) {
//                            marbleCanMoveTo.add(new Point(i+1, j));
//                        }
//                        //check left
//                        if (cgs.getIntArray()[i][j-1] == -1) {
//                            marbleCanMoveTo.add(new Point(i, j-1));
//                        }
//                        //check right
//                        if (cgs.getIntArray()[i][j+1] == -1) {
//                            marbleCanMoveTo.add(new Point(i, j+1));
//                        }
//                        if (cgs.getIntArray()[i-1][j-1] == -1) {
//                            marbleCanMoveTo.add(new Point(i-1,j-1));
//                        }
//                        if (cgs.getIntArray()[i+1][j-1] == -1) {
//                            marbleCanMoveTo.add(new Point(i+1,j-1));
//                        }
//                    }
                }
            }
        }

        Random random = new Random();

        Point pickedTo = marbleCanMoveTo.get(random.nextInt(marbleCanMoveTo.size()));

        if (pickedTo.x!=0&&pickedTo.y!=0) {
            if (cgs.getIntArray()[pickedTo.x - 1][pickedTo.y] == playerNum) {
                marbleCanMoveFrom.add(new Point(pickedTo.x - 1, pickedTo.y));
            }
            if (cgs.getIntArray()[pickedTo.x + 1][pickedTo.y] == playerNum) {
                marbleCanMoveFrom.add(new Point(pickedTo.x + 1, pickedTo.y));
            }
            if (cgs.getIntArray()[pickedTo.x][pickedTo.y - 1] == playerNum) {
                marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y - 1));
            }
            if (cgs.getIntArray()[pickedTo.x][pickedTo.y + 1] == playerNum) {
                marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y + 1));
            }
//            if ((pickedTo.x%2)==0) {
//                if (cgs.getIntArray()[pickedTo.x+1][pickedTo.y + 1] == playerNum) {
//                    marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y + 1));
//                }
//                if (cgs.getIntArray()[pickedTo.x-1][pickedTo.y + 1] == playerNum) {
//                    marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y + 1));
//                }
//            } else if ((pickedTo.x%2)!=0) {
//                if (cgs.getIntArray()[pickedTo.x+1][pickedTo.y - 1] == playerNum) {
//                    marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y + 1));
//                }
//                if (cgs.getIntArray()[pickedTo.x-1][pickedTo.y - 1] == playerNum) {
//                    marbleCanMoveFrom.add(new Point(pickedTo.x, pickedTo.y + 1));
//                }
//            }
        }
//        int pickedRow = pickedTo.x;
//        int pickedCol = pickedTo.y;
//
//        if (pickedRow%2==0) {
//            if (cgs.getIntArray()[pickedRow-1][pickedCol] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow-1,pickedCol));
//            }
//            if (cgs.getIntArray()[pickedRow+1][pickedCol] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow+1,pickedCol));
//            }
//            if (cgs.getIntArray()[pickedRow][pickedCol-1] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow,pickedCol-1));
//            }
//            if (cgs.getIntArray()[pickedRow][pickedCol+1] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow,pickedCol+1));
//            }
//            if (cgs.getIntArray()[pickedRow-1][pickedCol-1] == -1) {
//                marbleCanMoveFrom.add(new Point(pickedRow-1,pickedCol-1));
//            }
//            if (cgs.getIntArray()[pickedRow+1][pickedCol-1] == -1) {
//                marbleCanMoveFrom.add(new Point(pickedRow+1,pickedCol-1));
//            }
//        } else {
//            if (cgs.getIntArray()[pickedRow-1][pickedCol] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow-1,pickedCol));
//            }
//            if (cgs.getIntArray()[pickedRow+1][pickedCol] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow+1,pickedCol));
//            }
//            if (cgs.getIntArray()[pickedRow][pickedCol-1] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow,pickedCol-1));
//            }
//            if (cgs.getIntArray()[pickedRow][pickedCol+1] == playerNum) {
//                marbleCanMoveFrom.add(new Point(pickedRow,pickedCol+1));
//            }
//            if (cgs.getIntArray()[pickedRow+1][pickedCol+1] == -1) {
//                marbleCanMoveFrom.add(new Point(pickedRow+1,pickedCol+1));
//            }
//            if (cgs.getIntArray()[pickedRow-1][pickedCol+1] == -1) {
//                marbleCanMoveFrom.add(new Point(pickedRow-1,pickedCol+1));
//            }
//        }

        Point pickedFrom = marbleCanMoveFrom.get(random.nextInt(marbleCanMoveFrom.size()));

        game.sendAction(new MoveAction(this,pickedFrom.x,pickedFrom.y,
                cgs.getIntArray()[pickedFrom.x][pickedFrom.y],pickedTo.x,pickedTo.y,
                cgs.getIntArray()[pickedTo.x][pickedTo.y]));
    }
}
