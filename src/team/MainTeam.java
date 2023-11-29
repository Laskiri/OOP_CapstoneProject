package team;

import java.util.List;

import footballPlayer.*;

public class MainTeam extends Team implements Observer {
    private FootballPlayersSquad footballPlayers;
    private Formation formation;
    private StartingElevenSquad startingEleven;
    MainTeamHelper mainTeamHelper;

    public MainTeam() {
        footballPlayers = new FootballPlayersSquad();
        formation = new Formation(4, 4, 2);
        startingEleven = new StartingElevenSquad();
        mainTeamHelper = new MainTeamHelper(this);
        startingEleven.addObserver(formation);
        startingEleven.addObserver(this);
        formation.addObserver(mainTeamHelper);
    }

    @Override
    public void update(Observable observable) {
        System.out.println("update in MainTeam");
        updateTeamStats();
    }

    @Override
    public String toString() {
        return "MainTeam{" +
                "name='" + this.getName() + '\'' +
                ", teamRank=" + this.getTeamRank() +
                '}' + "\r\n";
    }

    public void addFootballPlayer(int i, FootballPlayer player) {
        this.footballPlayers.addPlayer(player);
    }

    public Formation getFormation() {
        return formation;
    }

    public void setTeamRank(char teamRank) {
        this.teamRank = teamRank;
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

    public void changeStartingPlayer(int i, FootballPlayer player) {
        if (i >= 0 && i < 11) {
            startingEleven.changePlayer(i, player);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for starting eleven: " + i);
        }
    }

    public void updateTeamStats() {
        for (FootballPlayer player : this.startingEleven.getAllPlayers()) {
            if (player instanceof Striker) {
                this.totalShooting += player.getShooting();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if (player instanceof Midfielder) {
                this.totalPassing += player.getPassing();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if (player instanceof Defender) {
                this.totalDefending += player.getDefending();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if (player instanceof Goalkeeper) {
                this.totalShotStopping += player.getShotStopping();
            } else {
                System.out.println("Error: Player is not of any known class");
            }
        }
    }
}
