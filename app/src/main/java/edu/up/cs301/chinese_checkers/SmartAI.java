package edu.up.cs301.chinese_checkers;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 *
 * A smart computer player who are able to make random jump and normal move.
 *
 *
 * Created by Luke D. Douville on 10/25/17.
 */

public class SmartAI extends GameComputerPlayer
{
    /**
     * constructor for the Smart AI.
     * @param name
     */
    public SmartAI(String name)
    {
        super(name);
    }

    /**
     * Called when the player receives a game-state (or other info) from the
     * game.
     * @param info
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // if it's not a CCGameState message, ignore it; otherwise cast it
        if (!(info instanceof CCGameState)) return;
        CCGameState cgs = (CCGameState) info;

        // if it's not our move, ignore it
        if (cgs.getWhoseMove() != this.playerNum) return;
        
        //initialize an arrayList of Points for store player's own pieces, and another point for
        //the future use.
        sleep(500);
        ArrayList<Point> ownMarbles = new ArrayList<Point>();
        Random random = new Random();


        //iterate through the entire board to pick up marbles that belong to this player.
        for (int i=0; i<17; i++) {
            for (int j=0; j<13; j++) {
                if (cgs.getIntArray()[i][j] == playerNum) {
                    ownMarbles.add(new Point(i,j));
                }
            }
        }

        //initialize a double with a very large number for the comparing below, and an empty double
        //for the future storage.
        double smallNum = -100;
        double distance;
        Point pickedMarble = new Point();

        int players = allPlayerNames.length;
        //finds the last marble AI have
        switch(players){
            case 2:
                switch (this.playerNum){
                    case 0:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 1:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-16;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                }
                break;
            case 3:
                switch (this.playerNum){
                    case 0:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 1:
                        for (int i=0; i<ownMarbles.size(); i++) {
                        int x = ownMarbles.get(i).x;
                        int y = ownMarbles.get(i).y;
                        int betweenX = x-12;
                        int betweenY = y-12;
                        distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                        if (distance>smallNum) {
                            smallNum=distance;
                            pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 2:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-12;
                            int betweenY = y;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                }
                break;
            case 4:
                switch (this.playerNum){
                    case 0:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 1:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-12;
                            int betweenY = y-12;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 2:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-16;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 3:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-4;
                            int betweenY = y;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                }
                break;
            case 6:
                switch (this.playerNum){
                    case 0:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 1:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-4;
                            int betweenY = y-12;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 2:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-12;
                            int betweenY = y-12;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 3:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-16;
                            int betweenY = y-6;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 4:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-12;
                            int betweenY = y;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                    case 5:
                        for (int i=0; i<ownMarbles.size(); i++) {
                            int x = ownMarbles.get(i).x;
                            int y = ownMarbles.get(i).y;
                            int betweenX = x-4;
                            int betweenY = y;
                            distance = sqrt(betweenX*betweenX+betweenY*betweenY);
                            if (distance>smallNum) {
                                smallNum=distance;
                                pickedMarble = ownMarbles.get(i);
                            }
                        }
                        break;
                }
                break;
        }
        
        ArrayList<Point> availSpots = new ArrayList<Point>();

        /*iterate through the entire board to pick up all the point that is legal to move to */
        for (int i=0; i<17; i++) {
            for (int j=0; j<13; j++) {
                //initialize two int for storage the integer that passes first filter that their
                //value is -1.

                int canTestX;
                int canTestY;
                //find all the empty slots
                if (cgs.getIntArray()[i][j] == -1) {
                    canTestX = i;
                    canTestY = j;
                    //calculate the difference between the pickedMarble and the empty slot
                    //that we decided to test.
                    int differentRow = canTestX - pickedMarble.x;
                    int differentCol = canTestY - pickedMarble.y;
                    //separate the entire board into two different section, odd row and even row.
                    if (pickedMarble.x%2==0) { //if the picked marble is in the even row
                        //if the row or col difference between the picked marble and currently
                        // testing empty slot is bigger then 1 or less then -1, which means
                        // the current empty
                        //slot is not at the surrounding of the picked marble.
                        if (differentRow>1 || differentRow<-1 || differentCol>1 ||
                                differentCol<-1) {
                            if (differentCol>0) {
                                if (differentRow<0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow>0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow==0) {
                                    if (cgs.getIntArray()[pickedMarble.x]
                                            [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }
                            } else if (differentCol<0) {
                                if (differentRow<0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+differentCol]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow>0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+differentCol]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow==0) {
                                    if (cgs.getIntArray()[pickedMarble.x]
                                            [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }
                            }
                        } else if (differentRow==-1&&differentCol==-1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==1&&differentCol==-1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==0&&differentCol==1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==0&&differentCol==-1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==1&&differentCol==0) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==-1&&differentCol==0) {
                            availSpots.add(new Point(canTestX,canTestY));
                        }
                    } else {//if the picked marble is in the odd row
                        //if the distance between the picked marble and the current testing empty
                        //slot is greater than 1.
                        if (differentRow>1 || differentRow<-1 || differentCol>1 ||
                                differentCol<-1) {
                            if (differentCol>0) {
                                if (differentRow<0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x + (differentRow/2)]
                                                    [pickedMarble.y + differentCol]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow>0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+differentCol]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow==0) {
                                    if (cgs.getIntArray()[pickedMarble.x]
                                            [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }
                            } else if (differentCol<0) {
                                if (differentRow<0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow>0) {
                                    if (abs(differentRow)==(abs(differentCol)*2)&&
                                            cgs.getIntArray()[pickedMarble.x+(differentRow/2)]
                                                    [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }else if (differentRow==0) {
                                    if (cgs.getIntArray()[pickedMarble.x]
                                            [pickedMarble.y+(differentCol/2)]>=0) {
                                        availSpots.add(new Point(canTestX,canTestY));
                                    }
                                }
                            }
                        } else if (differentRow==1&&differentCol==1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==-1&&differentCol==1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==0&&differentCol==1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==0&&differentCol==-1) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==1&&differentCol==0) {
                            availSpots.add(new Point(canTestX,canTestY));
                        } else if (differentRow==-1&&differentCol==0) {
                            availSpots.add(new Point(canTestX,canTestY));
                        }
                    }
                }
            }
        }


        Point pickedTo = availSpots.get(random.nextInt(availSpots.size()));



        game.sendAction(new MoveAction(this,pickedMarble.x, pickedMarble.y,
                cgs.getIntArray()[pickedMarble.x][pickedMarble.y],
                pickedTo.x,pickedTo.y,
                cgs.getIntArray()[pickedTo.x][pickedTo.y]));


    }
}
