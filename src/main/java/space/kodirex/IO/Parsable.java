package space.kodirex.IO;

import java.util.Arrays;
import java.util.Optional;

/**
 * Mixin pattern!
 */
public interface Parsable<V> {
    int getID();
    V getValue();

    static <V extends Parsable<?>> Optional<V> getParseable(int find, V[] parsable) {
        return Arrays.stream(parsable)
                .filter(p -> p.getID() == find)
                .findFirst();
    }

    static <V extends Parsable<?>> Optional<V> getParseable(Object find, V[] parsable) {
        return Arrays.stream(parsable)
                .filter(p -> p.getValue().equals(find))
                .findFirst();
    }
}
