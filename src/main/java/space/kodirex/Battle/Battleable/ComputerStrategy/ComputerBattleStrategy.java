package space.kodirex.Battle.Battleable.ComputerStrategy;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Arena;

public interface ComputerBattleStrategy {
    Action getNextAction(Arena arena);
}
