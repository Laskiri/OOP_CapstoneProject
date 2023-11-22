package team;

import java.util.ArrayList;
import java.util.List;

import footballPlayer.*;

public abstract class Squad {
    private List<FootballPlayer> allPlayers = new ArrayList<>();
    private List<Goalkeeper> goalkeepers = new ArrayList<>();
    private List<Defender> defenders = new ArrayList<>();
    private List<Midfielder> midfielders = new ArrayList<>();
    private List<Striker> strikers = new ArrayList<>();

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

}
