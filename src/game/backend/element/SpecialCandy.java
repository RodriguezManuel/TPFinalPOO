package game.backend.element;

import java.util.Objects;

public abstract class SpecialCandy extends Candy {
    protected int timer;

    protected SpecialCandy(int timer)
    {
        this.timer = timer;
    }

    abstract public String getLabel();

    public int getTimer() {
        return timer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialCandy)) return false;
        if (!super.equals(o)) return false;
        SpecialCandy that = (SpecialCandy) o;
        return getTimer() == that.getTimer();
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
