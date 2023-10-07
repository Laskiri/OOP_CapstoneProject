public class Team {
    private String name;

    private char teamRank;

    protected int totalShooting;

    protected int totalDefending;

    protected int totalPassing;

    protected int totalShotStopping;

    protected int totalPhysicality;

    protected int totalSpeed;

    private int points = 0;

    private int goalsFor = 0;

    private int goalsAgainst = 0;



    void setTeamRank(char rank) {
        this.teamRank = rank;
    }

    String getName() {
        return this.name;
    }

    void setTeamName(String name) {
        this.name = name;
    }

    void setRandomName() {
        this.name = "";
    }

    void setTeamStats(int rankBaseRating) {
        this.totalShooting = 3 * rankBaseRating;
        this.totalDefending = 3 * rankBaseRating;
        this.totalPassing = 4 * rankBaseRating;
        this.totalShotStopping = 1 * rankBaseRating;
        this.totalPhysicality = 10 * rankBaseRating;
        this.totalSpeed = 10 * rankBaseRating;
    }


    int getPoints() {
        return this.points;
    }




}
