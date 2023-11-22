package team;

import footballPlayer.*;

public class MainTeam extends Team {
    private FootballPlayersSquad footballPlayers = new FootballPlayersSquad();
    private Formation formation = new Formation(4, 4, 2);
    private StartingElevenSquad startingEleven = null;

    public MainTeam() {
        this.teamRank = 'A';
    }

    public MainTeam(char teamRank) {
        this.teamRank = teamRank;
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

    public void setStartingEleven(StartingElevenSquad startingEleven) {
        this.startingEleven = startingEleven;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
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
