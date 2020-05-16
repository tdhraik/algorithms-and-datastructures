package test.java.general;

import main.java.general.LargestAlphaChar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestAlphaCharTests {

    private final LargestAlphaChar largestAlphaChar = new LargestAlphaChar();

    @Test
    public void shouldReturnLargestAlphaChar() {
        assertEquals( 'z', largestAlphaChar.findLargestAlphaInString("tarunz").get() );
    }
}
