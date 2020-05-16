package main.java.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstr {

    public int getLongestNonRepSubstrLen(String inputStr) {

        int maxLen = 0;
        Set<Character> uniqueCharsInStr = new HashSet<>();
        for (int windowEnd = 0; windowEnd < inputStr.length(); windowEnd++) {
            Character rightChar = inputStr.charAt(windowEnd);
            if (uniqueCharsInStr.add(rightChar)) {
                if(maxLen < uniqueCharsInStr.size()) {
                    maxLen = uniqueCharsInStr.size();
                }
            } else {
                uniqueCharsInStr.clear();
                uniqueCharsInStr.add(rightChar);
            }
        }
        return maxLen;
    }
}
