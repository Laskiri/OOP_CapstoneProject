package footballPlayer;

import java.util.Random;

public abstract class FootballPlayer {

    private String name = "John Doe";

    private char rank;

    private static final String[] FIRST_NAMES = {
            "John", "David", "Michael", "Daniel", "James", "Robert", "William", "Thomas"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Brown", "Davis", "Wilson", "Evans", "Lee", "Taylor"
    };

    public FootballPlayer (char rank) {
        this.rank = rank;

    }


    public void generateName() {
        // Logic for randomly generating a name
        Random rand = new Random();

        // Randomly select a first name and a last name
        String firstName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];

        // Combine them to form the full name
        this.name = firstName + " " + lastName;
    }


    public void setRandomStats() {
    }

   public void setRank(char rank) {
        this.rank = rank;
    }


   public void printPlayer() {
    }

   public int totalStats() {
        return 0;
    }
    public String getName() {
        return this.name;
    }

    public char getRank() {
        return rank;
    }

    public int getShooting() {
        return 0;
    }

   public int getPassing() {
        return 0;
    }

   public int getPhysicality() {
        return 0;
    }

   public int getSpeed() {
        return 0;
    }

   public int getDefending() {
        return 0;
    }
    public int getShotStopping() {
        return 0;
    }
}

