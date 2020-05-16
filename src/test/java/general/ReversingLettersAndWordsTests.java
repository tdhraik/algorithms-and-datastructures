package test.java.general;

import main.java.general.ReversingLettersAndWords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversingLettersAndWordsTests {


    private final ReversingLettersAndWords reversingLettersAndWords = new ReversingLettersAndWords();

    @Test
    public void shouldReverseLettersAndWords() {
        assertEquals("nurat si sihT", reversingLettersAndWords.reversingLettersAndWords("This is tarun"));
    }
}
