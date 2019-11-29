package game.backend.element;

public class TimeBombCandy extends SpecialCandy {
    private static final int INIT = 10;

    public TimeBombCandy( CandyColor color ) {
        super(INIT, color);
    }

    public void decTimer() {
        if(!outOfTime()) {
            timer--;
        }
    }

    public boolean outOfTime() {
        return timer == 0;
    }

    @Override
    public String getLabel() {
        return Integer.toString(INIT);
    }
}
