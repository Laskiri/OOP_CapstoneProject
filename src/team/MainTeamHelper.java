package team;

import com.sun.tools.javac.Main;
import footballPlayer.*;

import java.util.*;

public class MainTeamHelper {
    private MainTeam team;

    public MainTeamHelper(MainTeam team) {
        this.team = team;
    }

    public FootballPlayer generateStriker(char rank) {
        FootballPlayer striker = new Striker(rank);
        striker.generateName();
        striker.setRandomStats();
        return striker;

    }

    public FootballPlayer generateMidfielder(char rank) {
        FootballPlayer midfielder = new Midfielder(rank);
        midfielder.setRank(rank);
        midfielder.generateName();
        midfielder.setRandomStats();
        return midfielder;
    }

    public FootballPlayer generateDefender(char Rank) {
        FootballPlayer defender = new Defender(Rank);
        defender.generateName();
        defender.setRandomStats();
        return defender;
    }

    public FootballPlayer generateGoalkeeper(char Rank) {
        FootballPlayer goalkeeper = new Goalkeeper(Rank);
        goalkeeper.generateName();
        goalkeeper.setRandomStats();
        return goalkeeper;
    }


    public void generateFirst20Players(MainTeam mainTeam) {
        int i = 0;
        while(i < 6) {
            mainTeam.addFootballPlayer(i++, generateStriker(mainTeam.getTeamRank()));
        }
        while(i < 12) {
            mainTeam.addFootballPlayer(i++, generateMidfielder(mainTeam.getTeamRank()));
        }
        while(i < 18) {
            mainTeam.addFootballPlayer(i++, generateDefender(mainTeam.getTeamRank()));
        }
        while(i < 20) {
            mainTeam.addFootballPlayer(i++, generateGoalkeeper(mainTeam.getTeamRank()));
        }
    }

    public void sortFootballPlayersByClass(MainTeam mainTeam) {
        Arrays.sort(mainTeam.getFootballPlayers(), (player1, player2) ->
                player1.getClass().getSimpleName().compareTo(player2.getClass().getSimpleName())
        );
    }

    public void makeBestStartingEleven(MainTeam mainTeam) {
        Scanner scanner = new Scanner(System.in);

        // Check if the total player count matches the required count (11)
        if (mainTeam.getDefendersCount() + mainTeam.getMidfieldersCount() + mainTeam.getStrikersCount() + mainTeam.getGoalkeeperCount() != 11) {
            System.out.println("The number of players in the starting eleven must be 11");
            return;
        }


        // Create lists for each position
        List<FootballPlayer> defenders = new ArrayList<>();
        List<FootballPlayer> midfielders = new ArrayList<>();
        List<FootballPlayer> strikers = new ArrayList<>();
        List<FootballPlayer> goalkeepers = new ArrayList<>();

        // Iterate through footballPlayers and categorize them by position
        for (FootballPlayer player : mainTeam.getFootballPlayers()) {
            if (player instanceof Defender) {
                defenders.add(player);
            } else if (player instanceof Midfielder) {
                midfielders.add(player);
            } else if (player instanceof Striker) {
                strikers.add(player);
            } else if (player instanceof Goalkeeper) {
                goalkeepers.add(player);
            }
        }

        // Sort each position list by total stats in descending order
        defenders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        midfielders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        strikers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        goalkeepers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());

        // Fill the starting eleven with the best players from each position
        int index = 0;

        mainTeam.changeStartingPlayer(index++, goalkeepers.get(0));
        for (int i = 0; i < mainTeam.getDefendersCount(); i++) {
            mainTeam.changeStartingPlayer(index++, defenders.get(i));
        }
        for (int i = 0; i < mainTeam.getMidfieldersCount(); i++) {
            mainTeam.changeStartingPlayer(index++, midfielders.get(i));
        }
        for (int i = 0; i < mainTeam.getStrikersCount(); i++) {
            mainTeam.changeStartingPlayer(index++, strikers.get(i));
        }

    }

}
