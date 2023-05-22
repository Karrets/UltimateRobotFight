package space.kodirex.Battle;

import org.junit.jupiter.api.Test;
import space.kodirex.Battle.Battleable.Computer;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyFactory;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyType;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ArenaTest {

    @Test
    void getWinner() {
        Arena a = new Arena(
                new Computer(ComputerBattleStrategyFactory.getStrategy(ComputerBattleStrategyType.SMART)),
                new Computer(ComputerBattleStrategyFactory.getStrategy(ComputerBattleStrategyType.SMART))
        );

        assertThrows(IllegalStateException.class, a::getWinner);
    }
}