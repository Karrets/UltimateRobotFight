package space.kodirex.Battle;

import space.kodirex.Battle.Battleable.Battleable;
import space.kodirex.IO.IOProvider;

import java.lang.reflect.Executable;
import java.util.function.Supplier;

public class Arena {
    private boolean alphaTurn = true;
    private Battleable pAlpha;
    private Battleable pBeta;

    //This is a bit like a property from C#
    public final Supplier<Battleable> active = () -> alphaTurn ? pAlpha : pBeta;
    public final Supplier<Battleable> inactive = () -> alphaTurn ? pBeta : pAlpha;

    public Arena(Battleable pAlpha, Battleable pBeta) {
        this.pAlpha = pAlpha;
        this.pBeta = pBeta;
        pAlpha.setArena(this);
        pBeta.setArena(this);
    }

    public void advance() {
        Battleable active = this.active.get();
        Action action = active.getNextAction();

        active.go(action);

        IOProvider.get().outputf("%s %s%n", active.getName(), action.getPastTense());
        IOProvider.get().output("");
        IOProvider.get().output(toString());
        nextTurn();
    }

    public boolean canAdvance() {
        return pAlpha.living() && pBeta.living();
    }

    private void nextTurn() {
        alphaTurn = !alphaTurn;
    }

    @Override
    public String toString() {
        return String.format("       Name - [Health] - {Blocking} - <Powered>%n") +
                String.format("%11s - [%6d] - {%8b} - <%7b>%n", pAlpha.getName(), pAlpha.getHealth(), pAlpha.isBlocking(), pAlpha.isPowered()) +
                String.format("%11s - [%6d] - {%8b} - <%7b>%n", pBeta.getName(), pBeta.getHealth(), pBeta.isBlocking(), pBeta.isPowered());
    }
}
