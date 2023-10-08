import java.util.Random;

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

    private static final String[] TEAM_SUFFIX = {
            "Hamburger", "Egg", "Pizza", "Hotdog", "Nugget", "French fries", "Burrito", "Vanilla"
    };

    private static final String[] TEAM_PREFIX = {
            "FC", "United", "Warriors", "Enjoyers", "Dynasty", "Boomers", "Monopoly", "Squad"
    };



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
        // Logic for randomly generating a name
        Random rand = new Random();

        // Randomly select a first name and a last name
        String suffix = TEAM_SUFFIX[rand.nextInt(TEAM_SUFFIX.length)];
        String prefix = TEAM_PREFIX[rand.nextInt(TEAM_PREFIX.length)];

        // Combine them to form the full name
        this.name = suffix + " " + prefix;
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
