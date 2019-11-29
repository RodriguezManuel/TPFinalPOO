package game.backend.element;

public class TimeBonusCandy extends SpecialCandy
{
    private static final int INIT = 10;

    public TimeBonusCandy() {
        super(INIT);
    }

    @Override
    public String getLabel() {
        return "+" + INIT;
    }
}
