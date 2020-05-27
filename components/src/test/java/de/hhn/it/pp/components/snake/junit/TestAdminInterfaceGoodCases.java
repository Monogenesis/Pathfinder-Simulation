package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.Snake;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test the admin interface with good cases.")
public class TestAdminInterfaceGoodCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestAdminInterfaceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;
    List<SnakePlayerProfile> profiles;

    @BeforeEach
    void setup (List<SnakePlayerProfile> profiles) {
        Snake.setIdCounter(0);
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
        this.profiles = profiles;
    }

    @Test
    @DisplayName("A new instance has no player.")
    public void testANewInstanceHasNoPlayers() {
        List<SnakePlayerProfile>
                players = snakePlayerService.getAllSnakePlayerProfiles();
        assertNotNull(players);
        assertEquals(0, players.size(), "The list should be empty.");
    }

    @Test
    @DisplayName("Adding one player to the service results in one entry.")
    public void testAddOnePlayer() throws IllegalParameterException {
        SnakePlayerProfile descriptor = new SnakePlayerProfile("LongDongSilver");
        adminSnakePlayerService.addSnakePlayerProfile(descriptor);
        List<SnakePlayerProfile> players = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile descriptor1 = players.get(0);
        assertAll(
                () -> assertEquals(1, players.size(), "There should be exactly one player in the list."),
                () -> assertEquals(0, descriptor1.getId(), "Id of players should start with 0")
        );
    }

    @Test
    @DisplayName("adds and remove one player and check the result")
    public void testRemovePlayer() throws IllegalParameterException {
        SnakePlayerProfile descriptor = new SnakePlayerProfile("LongDongSilver");
        adminSnakePlayerService.addSnakePlayerProfile(descriptor);
        List<SnakePlayerProfile> players = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile descriptor1 = players.get(0);
        adminSnakePlayerService.removeSnakePlayerProfile(players.get(0).getId());
        players = snakePlayerService.getAllSnakePlayerProfiles();
        assertEquals(0, players.size());
        }
}
