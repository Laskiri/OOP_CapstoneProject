package team;

import footballPlayer.Defender;
import footballPlayer.FootballPlayer;
import footballPlayer.Goalkeeper;
import footballPlayer.Midfielder;
import footballPlayer.Striker;

public class FootballPlayersSquad extends Squad {

    public void addPlayer(FootballPlayer player) {
        this.getAllPlayers().add(player);
        if (player instanceof Goalkeeper) {
            this.getGoalkeepers().add((Goalkeeper) player);
        } else if (player instanceof Defender) {
            this.getDefenders().add((Defender) player);
        } else if (player instanceof Midfielder) {
            this.getMidfielders().add((Midfielder) player);
        } else if (player instanceof Striker) {
            this.getStrikers().add((Striker) player);
        }
    }
}
