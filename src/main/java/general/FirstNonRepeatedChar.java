package main.java.general;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

    public Optional<Character> findFirstNonRepeatedChar( String inputStr ) {
        if ( inputStr == null ) {
            return Optional.empty();
        }
        Map<Character, Integer> charsFreq = inputStr.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char)k.intValue(),
                        v -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));
        return charsFreq.keySet().stream()
                .filter( cs -> charsFreq.get(cs) == 1)
                .findFirst();
    }
}
