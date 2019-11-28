package game.backend.element;

public abstract class SpecialCandy extends Candy {
    protected int time;

    protected SpecialCandy(int time)
    {
        this.time = time;
    }


    public String getLabel()
    {
        return "";
    }

    public int getTime() {
        return time;
    }


    @Override
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        boolean result2= false;
        if(result)
        {
            SpecialCandy timeCandy= (SpecialCandy) obj;
            result2 = timeCandy.time == time;
        }
        return result && result2;
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}
