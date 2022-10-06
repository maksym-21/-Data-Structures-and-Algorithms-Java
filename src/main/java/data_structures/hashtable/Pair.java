package data_structures.hashtable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Pair {
    private final String key;
    private final int value;
}
