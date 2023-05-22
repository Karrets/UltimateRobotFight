package space.kodirex.Battle.Battleable;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Arena;

public class Player implements Battleable {
    private Arena arena;
    private int health = 100;
    private boolean blocking;
    private boolean powered;

    @Override
    public void setArena(Arena arena) {
        this.arena = arena;
    }

    @Override
    public String getName() {
        return "You";
    }

    @Override
    public Action getNextAction() {
        return null; //TODO: Implement
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
