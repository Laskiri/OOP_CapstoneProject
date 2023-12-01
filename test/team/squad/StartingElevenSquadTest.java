package team.squad;

import org.junit.Test;

import footballPlayer.Defender;
import footballPlayer.FootballPlayer;
import footballPlayer.Goalkeeper;
import footballPlayer.Midfielder;

import static org.junit.Assert.*;

public class StartingElevenSquadTest {

    // Successfully change a player in the starting eleven
    @Test
    public void test_ValidPlayerChange() {
        StartingElevenSquad squad = new StartingElevenSquad();
        FootballPlayer player1 = new Goalkeeper.Builder().build();
        FootballPlayer player2 = new Defender.Builder().build();
        squad.getGoalkeepers().add((Goalkeeper) player1);
        squad.getDefenders().add((Defender) player2);
        squad.getAllPlayers().add(player1);
        squad.getAllPlayers().add(player2);

        FootballPlayer newPlayer = new Midfielder.Builder().build();
        squad.changePlayer(1, newPlayer);

        assertEquals(newPlayer, squad.getAllPlayers().get(1));
        assertTrue(squad.getMidfielders().contains((Midfielder) newPlayer));
        assertFalse(squad.getDefenders().contains((Defender) player2));
    }

    // Throw an exception if the player being added is already in the starting
    // eleven
    @Test
    public void test_PlayerAlreadyInStartingEleven() {
        StartingElevenSquad squad = new StartingElevenSquad();
        FootballPlayer player1 = new Goalkeeper.Builder().build();
        FootballPlayer player2 = new Defender.Builder().build();
        squad.getGoalkeepers().add((Goalkeeper) player1);
        squad.getDefenders().add((Defender) player2);
        squad.getAllPlayers().add(player1);
        squad.getAllPlayers().add(player2);

        assertThrows(IllegalArgumentException.class, () -> {
            squad.changePlayer(1, player1);
        });
    }

    // Throw an exception if a non-goalkeeper is being replaced by a goalkeeper
    @Test
    public void test_ChangeNonGoalkeeperWithGoalkeeper() {
        StartingElevenSquad squad = new StartingElevenSquad();
        FootballPlayer player1 = new Goalkeeper.Builder().build();
        FootballPlayer player2 = new Defender.Builder().build();
        squad.getGoalkeepers().add((Goalkeeper) player1);
        squad.getDefenders().add((Defender) player2);
        squad.getAllPlayers().add(player1);
        squad.getAllPlayers().add(player2);

        FootballPlayer newPlayer = new Goalkeeper.Builder().build();

        assertThrows(IllegalArgumentException.class, () -> {
            squad.changePlayer(1, newPlayer);
        });
    }

    // Throw an exception when trying to change a player in an empty starting elev
   
    @Test
    public void test_ChangePlayerInEmptyStartingEleven() {
        StartingElevenSquad squad = new StartingElevenSquad();
        FootballPlayer newPlayer = new Midfielder.Builder().build();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            squad.changePlayer(0, newPlayer);
        });
    }

    // Throw an exception if the player being added is null
    @Test
    public void test_ChangePlayerWithNUll() {
        StartingElevenSquad squad = new StartingElevenSquad();
        FootballPlayer player1 = new Goalkeeper.Builder().build();
        FootballPlayer player2 = new Defender.Builder().build();
        squad.getGoalkeepers().add((Goalkeeper) player1);
        squad.getDefenders().add((Defender) player2);
        squad.getAllPlayers().add(player1);
        squad.getAllPlayers().add(player2);

        assertThrows(NullPointerException.class, () -> {
            squad.changePlayer(1, null);
        });
    }

}

//