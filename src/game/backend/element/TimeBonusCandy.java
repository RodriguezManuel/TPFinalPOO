package game.backend.element;

public class TimeBonusCandy extends SpecialCandy
{
    private static final String TEXT="+10";

    public TimeBonusCandy(int time)
    {
        super(time);
    }

    @Override
    public String getLabel()
    {
        return TEXT;
    }
}
