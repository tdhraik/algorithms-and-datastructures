package main.java.general;

public class ReversingLettersAndWords {

    public String reversingLettersAndWords( String inputLine ) {
        if( inputLine == null ) {
            return "";
        }
        if( inputLine.isEmpty() ) {
            return "";
        }
        char[] reversedString = new char[inputLine.length()];
        int index = 0;
        for (int i = inputLine.length()-1; i >=0 ; i--) {
            reversedString[index++] = inputLine.charAt(i);
        }
        return String.valueOf(reversedString);
    }
}
