package team;

import footballPlayer.*;

import java.util.*;
import observer.Observable;
import observer.Observer;
import team.formation.Formation;
import team.squad.FootballPlayersSquad;

public class MainTeamHelper implements Observer, Observable {

    private MainTeam team;

    private List<Observer> observers = new ArrayList<>();

    public MainTeamHelper(MainTeam team) {
        this.team = team;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("update in MainTeamHelper: updating startingEleven");
        makeBestStartingEleven(this.team.getFormation(), this.team.getFootballPlayers());
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
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

    public FootballPlayer generatePlayer(char rank, String position) {
        switch (position) {
            case "Striker":
                return generateStriker(rank);
            case "Midfielder":
                return generateMidfielder(rank);
            case "Defender":
                return generateDefender(rank);
            case "Goalkeeper":
                return generateGoalkeeper(rank);
            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public void makeBestStartingEleven(Formation formation, FootballPlayersSquad footballPlayers) {

        // Get the position-specific lists from the footballPlayer squad
        List<Goalkeeper> goalkeepers = footballPlayers.getGoalkeepers();
        List<Defender> defenders = footballPlayers.getDefenders();
        List<Midfielder> midfielders = footballPlayers.getMidfielders();
        List<Striker> strikers = footballPlayers.getStrikers();

        // Sort each position list by total stats in descending order
        defenders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        midfielders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        strikers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        goalkeepers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());

        // Fill the starting eleven with the best players from each position
        List<Goalkeeper> bestGoalkeepers = new ArrayList<>(goalkeepers.subList(0, 1));
        List<Defender> bestDefenders = new ArrayList<>(defenders.subList(0, formation.getDefendersCount()));
        List<Midfielder> bestMidfielders = new ArrayList<>(midfielders.subList(0, formation.getMidfieldersCount()));
        List<Striker> bestStrikers = new ArrayList<>(strikers.subList(0, formation.getStrikersCount()));

        this.team.updateStartingEleven(bestGoalkeepers, bestDefenders, bestMidfielders, bestStrikers);
        notifyObservers();
    }

}
