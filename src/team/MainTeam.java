package team;

import java.util.List;
import observer.Observer;
import team.formation.Formation;
import team.squad.FootballPlayersSquad;
import team.squad.StartingElevenSquad;
import team.teamStats.TeamStats;
import observer.Observable;
import footballPlayer.*;

public class MainTeam extends Team implements Observer {
    private FootballPlayersSquad footballPlayers;
    private Formation formation;
    private StartingElevenSquad startingEleven;
    private MainTeamHelper mainTeamHelper;

    public MainTeam() {
        footballPlayers = new FootballPlayersSquad();
        formation = new Formation(4, 4, 2);
        startingEleven = new StartingElevenSquad();
        mainTeamHelper = new MainTeamHelper(this);

        mainTeamHelper.addObserver(this);
        startingEleven.addObserver(formation);
        startingEleven.addObserver(this);
        formation.addObserver(mainTeamHelper);
    }

    @Override
    public void update(Observable observable) {
        System.out.println("update in MainTeam");
        updateTeamStats();
        System.out.println(this.teamStats);
    }

    @Override
    public String toString() {
        return "MainTeam{" +
                "teamNumber=" + this.teamNumber +
                ", name='" + name + '\'' +
                ", teamRank=" + teamRank +
                ", TeamStats=" + teamStats +
                '}' + "\r\n";
    }

    public void addFootballPlayer(int i, FootballPlayer player) {
        this.footballPlayers.addPlayer(player);
    }

    public Formation getFormation() {
        return formation;
    }

    public void setTeamName(String name) {
        this.name = name;
    }

    public void updateFormation(Formation formation) {
        this.formation.setDefendersCount(formation.getDefendersCount());
        this.formation.setMidfieldersCount(formation.getMidfieldersCount());
        this.formation.setStrikersCount(formation.getStrikersCount());
        this.formation.notifyObservers();
    }

    public void updateStartingEleven(List<Goalkeeper> goalkeepers, List<Defender> defenders,
            List<Midfielder> midfielders, List<Striker> strikers) {
        this.startingEleven.setGoalkeepers(goalkeepers);
        this.startingEleven.setDefenders(defenders);
        this.startingEleven.setMidfielders(midfielders);
        this.startingEleven.setStrikers(strikers);
        this.startingEleven.updateStartingPlayerList();
    }

    public FootballPlayersSquad getFootballPlayers() {
        return this.footballPlayers;
    }

    public StartingElevenSquad getStartingEleven() {
        return this.startingEleven;
    }

    public MainTeamHelper getMainTeamHelper() {
        return this.mainTeamHelper;
    }

    public void changeStartingPlayer(int i, FootballPlayer player) {
        if (i >= 0 && i < 11) {
            startingEleven.changePlayer(i, player);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for starting eleven: " + i);
        }
    }

    public void updateTeamStats() {

        TeamStats stats = new TeamStats();

        for (FootballPlayer player : this.startingEleven.getAllPlayers()) {
            if (player instanceof Striker) {
                stats.setTotalShooting(stats.getTotalShooting() + player.getShooting());
                stats.setTotalPhysicality(stats.getTotalPhysicality() + player.getPhysicality());
                stats.setTotalSpeed(stats.getTotalSpeed() + player.getSpeed());
            } else if (player instanceof Midfielder) {
                stats.setTotalPassing(stats.getTotalPassing() + player.getPassing());
                stats.setTotalPhysicality(stats.getTotalPhysicality() + player.getPhysicality());
                stats.setTotalSpeed(stats.getTotalSpeed() + player.getSpeed());
            } else if (player instanceof Defender) {
                stats.setTotalDefending(stats.getTotalDefending() + player.getDefending());
                stats.setTotalPhysicality(stats.getTotalPhysicality() + player.getPhysicality());
                stats.setTotalSpeed(stats.getTotalSpeed() + player.getSpeed());
            } else if (player instanceof Goalkeeper) {
                stats.setTotalShotStopping(stats.getTotalShotStopping() + player.getShotStopping());
            } else {
                System.out.println("Error: Player is not of any known class");
            }
        }

        this.teamStats = stats;
    }
}
