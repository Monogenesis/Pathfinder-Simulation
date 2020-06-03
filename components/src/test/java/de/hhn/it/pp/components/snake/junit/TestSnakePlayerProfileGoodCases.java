package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the SnakePlayerProfile class with good cases")
public class TestSnakePlayerProfileGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestSnakePlayerProfileGoodCases.class);
    private String newNickname = "detlef2";

    @BeforeEach
    void setup() {
        SnakePlayerProfile testProfile = new SnakePlayerProfile("walter45");
    }

    @Test
    @DisplayName("get the player's nickname")
    void testGetPlayerNickname(){
        SnakePlayerProfile testProfile  = new SnakePlayerProfile("walter45");
        assertEquals("walter45", testProfile.getPlayerNickname(), "Nickname should be walter45");
    }

    @Test
    @DisplayName("set new nickname")
    void testSetPlayerNickname() {
        SnakePlayerProfile testProfile  = new SnakePlayerProfile("walter45");
        testProfile.setPlayerNickname(newNickname);
        assertEquals("detlef2", testProfile.getPlayerNickname(), "nickname is set to detlef2");
    }

    @Test
    @DisplayName("get the player's highscore")
    void testGetPlayerHighscore() {
        SnakePlayerProfile testProfile  = new SnakePlayerProfile("walter45");
        testProfile.setPlayerHighscore(46);
        assertEquals(46, testProfile.getPlayerHighscore(), "highscore should be 46");
    }

    @Test
    @DisplayName("get current level")
    void testGetCurrentLevel() {
        SnakePlayerProfile testProfile  = new SnakePlayerProfile("walter45");
        testProfile.setCurrentLevel(1);
        assertEquals(1, testProfile.getCurrentLevel(), "current level is level 1");
    }

    @Test
    @DisplayName("get player id")
    void testGetPlayerId() throws IllegalParameterException {
        SnakePlayerProfile testProfile  = new SnakePlayerProfile("walter45");
        testProfile.setPlayerId(2);
        assertEquals(2, testProfile.getPlayerId(), "player's id is 2");
    }
}

