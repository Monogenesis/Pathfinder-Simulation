package de.hhn.it.pp.components.minesweeper.provider;

import de.hhn.it.pp.components.minesweeper.BombPosition;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.MinesweeperService;

import java.util.List;

public class Minesweeper implements MinesweeperService {
    /**
     * creates a game field.
     */
    @Override
    public void createField(int width, int height) throws IllegalArgumentException {

    }
    /**
     * Sets bombs on random locations on the field.
     */
    @Override
    public void setBombs(int bombCount) throws IllegalArgumentException {

    }
    /**
     *  resets the field and restarts the game with new bombs
     */
    @Override
    public void restart() {

    }

    /**
     *  Starts the Game.
     */
    @Override
    public void startGame() {

    }

    /**
     * Ends the Game.
     */
    @Override
    public void endGame() {

    }
    /**
     * Checks the clicked field.
     * @param x x-Pos of the clicked field.
     * @param y y-Pos of the clicked field.
     */
    @Override
    public FieldInformation[][] turn(int x, int y) {
        return null;

    }
    /**
     * Sets the bombs which are used to test our program and to see if the program gets the bombs location.
     */
    @Override
    public void setFixBombs(BombPosition[][] positions) {

    }
    /**
     * Getter for getting bombs.
     */
    @Override
    public BombPosition[][] getBombs() {
        return null;
    }
        /**
         * calculates the Points.
         */

    public void calculatePoints(){

    }

    /**
     * Sets the current Points.
     */
    public void setPoints(int points){

    }

    /**
     * @return returns the current Points.
     */
    @Override
    public int getPoints(){
        return 0;
    }


}
