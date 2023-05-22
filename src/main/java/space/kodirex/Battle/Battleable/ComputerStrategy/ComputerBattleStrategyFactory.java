package space.kodirex.Battle.Battleable.ComputerStrategy;

import space.kodirex.Battle.Action;
import space.kodirex.Battle.Battleable.Battleable;

/**
 * Factory Pattern!
 */
public class ComputerBattleStrategyFactory {
    static ComputerBattleStrategy getStrategy(ComputerBattleStrategyType type) {
        return switch(type) {
            case STUPID -> arena -> Action.values()[(int) (Math.random() * Action.values().length)];
            case SMART -> arena -> {
                Battleable self = arena.active.get();
                Battleable opponent = arena.inactive.get();

                if(!self.isBlocking() && opponent.isPowered()) return Action.BLOCK; //If opponent is powered we should consider blocking.
                if(self.getHealth() < 30) return Action.REPAIR; //Self-preservation!
                if(opponent.getHealth() < 15) return Action.ATTACK; //We're on the home stretch!
                if(!self.isPowered() && (opponent.getHealth() > 60 || !opponent.isBlocking())) return Action.POWER;

                if(!self.isPowered() && Math.random() > .75) //We aren't already, so we consider the option.
                    return Action.POWER;

                return Action.ATTACK; //No special circumstances, we might as well attack
            };
        };
    }
}
