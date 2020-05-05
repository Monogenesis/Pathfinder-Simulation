/*
  @Author Darko Miklic, Marc Nauendorf
 * @Version 18.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.List;

/**
 * This Interface is an Interface for the Game Space Invaders that shows all the
 * functionality to interact with our game.
 */
public interface SpaceInvadersService {
    /**
     * Creates a the background field
     * @param width width for the field
     * @param height height for the field
     * @throws IllegalParameterException if the width or height is invalid
     */
    void createField(int width, int height) throws IllegalParameterException;

    /**
     * Creates the player
     * @param yPos for the position on the y axis
     * @param xPos for the position on the x axis
     * @throws IllegalParameterException if the width or height is invalid
     */
    void createPlayer(int xPos, int yPos) throws IllegalParameterException;

    /**
     * Creates the enemies
     * @param xPosition for the position on the x axis
     * @param yPosition for the position on the y axis
     * @param speed for the movement speed of the enemies
     * @throws IllegalParameterException if the xPos, yPos or speed is invalid
     */
    void createEnemy(int xPosition, int yPosition, EnemyType type, int speed) throws IllegalParameterException;

    /**
     *
     * Movement of the player.
     *
     * @param xPosition for the position on the x axis
     * @param yPosition for the position on the y axis
     * @throws IllegalArgumentException direction steps out of window
     */
    void movement(int xPosition, int yPosition) throws  IllegalArgumentException;

    /**
     * @param shoot to ask if the player is shooting or not
     */
    void shooting();

    void addListener(InvaderListener listener) throws IllegalParameterException;

    void removeListener(InvaderListener listener) throws IllegalParameterException;
    /**
     * @param highscoreList the counter for destroyed enemies
     */
    void addHighScore(List<String> highscoreList);

    /**
     * @param highscoreList the counter for destroyed enemies
     */
    List<HighScoreEntry> getHighscoreList();

    /**
     * @param arr for the position on the x and y axis
     */
    Position getPositionPlayer() throws IllegalArgumentException;

    /**
     * @param arr for the position on the x and y axis
     * @param speed for the movement speed of the enemies
     */
    List<Position> getPositionEnemies() throws IllegalArgumentException;

    /**
     *  Resets the Game.
     */
    void restart();
}
