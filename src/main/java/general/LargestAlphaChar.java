package main.java.general;

import java.util.Optional;

public class LargestAlphaChar {

    static char largestCharValue = 0;

    public Optional<Character> findLargestAlphaInString( String inputStr ) {

        if( inputStr == null ) {
            return Optional.empty();
        }

        inputStr.chars().boxed()
                .forEach( c -> {
                    if( c > largestCharValue ) {
                        largestCharValue = (char) c.intValue();
                    }
                });
        return Optional.of(largestCharValue);
    }
}
