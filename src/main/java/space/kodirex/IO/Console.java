package space.kodirex.IO;

import java.util.Optional;
import java.util.Scanner;

public class Console extends IOProvider {
    private final Scanner keyboard;

    public Console() {
        this.keyboard = new Scanner(System.in);
    }

    @Override
    public void output(String output) {
        System.out.printf("%s%n", output);
    }

    @Override
    public void outputf(String output, Object... objects) {
        System.out.printf(output, objects);
    }

    @Override
    public <V> Optional<Parsable<V>> getParseable(String prompt, Parsable<V>[] parsable) {
        output(prompt);
        String input = keyboard.nextLine();

        try {
            return Parsable.getParseable(Integer.parseInt(input), parsable);
        } catch(Exception ignored) {
            return Parsable.getParseable(input, parsable);
        }
    }
}
