package team;

import java.util.ArrayList;
import java.util.List;

import footballPlayer.Defender;
import footballPlayer.FootballPlayer;
import footballPlayer.Goalkeeper;
import footballPlayer.Midfielder;
import footballPlayer.Striker;

public class StartingElevenSquad extends Squad implements Observable {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public String toString() {
        return "StartingElevenSquad{" +
                "goalkeepers=" + this.getGoalkeepers() +
                ", defenders=" + this.getDefenders() +
                ", midfielders=" + this.getMidfielders() +
                ", strikers=" + this.getStrikers() +
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

    protected void updateStartingPlayerList() {
        List<FootballPlayer> allPlayers = new ArrayList<>();
        allPlayers.addAll(this.getGoalkeepers());
        allPlayers.addAll(this.getDefenders());
        allPlayers.addAll(this.getMidfielders());
        allPlayers.addAll(this.getStrikers());
        this.setAllPlayers(allPlayers);
        notifyObservers();
    }

    public void changePlayer(int i, FootballPlayer player) {

        FootballPlayer oldPlayer = this.getAllPlayers().get(i);

        if (oldPlayer instanceof Goalkeeper && !(player instanceof Goalkeeper)) {
            throw new IllegalArgumentException("You can only replace a goalkeeper with another goalkeeper.");
        }
        if (!(oldPlayer instanceof Goalkeeper) && player instanceof Goalkeeper) {
            throw new IllegalArgumentException("You can not replace a non-goalkeeper with another a goalkeeper.");
        }

        // Remove old player from position-specific list and update formation
        if (oldPlayer instanceof Goalkeeper) {
            this.getGoalkeepers().remove(oldPlayer);
        } else if (oldPlayer instanceof Defender) {
            this.getDefenders().remove(oldPlayer);

        } else if (oldPlayer instanceof Midfielder) {
            this.getMidfielders().remove(oldPlayer);

        } else if (oldPlayer instanceof Striker) {
            this.getStrikers().remove(oldPlayer);

        }

        // Update player in allPlayers list
        this.getAllPlayers().set(i, player);

        // Add new player to position-specific list and update formation
        if (player instanceof Goalkeeper) {
            this.getGoalkeepers().add((Goalkeeper) player);
        } else if (player instanceof Defender) {
            this.getDefenders().add((Defender) player);
        } else if (player instanceof Midfielder) {
            this.getMidfielders().add((Midfielder) player);

        } else if (player instanceof Striker) {
            this.getStrikers().add((Striker) player);
        }
        notifyObservers();
    }
}
