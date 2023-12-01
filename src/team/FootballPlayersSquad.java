package team;

import java.util.List;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FootballPlayersSquad{");
        sb.append("allPlayers=");
        for (int i = 0; i < this.getAllPlayers().size(); i++) {
            sb.append(i).append(": ").append(this.getAllPlayers().get(i)).append(", ");
        }
        return sb.toString();
    }
}
