package test.java.twopointers;

import main.java.twopointers.DutchNationalFlagProblem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DutchNationalFlagProblemTests {

    private final DutchNationalFlagProblem dutchNationalFlagProblem =
            new DutchNationalFlagProblem();

    @Test
    void shouldSortArr() {
        int[] arr = {1,0,2,1,0};

        assertArrayEquals(new int[]{0,0,1,1,2}, dutchNationalFlagProblem.sortArr(arr));
    }
}
