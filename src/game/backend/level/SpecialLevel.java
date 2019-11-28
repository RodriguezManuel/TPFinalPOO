package game.backend.level;

import game.backend.GameState;
import game.backend.element.Candy;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecialLevel extends Level {

    protected int quota;

    protected SpecialLevel( int quota ){
        this.quota = quota;
    }

    public boolean quotaExceeded(){
        return quota <= ((SpecialLevelGameState)state()).getSpawnedSpecials();
    }

    public void addSpecial(){
        ((SpecialLevelGameState)state()).incSpawnedSpecials();
    }

    protected abstract class SpecialLevelGameState extends GameState {

        private int candyGoal;
        private int countdown;
        private int specialsLeft = candyGoal;
        private int spawnedSpecials = 0;

        protected SpecialLevelGameState( int candyGoal ){
            this.candyGoal = candyGoal;
        }

        protected void setCountdown( int value ){
            countdown = value;
        };

        public int getSpawnedSpecials(){
            return spawnedSpecials;
        }

        public void incSpawnedSpecials(){
            spawnedSpecials++;
        }

        public void explodedSpecial( SpecialCandy explodedCandy ){
            specialsLeft--;
        };

        @Override
        public boolean gameOver(){
            return playerWon() || countdown == 0;
        }

        @Override
        public boolean playerWon(){
            return specialsLeft == 0;
        }

    }

}
