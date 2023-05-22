package space.kodirex.Battle.Battleable;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Arena;
import space.kodirex.Battle.Battleable.ComputerStrategy.ComputerBattleStrategy;

public class Computer implements Battleable {
    private final ComputerBattleStrategy strategy;
    private Arena arena;
    private int health = 100;
    private boolean blocking;
    private boolean powered;
    private final String name;
    private static final String[] possibleNames = {
            "Robot Steve",
            "Robot Jim",
            "Robot Tom",
            "Robot Jerry",
            "Robot Matt",
            "Robot Jake",
            "Gertrude"
    };

    public Computer(ComputerBattleStrategy strategy) {
        this.strategy = strategy;
        name = possibleNames[(int) (possibleNames.length * Math.random())];
    }

    @Override
    public void setArena(Arena arena) {
        this.arena = arena;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Action getNextAction() {
        return strategy.getNextAction(arena);
    }

    @Override
    public boolean living() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isBlocking() {
        return blocking;
    }

    @Override
    public boolean isPowered() {
        return powered;
    }

    @Override
    public void go(Action a) {
        switch(a) {
            case ATTACK -> attack();
            case REPAIR -> repair();
            case BLOCK -> blocking = true;
            case POWER -> powered = true;
        }
    }

    private int repair() {
        int todo = (int) (Math.random() * 10 + 1); //1 -> 10
        health += todo;
        return todo;
    }

    private int attack() {
        int todo = (int) (Math.random() * 20 + 6);
        if(powered)
            todo *= 1.5;
        arena.inactive.get().damage(todo); //5 -> 25
        powered = false;
        return todo;
    }

    public void damage(int damage) {
        if(blocking) {
            blocking = false;
            health -= damage / 2;
        }
        else {
            health -= damage;
        }
    }
}
