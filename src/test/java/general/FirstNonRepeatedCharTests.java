package test.java.general;

import main.java.general.FirstNonRepeatedChar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatedCharTests {

    private final FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();

    @Test
    public void shouldReturnFirstNonRepeatedChar() {
        assertEquals('f', firstNonRepeatedChar.findFirstNonRepeatedChar("geeksforgeeks").orElseThrow(IllegalStateException::new));
        assertEquals('e', firstNonRepeatedChar.findFirstNonRepeatedChar("charteacthar").orElseThrow(IllegalStateException::new));
    }
}
