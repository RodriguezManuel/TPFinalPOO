package game.backend.level;

import game.backend.GameState;
import game.backend.element.Element;
import game.backend.element.SpecialCandy;
import game.backend.element.TimeBombCandy;

public abstract class SpecialLevel extends Level {

    protected int quota;

    protected SpecialLevel( int quota ){
        this.quota = quota;
    }

    public boolean quotaExceeded(){
        return quota <= ((SpecialLevelGameState)state()).getSpawnedSpecials();
    }

    public void incSpecial(){
        ((SpecialLevelGameState)state()).incSpawnedSpecials();
    }

    public int getCountdown(){
        return ((SpecialLevelGameState)state()).getCountdown();
    }

    protected abstract class SpecialLevelGameState extends GameState {

        private int countdown;
        private int specialsLeft;
        private int spawnedSpecials = 0;

        protected SpecialLevelGameState( int candyGoal ){
            specialsLeft = candyGoal;
        }

        protected void setCountdown( int value ){
            countdown = value;
        };

        protected void setSpawnedSpecials( int value ){
            spawnedSpecials = value;
        }

        public int getSpawnedSpecials(){
            return spawnedSpecials;
        }

        public void incSpawnedSpecials(){
            spawnedSpecials++;
        }

        protected void setSpecialsLeft( int value ){
            specialsLeft = value;
        }

        public void decSpecialsLeft(){
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

        public int getCountdown(){
            return countdown;
        }
    }

}
