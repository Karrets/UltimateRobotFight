package space.kodirex.Battle.Battleable;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Arena;

public interface Battleable {
    void setArena(Arena arena);
    String getName();
    Action getNextAction();
    boolean living();
    void go(Action a);
    void damage(int damage);
    int getHealth();
    boolean isBlocking();
    boolean isPowered();
}
