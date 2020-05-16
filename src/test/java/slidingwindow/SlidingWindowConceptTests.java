package test.java.slidingwindow;

import main.java.slidingwindow.SlidingWindowConcept;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowConceptTests {

    private final SlidingWindowConcept slidingWindowConcept = new SlidingWindowConcept();

    @Test
    void shouldReturnAverage() {
        float[] arr = {1f,3f,2f,6f,-1f,4f,1f,8f,2f};
        int size = 5;

        // assertion
        float[] expectedResult = {2.2f,2.8f,2.4f,3.6f,2.8f};
        assertArrayEquals(expectedResult, slidingWindowConcept.getContiguousSubArrayAverage( arr, size));
    }
}
