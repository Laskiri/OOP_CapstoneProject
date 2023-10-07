import java.util.HashMap;

public class MainTeam extends Team{
    private FootballPlayer[] footballPlayers;
    private FootballPlayer[] startingEleven;
    void printPlayers() {

    }

    FootballPlayer generateStriker(char rank) {
        FootballPlayer striker = new Striker(rank);
        striker.generateName();
        striker.setRandomStats();
        return striker;

    }

    FootballPlayer generateMidfielder(char rank) {
        FootballPlayer midfielder = new Midfielder(rank);
        midfielder.setRank(rank);
        midfielder.generateName();
        midfielder.setRandomStats();
        return midfielder;
    }

    FootballPlayer generateDefender(char Rank) {
        FootballPlayer defender = new Defender(Rank);
        defender.generateName();
        defender.setRandomStats();
        return defender;
    }

    FootballPlayer generateGoalkeeper(char Rank) {
        FootballPlayer goalkeeper = new Goalkeeper(Rank);
        goalkeeper.generateName();
        goalkeeper.setRandomStats();
        return goalkeeper;
    }


    void generateFirst20Players() {
        int i = 0;
        while(i < 6) {
            this.footballPlayers[i] = generateStriker('A');
            i++;
        }
        while(i < 12) {
            this.footballPlayers[i] = generateMidfielder('A');
            i++;
        }
        while(i < 18) {
            this.footballPlayers[i] = generateDefender('A');
            i++;
        }
        while(i < 20) {
            this.footballPlayers[i] = generateGoalkeeper('A');
            i++;
        }
    }

    void bestStartingEleven() {

    }

    void sortFootballPlayersByPosition() {

    }




    void setTeamStats(int rankBaseRating) {

    }
}
