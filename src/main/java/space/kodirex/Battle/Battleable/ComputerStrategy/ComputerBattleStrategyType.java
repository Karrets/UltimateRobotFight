package space.kodirex.Battle.Battleable.ComputerStrategy;

import space.kodirex.IO.Parsable;

public enum ComputerBattleStrategyType implements Parsable<String> {
    STUPID("Stupid"),
    SMART("Smart"),
    ;

    private final String name;

    ComputerBattleStrategyType(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return ordinal();
    }

    @Override
    public String getValue() {
        return name;
    }
}
