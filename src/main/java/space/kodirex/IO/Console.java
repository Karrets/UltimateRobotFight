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
    public <V extends Parsable<?>> Optional<V> getParseable(String prompt, V[] parsable) {
        output(prompt);

        for(V parse : parsable) {
            outputf("%d. %s%n", parse.getID(), parse.getValue().toString());
        }

        String input = "";
        if(keyboard.hasNext())
            input = keyboard.nextLine();

        try {
            return Parsable.getParseable(Integer.parseInt(input), parsable);
        } catch(Exception ignored) {
            return Parsable.getParseable(input, parsable);
        }
    }
}
