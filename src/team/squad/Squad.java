package team.squad;

import java.util.ArrayList;
import java.util.List;

import footballPlayer.*;

public abstract class Squad {
    private List<FootballPlayer> allPlayers;
    private List<Goalkeeper> goalkeepers;
    private List<Defender> defenders;
    private List<Midfielder> midfielders;
    private List<Striker> strikers;

    public Squad() {
        this.allPlayers = new ArrayList<>();
        this.goalkeepers = new ArrayList<>();
        this.defenders = new ArrayList<>();
        this.midfielders = new ArrayList<>();
        this.strikers = new ArrayList<>();
    }

    public List<FootballPlayer> getAllPlayers() {
        return allPlayers;
    }

    public List<Goalkeeper> getGoalkeepers() {
        return goalkeepers;
    }

    public List<Defender> getDefenders() {
        return defenders;
    }

    public List<Midfielder> getMidfielders() {
        return midfielders;
    }

    public List<Striker> getStrikers() {
        return strikers;
    }

    public void setGoalkeepers(List<Goalkeeper> goalkeepers) {
        this.goalkeepers = goalkeepers;
    }

    public void setDefenders(List<Defender> defenders) {
        this.defenders = defenders;
    }

    public void setMidfielders(List<Midfielder> midfielders) {
        this.midfielders = midfielders;
    }

    public void setStrikers(List<Striker> strikers) {
        this.strikers = strikers;
    }

    public void setAllPlayers(List<FootballPlayer> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public FootballPlayer getFootballPlayer(int number) {
        return this.allPlayers.get(number);
    }

}
