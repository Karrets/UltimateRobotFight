package space.kodirex.IO;

import org.junit.jupiter.api.Test;
import space.kodirex.Battle.Action;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyType;

class ParsableTest {

    @Test
    void getParseable() {
        Parsable.getParseable(0, ComputerBattleStrategyType.values());
        Parsable.getParseable(0, Action.values());
    }

    @Test
    void testGetParseable() {
        Parsable.getParseable("", ComputerBattleStrategyType.values());
        Parsable.getParseable("", Action.values());
    }
}