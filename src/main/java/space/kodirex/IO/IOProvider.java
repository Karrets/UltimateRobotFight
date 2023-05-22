package space.kodirex.IO;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Singleton pattern!
 */
public abstract class IOProvider {
    private static IOProvider instance = null;

    public static IOProvider init(Supplier<IOProvider> ioConstructor) {
        if(instance != null) throw new IllegalStateException("IOProvider is already initialized.");
        return instance = ioConstructor.get();
    }
    public static IOProvider get() {
        if(instance == null) throw new IllegalStateException("IOProvider is not yet initialized.");
        return instance;
    }

    public abstract void output(String output);
    public abstract void outputf(String output, Object... objects);
    public abstract <V> Optional<Parsable<V>> getParseable(String prompt, Parsable<V>[] parsable);
    public final <V> Optional<Parsable<V>> getParseable(String prompt, Supplier<Parsable<V>[]> parsable) {
        return getParseable(prompt, parsable.get());
    }
}
