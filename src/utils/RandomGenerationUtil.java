package utils;

import java.util.Random;

public final class RandomGenerationUtil {

    public static String generatePlayerName() {
        String[] FIRST_NAMES = {
                "John", "David", "Michael", "Daniel", "James", "Robert", "William", "Thomas"
        };

        String[] LAST_NAMES = {
                "Smith", "Johnson", "Brown", "Davis", "Wilson", "Evans", "Lee", "Taylor"
        };

        // Logic for randomly generating a name
        Random rand = new Random();

        // Randomly select a first name and a last name
        String firstName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];

        // Combine them to form the full name
        return firstName + " " + lastName;
    }

    public static String generateTeamName() {
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
        return suffix + " " + prefix;
    }

    public static char generateRank() {
        char[] rankDistribution = {'A', 'B', 'C', 'D', 'E', 'F'};
        return (rankDistribution[(int) (Math.random() * 6)]);
    }
}
