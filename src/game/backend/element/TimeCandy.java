package game.backend.element;

public class TimeCandy extends SpecialCandy
{
    private static final String TEXT="10";

    public TimeCandy(int time)
    {
        super(time);
    }

    public void decrementTime()
    {
        if(!outOfTime())
        {
            time--;
        }
    }

    public boolean outOfTime()
    {
        return time==0;
    }

    @Override
    public String label()
    {
        return TEXT;
    }
}
