package game.backend.level;

import game.backend.GameState;
import game.backend.element.Candy;

import java.util.ArrayList;
import java.util.List;

public class Level2 extends SpecialLevel {

    private static final int MAX_SPECIAL_CANDY = 8;
    private int spawnedSpecials = 0;

    public Level2(){
        super(MAX_SPECIAL_CANDY);
    }

    public void addSpecial( TimeBombCandy candy ){
        addSpecial();
        ((Level2State)state()).add( candy );
    }

    @Override
    public boolean tryMove( int i1, int i2, int j1, int j2 ){
        if (super.tryMove( i1, i2, j1, j2 )){
            ((Level2State)state()).decTimers();
        }
    }

    @Override
    protected GameState newState(){
        return new Level2State( quota );
    }

    private class Level2State extends SpecialLevelGameState{
        private List<TimeBombCandy> activeSpecials = new ArrayList<>(quota);

        public Level2State( int candyGoal ){
            super( candyGoal );
        }

        @Override
        public void explodedSpecial( SpecialCandy explodedCandy ){
            super.explodedSpecial( explodedCandy );
            activeSpecials.remove( explodedCandy );
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
