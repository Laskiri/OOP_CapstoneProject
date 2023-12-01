package utils;
import org.junit.Test;
import static org.junit.Assert.*;
public class RandomGenerationsTests {

    @Test
    public void test_generatePlayerName() {
        String playerName = RandomGenerationUtil.generatePlayerName();

        // Check if the generated name is not null
        assertNotNull(playerName);

        // Check if the generated name contains a space
        assertTrue(playerName.contains(" "));

        // Check if the generated name has a valid first name
        String[] firstNameOptions = {"John", "David", "Michael", "Daniel", "James", "Robert", "William", "Thomas"};
        boolean isValidFirstName = false;
        for (String firstName : firstNameOptions) {
            if (playerName.startsWith(firstName)) {
                isValidFirstName = true;
                break;
            }
        }
        assertTrue(isValidFirstName);

        // Check if the generated name has a valid last name
        String[] lastNameOptions = {"Smith", "Johnson", "Brown", "Davis", "Wilson", "Evans", "Lee", "Taylor"};
        boolean isValidLastName = false;
        for (String lastName : lastNameOptions) {
            if (playerName.endsWith(lastName)) {
                isValidLastName = true;
                break;
            }
        }
        assertTrue(isValidLastName);
    }

    // Generates a rank from A to F
    @Test
    public void test_generateRank_Returns_OneOfExpectedRanks() {
        char result = RandomGenerationUtil.generateRank();
        assertTrue(result == 'A' || result == 'B' || result == 'C' || result == 'D' || result == 'E' || result == 'F');
    }



}
