package game.backend.element;

public class TimeBombCandy extends SpecialCandy {
    private static final int INIT = 10;

    public TimeBombCandy( CandyColor color ) {
        super(INIT, color);
    }

    @Override
    public boolean equals( Object o ){
        return this == o; //es necesario hacer esto, pues en la lista de timebombs activos de level2state sólo debo quitar
    }                       //las referencias exactas de los timebombs removidos por el jugador, y la clase padre definio el equals
                            //por lo cual el método remove de List va a usar el equals

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
