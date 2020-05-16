package main.java.twopointers;


/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 *
 */
public class ComparingStrWithBackspaces {

    public boolean compareStrHavingBackspaces(String str1, String str2) {
        int index1 = str1.length()-1, index2 = str2.length()-1;
        boolean hasMatched = true;
        while( index1 > 0 && index2 > 0 ) {
            index1 = getNextValidIndexToCompare(str1, index1);
            index2 = getNextValidIndexToCompare(str2, index2);
            if( str1.charAt(index1) != str2.charAt(index2) ) {
                hasMatched = false;
            }else {
                index1--;
                index2--;
            }
        }
        return hasMatched;
    }

    private int getNextValidIndexToCompare(String str, int index) {
        int charsToRemove = 0;
        if( str.charAt(index) == '#' ) {
            while( str.charAt(index) == '#' ) {
                charsToRemove++;
                index--;
            }
            index = index - charsToRemove;
        }
        return index;
    }
}
