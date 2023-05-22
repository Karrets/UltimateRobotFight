package space.kodirex;

import space.kodirex.Battle.Arena;
import space.kodirex.Battle.Battleable.Battleable;
import space.kodirex.Battle.Battleable.Computer;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyFactory;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyType;
import space.kodirex.Battle.Battleable.Player;
import space.kodirex.IO.Console;
import space.kodirex.IO.IOProvider;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        IOProvider io = IOProvider.init(Console::new);

        io.output("Welcome to the ultimate robot battle of doom!");
        io.output("");

        Optional<ComputerBattleStrategyType> ai = Optional.empty();

        while(ai.isEmpty())
            ai = io.getParseable("What kind of robot would you like to battle today?", ComputerBattleStrategyType::values);

        Arena arena = new Arena(
                new Player(),
                new Computer(ComputerBattleStrategyFactory.getStrategy(ai.get()))
        );

        while(arena.canAdvance())
            arena.advance();

        Battleable winner = arena.getWinner();
        io.outputf("winner winner chicken dinner! %s won!%n", winner.getName());
    }
}