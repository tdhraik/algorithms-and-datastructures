package test.java.slidingwindow;

import main.java.slidingwindow.LongestNonRepeatingSubstr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestNonRepeatingSubstrTests {

    private LongestNonRepeatingSubstr longestNonRepeatingSubstr
            = new LongestNonRepeatingSubstr();

    @Test
    void shouldReturnLongestNonRepSubstrLen() {
        String inputStr1 = "aabccbb";
        String inputStr2 = "abbbb";
        String inputStr3 = "abccde";

        assertEquals(3, longestNonRepeatingSubstr.getLongestNonRepSubstrLen(inputStr1));
        assertEquals(2, longestNonRepeatingSubstr.getLongestNonRepSubstrLen(inputStr2));
        assertEquals(3, longestNonRepeatingSubstr.getLongestNonRepSubstrLen(inputStr3));
    }
}
