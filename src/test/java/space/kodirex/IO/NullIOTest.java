package space.kodirex.IO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space.kodirex.Battle.Action;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategyType;

class NullIOTest {
    private NullIO instance;

    @BeforeEach
    void setUp() {
        instance = new NullIO();
    }

    @Test
    void output() {
        instance.output("TEST STRING");
        instance.output("TEST STRING123");
        instance.output("!@#$%^&*()");
    }

    @Test
    void outputf() {
        instance.outputf("TEST STRING");
        instance.outputf("TEST STRING123");
        instance.outputf("!@#$%^&*()");

        instance.outputf("%a%n", 0.1);
        instance.outputf("%b%n", (Object) null);
        instance.outputf("%c%n", 'c');
        instance.outputf("%d%n", 5);
        instance.outputf("%e%n", 0.00001);
        instance.outputf("%f%n", 0.00001);
        instance.outputf("%g%n", 0.00001);
        instance.outputf("%h%n", "Example Object");
        instance.outputf("%o%n", 5);
        instance.outputf("%s%n", "Test");
    }

    @Test
    void getParseable() {
        instance.getParseable("", ComputerBattleStrategyType.values());
        instance.getParseable("", Action.values());
    }
}