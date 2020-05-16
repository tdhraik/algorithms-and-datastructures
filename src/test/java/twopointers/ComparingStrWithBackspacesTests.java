package test.java.twopointers;

import main.java.twopointers.ComparingStrWithBackspaces;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparingStrWithBackspacesTests {

    private final ComparingStrWithBackspaces comparingStrWithBackspaces =
            new ComparingStrWithBackspaces();

    @Test
    void shouldReturnStringsMatched() {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";

        assertTrue(comparingStrWithBackspaces.compareStrHavingBackspaces(str1, str2));
    }

    @Test
    void shouldReturnStringsNotMatched() {
        String str1 = "xyuip#";
        String str2 = "xyz##";

        assertFalse(comparingStrWithBackspaces.compareStrHavingBackspaces(str1, str2));
    }

}
