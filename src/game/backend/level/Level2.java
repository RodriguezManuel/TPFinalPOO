package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.L2CandyGeneratorCell;
import game.backend.element.TimeBombCandy;

import java.util.ArrayList;
import java.util.List;

public class Level2 extends SpecialLevel {

    private static final int MAX_SPECIAL_CANDY = 8;

    public Level2(){
        super(MAX_SPECIAL_CANDY);
    }

    public void addSpecial( TimeBombCandy candy ){
        addSpecial();
        ((Level2State)state()).add( candy );
    }

    @Override
    protected Cell getCandyGenerator(){
        return new L2CandyGeneratorCell( this );
    }

    @Override
    public boolean tryMove( int i1, int i2, int j1, int j2 ){
        boolean aux = super.tryMove( i1, i2, j1, j2 );
        if (aux){
            ((Level2State)state()).decTimers();
        }
        return aux;
    }

    @Override
    protected GameState newState(){
        return new Level2State( quota );
    }

    @Override
    public void clearContent(int i, int j){
        if( get( i, j ).isSpecial() ){
            ((Level2State)state()).decSpecialsLeft();
            ((Level2State)state()).removeTimeBomb( (TimeBombCandy)get(i, j) );
        }
    }

    private class Level2State extends SpecialLevelGameState{
        private List<TimeBombCandy> activeSpecials = new ArrayList<>(quota);

        public Level2State( int candyGoal ){
            super( candyGoal );
        }

        public void removeTimeBomb( TimeBombCandy candy ){
            activeSpecials.remove( candy );
            if( !activeSpecials.isEmpty() ){
                setCountdown( activeSpecials.get(0).getTimer() );
            }
        }

        public void decTimers(){
            for( TimeBombCandy candy : activeSpecials ){
                candy.decTimer();
            }
        }

        public void add( TimeBombCandy candy ){
            activeSpecials.add( candy );
        }
    }
}
