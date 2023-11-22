package team;

import com.sun.tools.javac.Main;
import footballPlayer.*;
import utils.UserInterface;
import java.util.*;

public class MainTeamHelper {
    private MainTeam team;

    public MainTeamHelper(MainTeam team) {
        this.team = team;
    }

    public void setupTeam() {
        UserInterface ui = new UserInterface();
        ui.printAllFootballPlayers(this.team);
        Formation formation = ui.getFormation(this.team);
        this.team.setFormation(formation);
        this.makeBestStartingEleven();
        this.team.updateTeamStats();
    }

    public FootballPlayer generateStriker(char rank) {
        FootballPlayer striker = new Striker.Builder()
                .setRandomName()
                .rank(rank)
                .setRandomStats()
                .build();
        return striker;

    }

    public FootballPlayer generateMidfielder(char rank) {
        FootballPlayer midfielder = new Midfielder.Builder()
                .setRandomName()
                .rank(rank)
                .setRandomStats()
                .build();
        return midfielder;
    }

    public FootballPlayer generateDefender(char rank) {
        FootballPlayer defender = new Defender.Builder()
                .setRandomName()
                .rank(rank)
                .setRandomStats()
                .build();
        return defender;
    }

    public FootballPlayer generateGoalkeeper(char Rank) {
        FootballPlayer goalkeeper = new Goalkeeper.Builder()
                .setRandomName()
                .rank(Rank)
                .setRandomStats()
                .build();
        return goalkeeper;
    }

    public void makeBestStartingEleven() {

        // Get the position-specific lists from the StartingElevenSquad
        List<Goalkeeper> goalkeepers = this.team.getFootballPlayers().getGoalkeepers();
        List<Defender> defenders = this.team.getFootballPlayers().getDefenders();
        List<Midfielder> midfielders = this.team.getFootballPlayers().getMidfielders();
        List<Striker> strikers = this.team.getFootballPlayers().getStrikers();

        // Sort each position list by total stats in descending order
        defenders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        midfielders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        strikers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        goalkeepers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());

        // Fill the starting eleven with the best players from each position
        int index = 0;

        this.team.changeStartingPlayer(index++, goalkeepers.get(0));
        for (int i = 0; i < this.team.getFormation().getDefendersCount(); i++) {
            this.team.changeStartingPlayer(index++, defenders.get(i));
        }
        for (int i = 0; i < this.team.getFormation().getMidfieldersCount(); i++) {
            this.team.changeStartingPlayer(index++, midfielders.get(i));
        }
        for (int i = 0; i < this.team.getFormation().getStrikersCount(); i++) {
            this.team.changeStartingPlayer(index++, strikers.get(i));
        }

        System.out.println("We have made the best starting eleven for you, here it is:");
        UserInterface ui = new UserInterface();
        ui.printStartingEleven(this.team);
    }

}
