import java.util.Scanner;

public class League {

    Scanner scanner = new Scanner(System.in); // Create a Scanner object
    private String name;

    private Team[] teams;

    protected Team chosenTeam = new MainTeam();

    public League(String name) {
        this.name = name;
        this.teams = new Team[12];
    }


    void setLeagueName(String name) {
        this.name = name;
    }

    void generateTeams() {
        for (int i = 0; i < 12; i++) {
            this.teams[i] = new Team();
            this.teams[i].setRandomName();
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

    void choseTeam() {
        System.out.println("Please choose a team by entering the number of the team: ");
        int teamNumber = scanner.nextInt();
        this.chosenTeam.setTeamName(this.teams[teamNumber].getName());
        this.teams[teamNumber] = this.chosenTeam;
        System.out.println("You have chosen " + this.chosenTeam.getName() + " as your team.");
    }


}
