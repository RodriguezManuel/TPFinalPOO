package game.backend.level;

import game.backend.GameState;
import game.backend.cell.TimeCell;
import game.backend.element.TimeCandy;

public abstract class TimeLevel extends Level {

    private int quota;

    protected TimeLevel( int quota ) {
        if(quota <= 0){
            throw new IllegalStateException("REGLAS DE JUEGO INVÁLIDAS");
        }

        this.quota = quota;
    }

    @Override
    public void initialize(){
        super.initialize();
        ((SpecialLevelGameState)state()).resetSpawnedSpecials(); // Es importante que se realice antes del resetSpecialsLeft
                                                                 //pues utiliza cuántos especiales fueron eliminados durante el
                                                                 //proceso de inicializacion.
        ((SpecialLevelGameState)state()).resetSpecialsLeft();
        ((SpecialLevelGameState)state()).updateCountdown();
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

        protected abstract void removeSpecial( TimeCandy candy );

        protected void setCountdown( int value ) {
            countdown = value;
        }

        protected int getSpecialsLeft()
        {
            return specialsLeft;
        }

        protected void setSpawnedSpecials( int value ){
            spawnedSpecials = value;
        }

        protected int getSpawnedSpecials(){
            return spawnedSpecials;
        }

        protected void incSpawnedSpecials(){
            spawnedSpecials++;
        }

        protected void setSpecialsLeft( int value ){
            specialsLeft = value;
        }

        protected void decSpecialsLeft(){
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

        private void resetSpecialsLeft(){
            setSpecialsLeft( quota );
        }

        private void resetSpawnedSpecials(){
            setSpawnedSpecials(getSpawnedSpecials() - (getQuota() - getSpecialsLeft()) );
        }
    }
}
