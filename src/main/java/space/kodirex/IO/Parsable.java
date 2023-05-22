package space.kodirex.IO;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

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

    static <V extends Parsable<?>> Optional<V> getParseable(int find, Supplier<V[]> parsable) {
        return getParseable(find, parsable.get());
    }

    static <V extends Parsable<?>> Optional<V> getParseable(Object find, V[] parsable) {
        return Arrays.stream(parsable)
                .filter(p -> p.getValue().equals(find))
                .findFirst();
    }

    static <V extends Parsable<?>> Optional<V> getParseable(Object find, Supplier<V[]> parsable) {
        return getParseable(find, parsable.get());
    }
}
