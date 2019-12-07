package game.backend.element;

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
