package space.kodirex.Battle.Battleable.ComputerStrategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import space.kodirex.Battle.Arena;
import space.kodirex.Battle.Battleable.Computer;
import space.kodirex.IO.IOProvider;
import space.kodirex.IO.NullIO;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//This test covers pretty much everything in the Battleable package
class ComputerBattleStrategyFactoryTest {
    @BeforeAll
    static void beforeAll() {
        IOProvider.init(NullIO::new);
    }

    @Test
    void getStrategy() {
        Supplier<Stream<ComputerBattleStrategy>> streamSupplier = () ->Arrays.stream(ComputerBattleStrategyType.values()).
                map(ComputerBattleStrategyFactory::getStrategy);

        streamSupplier.get().forEach(Assertions::assertNotNull);
        streamSupplier.get().forEach(strategyAlpha -> streamSupplier.get().forEach(strategyBeta -> {
            Arena arena = new Arena(
                    new Computer(strategyAlpha),
                    new Computer(strategyBeta)
            );

            while(arena.canAdvance()) {
                assertDoesNotThrow(arena::advance);
            }
        }));
    }
}