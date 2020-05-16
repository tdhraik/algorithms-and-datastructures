package main.java.general;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CountDuplicateChars {

    private BuilderExample builderExample;

    public int countDuplicateChars( String inputStr ) {
        builderExample = new BuilderExample.Builder("tarundhraik3203@gmail.com")
                .withFirstName("tarun")
                .withLastName("dhraik")
                .build();
        if ( inputStr == null ) return 0;
        if( inputStr.isEmpty() ) return 0;
        inputStr = inputStr.trim().toLowerCase();
        Map<Character, Integer> charsFrequency = inputStr.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        HashMap::new
                ));
        AtomicInteger countDuplicates = new AtomicInteger(0);
        charsFrequency.keySet()
                .forEach( k -> {
                    if ( charsFrequency.get(k) > 1 ) {
                        countDuplicates.getAndIncrement();
                    }
                });
        return countDuplicates.get();
    }
}
