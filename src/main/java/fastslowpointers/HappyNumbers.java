package main.java.fastslowpointers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Any number will be called a happy number if, after repeatedly replacing it
 * with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 *
 * Input: 23
 * Output: true (23 is a happy number)
 *
 * Input: 12
 * Output: false (12 is not a happy number)
 *
 */
class HappyNumbers {

    private boolean isHappyNumber(int number) {
        boolean isHappyNumber = true;
        Set<Integer> allSumOfSquares = new HashSet<>();
        int sumOfSquares = 0;
        while(sumOfSquares != 1) {
            sumOfSquares = getSumOfSquaresOfDigits(number);
            number = sumOfSquares;
            if(allSumOfSquares.contains(sumOfSquares)){
                isHappyNumber = false;
                break;
            }
            allSumOfSquares.add(sumOfSquares);
        }
        return isHappyNumber;
    }

    private int getSumOfSquaresOfDigits(int number) {
        int sum = 0, lastDigit;
        do {
            lastDigit = number%10;
            sum += lastDigit*lastDigit;
            number = number/10;
        } while (number > 10);
        sum += number*number;
        return sum;
    }

    @Test
    void shouldBeHappyNumber() {
        int number = 23;
        assertTrue(isHappyNumber(number));
    }

    @Test
    void testGetSumOfSquaresOfDigits(){
        assertEquals(1, getSumOfSquaresOfDigits(10));
    }
}
