package team;

import footballPlayer.Defender;
import footballPlayer.FootballPlayer;
import footballPlayer.Goalkeeper;
import footballPlayer.Midfielder;
import footballPlayer.Striker;

public class StartingElevenSquad extends Squad {
    private Formation formation;

    public StartingElevenSquad(Formation formation, FootballPlayersSquad footballPlayers) {
        this.formation = formation;

        // Fill the starting eleven with players based on default formation
        this.getGoalkeepers().add(footballPlayers.getGoalkeepers().get(0));
        this.getAllPlayers().add(footballPlayers.getGoalkeepers().get(0));
        for (int i = 0; i < formation.getDefendersCount(); i++) {
            this.getDefenders().add(footballPlayers.getDefenders().get(i));
            this.getAllPlayers().add(footballPlayers.getDefenders().get(i));
        }
        for (int i = 0; i < formation.getMidfieldersCount(); i++) {
            this.getMidfielders().add(footballPlayers.getMidfielders().get(i));
            this.getAllPlayers().add(footballPlayers.getMidfielders().get(i));
        }
        for (int i = 0; i < formation.getStrikersCount(); i++) {
            this.getStrikers().add(footballPlayers.getStrikers().get(i));
            this.getAllPlayers().add(footballPlayers.getStrikers().get(i));
        }
    }

    public void changePlayer(int i, FootballPlayer player) {

        FootballPlayer oldPlayer = this.getAllPlayers().get(i);

        // Remove old player from position-specific list and update formation
        if (oldPlayer instanceof Goalkeeper) {
            this.getGoalkeepers().remove(oldPlayer);
        } else if (oldPlayer instanceof Defender) {
            this.getDefenders().remove(oldPlayer);
            formation.decreaseDefenders();
        } else if (oldPlayer instanceof Midfielder) {
            this.getMidfielders().remove(oldPlayer);
            formation.decreaseMidfielders();
        } else if (oldPlayer instanceof Striker) {
            this.getStrikers().remove(oldPlayer);
            formation.decreaseStrikers();
        }

        // Update player in allPlayers list
        this.getAllPlayers().set(i, player);

        // Add new player to position-specific list and update formation
        if (player instanceof Goalkeeper) {
            this.getGoalkeepers().add((Goalkeeper) player);
        } else if (player instanceof Defender) {
            this.getDefenders().add((Defender) player);
            formation.increaseDefenders();
        } else if (player instanceof Midfielder) {
            this.getMidfielders().add((Midfielder) player);
            formation.increaseMidfielders();
        } else if (player instanceof Striker) {
            this.getStrikers().add((Striker) player);
            formation.increaseStrikers();
        }
    }
}
