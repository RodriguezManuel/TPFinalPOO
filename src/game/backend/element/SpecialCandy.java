package game.backend.element;

import java.util.Objects;

public abstract class SpecialCandy extends Candy {
    protected int timer;

    protected SpecialCandy(int timer, CandyColor color) {
        super(color);
        this.timer = timer;
    }

    abstract public String getLabel();

    public int getTimer() {
        return timer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTimer());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
