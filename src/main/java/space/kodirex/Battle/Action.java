package space.kodirex.Battle;

import space.kodirex.IO.Parsable;

public enum Action implements Parsable<String> {
    ATTACK("attack"),
    REPAIR("repair"),
    BLOCK("block"),
    POWER("power up", "powered up")
    ;
    private final String name;
    private final String pastTense;

    Action(String name) {
        this.name = name;
        this.pastTense = null;
    }

    Action(String name, String pastTense) {
        this.name = name;
        this.pastTense = pastTense;
    }

    @Override
    public int getID() {
        return ordinal();
    }

    @Override
    public String getValue() {
        return name;
    }

    public String getPastTense() {
        if(pastTense == null)
            return getValue() + "ed";
        return pastTense;
    }
}
