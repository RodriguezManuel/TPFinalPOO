package game.backend.level;

import game.backend.Figure;
import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.L2CandyGeneratorCell;
import game.backend.element.CandyColor;
import game.backend.element.TimeBombCandy;

import java.util.ArrayList;
import java.util.List;

public class Level2 extends SpecialLevel {

    private static final int MAX_SPECIAL_CANDY = 8;

    public Level2(){
        super(MAX_SPECIAL_CANDY);
    }

    @Override
    public void initialize(){
        super.initialize();
        if( noActive() ){
            int i = (int)(Math.random() * SIZE);
            int j = (int)(Math.random() * SIZE);
            int color = (int)(Math.random() * 6);
            TimeBombCandy aux = new TimeBombCandy( CandyColor.values()[color] );
            setContent( i, j, aux );
            addSpecial( aux );
        }
    }

    public void addSpecial( TimeBombCandy candy ){
        ((Level2State)state()).add( candy );
    }

    public boolean noActive(){
        return ((Level2State)state()).activeSpecials.isEmpty();
    }

//    @Override
//    protected void removeFigure( int i, int j, Figure f ){
//        super.removeFigure( i, j, f );
//        if( noActive() ){
//            int first = f.getPoints()[0].x;
//            int last = f.getPoints()[ f.getPoints().length - 1].x;
//            int delta = Math.abs(last - first) + 1;
//            int gen = ((int)(Math.random() * delta));
//            int newJ = (( first <= 0 )? j + first : j); //explicar esto
//            ((L2CandyGeneratorCell)(getCell( 0, newJ + delta ).getUpperCell())).enableForceSpecial();
//        }
//    }

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
        super.clearContent( i, j );
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
