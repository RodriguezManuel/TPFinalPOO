package game.backend.element;

public class TimeBombCandy extends TimeCandy {
    private static final int INIT = 10;
    private static int id = 0;
    private int idCandy;

    private int setId(){
        return id++;
    }

    public int getId(){
        return idCandy;
    }

    public TimeBombCandy( CandyColor color ) {
        super(INIT, color);
        idCandy = setId();
    }

    public void decTimer() {
        timer--;
    }

    @Override
    public String getLabel() {
        return Integer.toString(timer);
    }

}
