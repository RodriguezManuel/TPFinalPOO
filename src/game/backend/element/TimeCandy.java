package game.backend.element;

import java.util.Objects;

public abstract class   TimeCandy extends Candy {
    protected int timer;

    protected TimeCandy(int timer, CandyColor color) {
        super(color);
        this.timer = timer;
    }

    abstract public String getLabel();

    public int getTimer() {
        return timer;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
