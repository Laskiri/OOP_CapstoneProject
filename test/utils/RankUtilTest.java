package utils;
import org.junit.Test;
import static org.junit.Assert.*;
public class RankUtilTest {

    // The method returns the correct value for a valid rank.
    @Test
    public void test_GetRankValue_inputValidRank() {
        char rank = 'A';
        int expectedValue = 80;

        int actualValue = RankUtil.getRankValue(rank);

        assertEquals(expectedValue, actualValue);
    }

    // The method throws an IllegalArgumentException when given an invalid rank.
    @Test
    public void test_GetRankValue_inputInvalidRank_() {
        char rank = 'Z';

        assertThrows(IllegalArgumentException.class, () -> {
            RankUtil.getRankValue(rank);
        });
    }
}
