package game.backend.level;

import game.backend.Figure;
import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.L2CandyGeneratorCell;
import game.backend.cell.Level2Cell;
import game.backend.element.CandyColor;
import game.backend.element.SpecialCandy;
import game.backend.element.TimeBombCandy;

import java.util.*;

public class Level2 extends SpecialLevel {

    private static final int MAX_SPECIAL_CANDY = 8;

    public Level2(){
        super(MAX_SPECIAL_CANDY);
    }

    @Override
    protected void assignCell(int i, int j) {
        setGridCell(i, j, new Level2Cell(this));
    }

    @Override
    public void initialize(){
        super.initialize();
        if( noActive() ){ //Si no se generó ningún caramelo especial al arrancar la partida, se crea uno de manera forzada
            boolean flag = true;
            int i = (int) (Math.random() * SIZE);
            int j = (int) (Math.random() * SIZE);
            for( int k = 0; flag; k++ ){
                TimeBombCandy aux = new TimeBombCandy(CandyColor.values()[k]);
                setContent(i, j, aux);
                if( checkFigure(i,j) == null ){
                    addSpecial(aux);
                    incSpecial();
                    flag = false;
                }
            }
        }
        ((Level2State)state()).resetSpawnedSpecials();
        ((Level2State)state()).resetSpecialsLeft();
        ((Level2State)state()).updateCountdown();
    }

    public void addSpecial( TimeBombCandy candy ){
        ((Level2State)state()).add( candy );
    }

    public boolean noActive(){
        return ((Level2State)state()).activeSpecials.isEmpty();
    }

    @Override
    protected void removeFigure( int i, int j, Figure f ){
        super.removeFigure( i, j, f );
        if( noActive() && !quotaExceeded() ){
            int first = f.getPoints()[0].y;
            int last = f.getPoints()[ f.getPoints().length - 1].y;
            int realFirst = (( first < 0 )? j + first : j );
            int realLast = (( last > 0 )? j + last : j );
            int delta = Math.abs(realLast - realFirst) + 1;
            int gen = ((int)(Math.random() * delta));
            ((L2CandyGeneratorCell)(getCell( 0, realFirst + gen ).getUpperCell())).enableForceSpecial();
        }
    }

    @Override
    protected Cell getCandyGenerator(){
        return new L2CandyGeneratorCell( this );
    }

    @Override
    protected void executeInstructionsTryMove() {
        ((Level2State)state()).decTimers();
        super.executeInstructionsTryMove();
        if(!noActive())
            ((Level2State)state()).updateCountdown();
    }

    @Override
    protected GameState newState(){
        return new Level2State( quota );
    }

    public void removeSpecial(SpecialCandy candy){
        ((Level2State)state()).decSpecialsLeft();
        ((Level2State)state()).removeTimeBomb( (TimeBombCandy) candy );
    }

    private class Level2State extends SpecialLevelGameState{
        private TreeMap<Integer, TimeBombCandy> activeSpecials = new TreeMap<>();

        public Level2State( int candyGoal ){
            super( candyGoal );
        }

        protected void resetSpecialsLeft(){
            setSpecialsLeft( quota );
        }

        public void resetSpawnedSpecials(){
            setSpawnedSpecials( activeSpecials.size() );
        }

        public void updateCountdown(){
            setCountdown( activeSpecials.firstEntry().getValue().getTimer() );
        }

        public void removeTimeBomb( TimeBombCandy candy ){
            activeSpecials.remove( candy.getId() );
            if( !activeSpecials.isEmpty() ){
                updateCountdown();
            }
        }

        public void decTimers(){
            for( TimeBombCandy candy : activeSpecials.values() ){
                candy.decTimer();
            }
        }

        public void add( TimeBombCandy candy ){
            activeSpecials.put( candy.getId(), candy );
        }
    }
}