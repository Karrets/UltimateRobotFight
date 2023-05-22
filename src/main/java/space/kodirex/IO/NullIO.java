package space.kodirex.IO;

import java.util.Optional;

public class NullIO extends IOProvider {
    @Override
    public void output(String output) {}

    @Override
    public void outputf(String output, Object... objects) {}

    @Override
    public <V> Optional<Parsable<V>> getParseable(String prompt, Parsable<V>[] parsable) {
        return Optional.empty();
    }
}
