public class League {
    private String name;

    private Team[] teams;

    private Team chosenTeam = new MainTeam();


    void setLeagueName(String name) {
        this.name = name;
    }

    void generateTeams() {
        for (int i = 0; i < 12; i++) {
            this.teams[i] = new Team();
            this.teams[i].setRandomName();
        }
    }

    void printTeams() {
        for (int i = 0; i < 12; i++) {
            System.out.println(i + ": "+ this.teams[i].getName());
        }
    }

    void choseTeam(int teamNumber) {
        this.chosenTeam.setTeamName(this.teams[teamNumber].getName());
        this.teams[teamNumber] = this.chosenTeam;
        System.out.println("You have chosen " + this.chosenTeam.getName() + " as your team.");
    }


}
