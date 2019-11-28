package game.backend.element;

public class TimeBombCandy extends SpecialCandy {
    private static final String TEXT="10";

    public TimeBombCandy(int time)
    {
        super(time);
    }

    public void decTimer() {
        if(!outOfTime())
        {
            time--;
        }
    }

    public boolean outOfTime()
    {
        return time == 0;
    }

    @Override
    public String getLabel()
    {
        return TEXT;
    }
}
