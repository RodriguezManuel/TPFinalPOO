package game.backend.element;

public class TimeBombCandy extends SpecialCandy {
    private static final int INIT = 10;
    private static int ID = 0;
    private int IDCandy;

    private int setID(){
        return ID++;
    }

    public int getID(){
        return IDCandy;
    }

    public TimeBombCandy( CandyColor color ) {
        super(INIT, color);
        IDCandy = setID();
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
        return Integer.toString(timer);
    }
}
