package test.java.general;

import main.java.general.CountDuplicateChars;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuplicateCharsTests {

    private final CountDuplicateChars countDuplicateChars = new CountDuplicateChars();

    @Test
    public void shouldCountDuplicateChars() {
        assertEquals(2, countDuplicateChars.countDuplicateChars("Tarun Dhraik"));
    }

    @Test
    public void shouldReturnNoDuplicateChars() {
        assertEquals(0, countDuplicateChars.countDuplicateChars("ABCDEFGHIJK"));
    }

    @Test
    public void shouldIgnoreCasesForDuplicateChars() {
        assertEquals(2, countDuplicateChars.countDuplicateChars("TARUN dhraik"));
    }

    @Test
    public void shouldReturnZeroForEmptyOrNullStrings() {
        assertEquals(0, countDuplicateChars.countDuplicateChars(""));
        assertEquals(0, countDuplicateChars.countDuplicateChars("    "));
        assertEquals(0, countDuplicateChars.countDuplicateChars(null));
    }

}
