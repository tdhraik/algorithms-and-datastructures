package test.java.slidingwindow;

import main.java.slidingwindow.LongestSubstrWithKDistinctChars;
import org.junit.jupiter.api.Test;

class LongestSubStrWithKDistinctCharsTests {

    private final LongestSubstrWithKDistinctChars longestSubstrWithKDistinctChars
            = new LongestSubstrWithKDistinctChars();

    @Test
    void shouldReturnLongestSubStringLength() {
        String inputStr = "araaci";
        int size = 2;

        longestSubstrWithKDistinctChars.longestSubStrWithDistinctChars(inputStr, size);
    }
}
