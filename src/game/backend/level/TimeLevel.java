package game.backend.level;

import game.backend.GameState;
import game.backend.cell.TimeCell;
import game.backend.element.TimeCandy;

public abstract class TimeLevel extends Level {

    private int quota;

    protected TimeLevel(int quota )
    {
        if(quota<=0)
        {
            throw new IllegalStateException();
        }
        this.quota = quota;
    }

    @Override
    protected void assignCell(int i, int j) {
        setGridCell(i, j, new TimeCell(this));
    }

    public boolean quotaExceeded(){
        return quota <= ((SpecialLevelGameState)state()).getSpawnedSpecials();
    }

    public void incSpecial(){
        ((SpecialLevelGameState)state()).incSpawnedSpecials();
    }

    public void removeSpecial( TimeCandy candy ){
        ((SpecialLevelGameState)state()).removeSpecial( candy );
    }

    public int getCountdown(){
        return ((SpecialLevelGameState)state()).getCountdown();
    }

    public int getSpecialsLeft(){return ((SpecialLevelGameState)state()).getSpecialsLeft();}

    public int getQuota() {
        return quota;
    }

    protected abstract class SpecialLevelGameState extends GameState {

        private int countdown;
        private int specialsLeft;
        private int spawnedSpecials = 0;

        protected SpecialLevelGameState( int candyGoal ){
            specialsLeft = candyGoal;
        }

        public abstract void removeSpecial( TimeCandy candy );

        protected void setCountdown( int value )
        {
            if(value<=0)
            {
                throw new IllegalStateException();
            }
            countdown = value;
        }

        public int getSpecialsLeft()
        {
            return specialsLeft;
        }

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
        }

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

        protected abstract void updateCountdown();

        protected void resetSpecialsLeft(){
            setSpecialsLeft( quota );
        }
    }
}