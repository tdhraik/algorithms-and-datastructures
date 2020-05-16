package main.java.slidingwindow;

import java.util.List;

public class Anagram {

    public List<String> getAnagrams(String inputStr) {
        getAnagrams(inputStr, "");
        return null;
    }

    private void getAnagrams(String inputStr, String result) {
        System.out.println("INPUT STR => " + inputStr + ", RESULT => " + result);
        if(inputStr.length() == 0) {
            System.out.print(result + ", ");
            return;
        }
        for (int i = 0; i < inputStr.length(); i++) {
            Character c = inputStr.charAt(i);
            String ros = inputStr.substring(0, i) + inputStr.substring(i+1);
            getAnagrams(ros, result + c);
        }
    }
}
