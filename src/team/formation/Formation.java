package team.formation;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;
import team.squad.Squad;
import team.squad.StartingElevenSquad;

public class Formation implements Observer, Observable {
    private int goalkeeperCount;
    private int defendersCount;
    private int midfieldersCount;
    private int strikersCount;

    private List<Observer> observers = new ArrayList<>();

    public Formation(int defendersCount, int midfieldersCount, int strikersCount) {
        this.goalkeeperCount = 1;
        this.defendersCount = defendersCount;
        this.midfieldersCount = midfieldersCount;
        this.strikersCount = strikersCount;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("update in Formation:");
        if (observable instanceof StartingElevenSquad) {
            Squad squad = (Squad) observable;
            this.defendersCount = squad.getDefenders().size();
            this.midfieldersCount = squad.getMidfielders().size();
            this.strikersCount = squad.getStrikers().size();
        }
        System.out.println(this.toString() + "\r\n");
    }

    @Override
    public String toString() {
        return "Formation{" +
                "goalkeeperCount=" + goalkeeperCount +
                ", defendersCount=" + defendersCount +
                ", midfieldersCount=" + midfieldersCount +
                ", strikersCount=" + strikersCount +
                '}';
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
    }

    public void setDefendersCount(int defendersCount) {
        this.defendersCount = defendersCount;
    }

    public void setMidfieldersCount(int midfieldersCount) {
        this.midfieldersCount = midfieldersCount;
    }

    public void setStrikersCount(int strikersCount) {
        this.strikersCount = strikersCount;
    }

    public int getDefendersCount() {
        return defendersCount;
    }

    public int getMidfieldersCount() {
        return midfieldersCount;
    }

    public int getStrikersCount() {
        return strikersCount;
    }

    public int getGoalkeeperCount() {
        return goalkeeperCount;
    }

}
