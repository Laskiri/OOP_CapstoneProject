import java.util.Random;

public class Team {

    public Team (TeamBuilder builder) {
        this.name = builder.name;
        this.teamRank = builder.teamRank;
    }
    public Team() {
        this.teamRank = 'A';
    }
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


    char getTeamRank() {
        return this.teamRank;
    }

    void setTeamStats() {
        int rankBaseRating = RankUtil.getRankValue(this.teamRank);
        this.totalShooting = 3 * rankBaseRating;
        this.totalDefending = 3 * rankBaseRating;
        this.totalPassing = 4 * rankBaseRating;
        this.totalShotStopping = 1 * rankBaseRating;
        this.totalPhysicality = 10 * rankBaseRating;
        this.totalSpeed = 10 * rankBaseRating;
    }

    void printTeamStats() {
        System.out.println("Team Name: " + this.name);
        System.out.println("Team Rank: " + this.teamRank);
        System.out.println("Team Stats: ");
        System.out.println("Total Shooting: " + this.totalShooting);
        System.out.println("Total Defending: " + this.totalDefending);
        System.out.println("Total Passing: " + this.totalPassing);
        System.out.println("Total Shot Stopping: " + this.totalShotStopping);
        System.out.println("Total Physicality: " + this.totalPhysicality);
        System.out.println("Total Speed: " + this.totalSpeed);
    }


    int getPoints() {
        return this.points;
    }

    // Builder class
    public static class TeamBuilder {
        private String name;
        private char teamRank;

        public TeamBuilder setRandomName() {
             String[] TEAM_SUFFIX = {
                    "Hamburger", "Egg", "Pizza", "Hotdog", "Nugget", "French fries", "Burrito", "Vanilla"
            };

             String[] TEAM_PREFIX = {
                    "FC", "United", "Warriors", "Enjoyers", "Dynasty", "Boomers", "Monopoly", "Squad"
            };
            // Logic for randomly generating a name
            Random rand = new Random();



            // Randomly select a first name and a last name
            String suffix = TEAM_SUFFIX[rand.nextInt(TEAM_SUFFIX.length)];
            String prefix = TEAM_PREFIX[rand.nextInt(TEAM_PREFIX.length)];

            // Combine them to form the full name
            this.name = suffix + " " + prefix;
            return this;
        }

        public TeamBuilder setRandomRank() {
            char[] rankDistribution = {'A', 'B', 'C', 'D', 'E', 'F'};
            this.teamRank = (rankDistribution[(int) (Math.random() * 6)]);
            return this;
        }

        public TeamBuilder setRank(char rank) {
            this.teamRank = rank;
            return this;
        }

        public Team build() {
            return new Team(this);
        }


    }


}
