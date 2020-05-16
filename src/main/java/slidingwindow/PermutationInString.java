package main.java.slidingwindow;

import java.util.Map;
import java.util.stream.Collectors;

public class PermutationInString {

    public boolean checkIfPatternExists(String inputStr, String pattern) {

        Map<Character, Integer> charsFreq = pattern.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char)k.intValue(),
                        v -> 1,
                        Integer::sum
                ));
        int matched = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < inputStr.length(); windowEnd++) {
            Character rightChar = inputStr.charAt(windowEnd);
            if( charsFreq.containsKey(rightChar) && charsFreq.get(rightChar) > 0 ) {
                charsFreq.put(rightChar, charsFreq.get(rightChar) - 1);
                if( charsFreq.get(rightChar) == 0 ) {
                    matched++;
                }
            } else {
                while (windowStart < windowEnd) {
                    Character leftChar = inputStr.charAt(windowStart);
                    if(charsFreq.containsKey(leftChar)) {
                        charsFreq.put(rightChar, charsFreq.get(leftChar) + 1);
                    }
                    windowStart++;
                }
            }
            if( matched == charsFreq.size() ) {
                return true;
            }
        }
        return false;
    }
}
