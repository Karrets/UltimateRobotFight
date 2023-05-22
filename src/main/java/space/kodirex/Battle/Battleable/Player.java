package space.kodirex.Battle.Battleable;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Arena;
import space.kodirex.IO.IOProvider;

import java.util.Optional;

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
        Optional<Action> action = Optional.empty();

        while(action.isEmpty())
            action = IOProvider.get().getParseable("What would you like to do?", Action.values());

        return action.get();
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

    private void repair() {
        int todo = (int) (Math.random() * 10 + 1); //1 -> 10
        if(powered)
            health *= 2;

        health += todo;

        IOProvider.get().outputf("clank clank! You repair %d hp.%n", todo);
    }

    private void attack() {
        int todo = (int) (Math.random() * 20 + 6);
        if(powered)
            todo *= 2;
        arena.inactive.get().damage(todo); //5 -> 25
        powered = false;
    }

    public void damage(int damage) {
        if(blocking) {
            blocking = false;
            damage /= 3;
        }

        health -= damage;

        IOProvider.get().outputf("ouch! You took %d damage.%n", damage);
    }
}
