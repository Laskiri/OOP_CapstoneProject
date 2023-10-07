import java.util.HashMap;

public final class RankUtil {
    private static final HashMap<Character, Integer> rankMap = new HashMap<>();

    static {
        // Populate the rankMap when the class is loaded
        rankMap.put('A', 80);
        rankMap.put('B', 70);
        rankMap.put('C', 60);
        rankMap.put('D', 50);
        rankMap.put('E', 40);
        rankMap.put('F', 30);
    }

    private RankUtil() {}

    // A static method that takes a rank as input and returns the associated integer value
    public static int getRankValue(char rank) {
        Integer value = rankMap.get(rank);
        if (value != null) {
            return value;
        } else {
            throw new IllegalArgumentException("Invalid rank: " + rank);
        }
    }
}
