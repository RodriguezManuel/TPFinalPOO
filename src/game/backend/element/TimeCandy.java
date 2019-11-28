package game.backend.element;

import java.sql.Time;

public class TimeCandy extends Candy
{
    private int time;

    public TimeCandy(int time)
    {
        this.time=time;
    }

    public int getTime() {
        return time;
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
    public boolean equals(Object obj)
    {
        boolean result = super.equals(obj);
        boolean result2= false;
        if(result)
        {
            TimeCandy timeCandy= (TimeCandy) obj;
            result2 = timeCandy.time==time;
        }
        return result && result2;
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}
