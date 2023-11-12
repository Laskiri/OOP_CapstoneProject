import java.util.Scanner;

public class League {

    Scanner scanner = new Scanner(System.in); // Create a Scanner object
    private String name;

    private Team[] teams;

    protected MainTeam chosenTeam = new MainTeam();

    public League(String name) {
        this.name = name;
        this.teams = new Team[12];
    }
    void generateTeams() {
        for (int i = 0; i < 12; i++) {
            this.teams[i] = new Team.TeamBuilder().setRandomName().setRandomRank().build();
        }
    }

    String getLeagueName() {
        return this.name;
    }

    void printTeams() {
        for (int i = 0; i < 12; i++) {
            System.out.println(i + ": "+ this.teams[i].getName());
        }
    }

    void printTeamsStats() {
        for (int i = 0; i < 12; i++) {
            this.teams[i].printTeamStats();
        }
    }

    void choseTeam() {
        System.out.println("Please choose a team by entering the number of the team: ");
        int teamNumber = scanner.nextInt();
        this.chosenTeam.setTeamName(this.teams[teamNumber].getName());
        this.teams[teamNumber] = this.chosenTeam;
        System.out.println("You have chosen " + this.chosenTeam.getName() + " as your team.");
    }
    void distributeTeamRanks() {
        char[] rankDistribution = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (Team team : teams) {
            if (team != this.chosenTeam) {
                team.setTeamRank(rankDistribution[(int) (Math.random() * 6)]);
            }
            else {
                team.setTeamRank('A');
            }
        }
    }

    void InitializeLeagueTeamStats() {
        for (Team team : teams) {
            team.setTeamStats();
        }
    }


}
