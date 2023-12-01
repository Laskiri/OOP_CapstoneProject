package team;

import footballPlayer.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTeamHelperTest {
    MainTeamHelper helper = new MainTeamHelper(new MainTeam());

    // Generates a Striker when given the position "Striker"
    @Test
    public void test_GeneratePlayer_Striker() {
        FootballPlayer player = helper.generatePlayer('A', "Striker");
        assertTrue(player instanceof Striker);
    }

    // Generates a Midfielder when given the position "Midfielder"
    @Test
    public void test_GeneratePlayer_Midfielder() {
        FootballPlayer player = helper.generatePlayer('A', "Midfielder");
        assertTrue(player instanceof Midfielder);
    }

    // Generates a Defender when given the position "Defender"
    @Test
    public void test_GeneratePlayer_Defender() {
        FootballPlayer player = helper.generatePlayer('A', "Defender");
        assertTrue(player instanceof Defender);
    }

    // Generates a Goalkeeper when given the position "Goalkeeper"
    @Test
    public void test_GeneratePlayer_Goalkeeper() {
        FootballPlayer player = helper.generatePlayer('A', "Goalkeeper");
        assertTrue(player instanceof Goalkeeper);
    }

    // Throws an IllegalArgumentException when given an invalid position
    @Test
    public void test_GeneratePlayer_InvalidPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            helper.generatePlayer('A', "InvalidPosition");
        });
    }
}
