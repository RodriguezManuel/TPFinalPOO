package game.backend.element;

public class MovementCandy extends SpecialCandy
{
    private static final String TEXT="+10";

    public MovementCandy(int time)
    {
        super(time);
    }

    @Override
    public String getLabel()
    {
        return TEXT;
    }
}
