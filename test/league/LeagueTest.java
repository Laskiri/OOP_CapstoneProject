package league;

import org.junit.Test;
import team.*;
import static org.junit.Assert.*;

public class LeagueTest {

    // The method sets the name of the league to the given input.
    @Test
    public void test_setLeagueName_stringInput() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        String name = "Premier League";
        leagueBuilder.setLeagueName(name);
        assertEquals(name, leagueBuilder.name);
    }
    // The method sets the name of the league to the given input with leading and trailing white spaces removed.
    @Test
    public void test_setLeagueName_inputWithWhiteSpaces() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        leagueBuilder.setLeagueName("   Premier League   ");
        assertEquals("Premier League", leagueBuilder.name);
    }
    // setLeagueName returns the instance of the LeagueBuilder class.
    @Test
    public void test_setLeagueName_returnInstance() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        LeagueBuilder result = leagueBuilder.setLeagueName("Premier League");
        assertEquals(leagueBuilder, result);
    }

    // Generates the correct number of teams when given a valid even integer input between 8 and 20.
    @Test
    public void test_generateTeams_validEvenIntegerInput() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        leagueBuilder.generateTeams(10);
        Team[] teams = leagueBuilder.teams;
        assertEquals(10, teams.length);
    }


    // Generates Teams with non-empty names
    @Test
    public void test_generateTeams_GeneratesTeamsWithNonEmptyNames() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        int teamAmount = 10;
        leagueBuilder.generateTeams(teamAmount);
        Team[] teams = leagueBuilder.teams;
        for (Team team : teams) {
            assertNotNull(team.getName());
            assertFalse(team.getName().isEmpty());
        }
    }
    // Throws an IllegalArgumentException when given an input less than 8.
    @Test
    public void test_generateTeams_inputLessThan8() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        assertThrows(IllegalArgumentException.class, () -> {
            leagueBuilder.generateTeams(6);
        });
    }

    // Throws an IllegalArgumentException when given an input greater than 20.
    @Test
    public void test_generateTeams_inputGreaterThan20() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        assertThrows(IllegalArgumentException.class, () -> {
            leagueBuilder.generateTeams(25);
        });
    }

    // Throws an IllegalArgumentException when given an odd integer input.
    @Test
    public void test_generateTeams_oddIntegerInput() {
        LeagueBuilder leagueBuilder = new LeagueBuilder();
        assertThrows(IllegalArgumentException.class, () -> {
            leagueBuilder.generateTeams(9);
        });
    }


}
