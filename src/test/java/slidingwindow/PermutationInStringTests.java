package test.java.slidingwindow;

import main.java.slidingwindow.PermutationInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PermutationInStringTests {

    private final PermutationInString permutationInString
            = new PermutationInString();

    @Test
    void shouldReturnTrue_1() {
        String inputStr = "aaacb";
        String pattern = "abc";

        assertEquals(true, permutationInString.checkIfPatternExists(inputStr, pattern));
    }

    @Test
    void shouldReturnTrue_2() {
        String inputStr = "bcdxabcdy";
        String pattern = "bcdyabcdx";

        assertEquals(true, permutationInString.checkIfPatternExists(inputStr, pattern));
    }

    @Test
    void shouldReturnFalse() {
        String inputStr = "odicf";
        String pattern = "dc";

        assertEquals(false, permutationInString.checkIfPatternExists(inputStr, pattern));
    }
}

