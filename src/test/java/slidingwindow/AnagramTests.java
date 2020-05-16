package test.java.slidingwindow;

import main.java.slidingwindow.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramTests {

    private final Anagram anagram = new Anagram();

    @Test
    public void shouldReturnAnagrams() {
        assertEquals(null, anagram.getAnagrams("abc"));
    }
}
