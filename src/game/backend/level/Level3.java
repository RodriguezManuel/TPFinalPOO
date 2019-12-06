package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.L3CandyGeneratorCell;
import game.backend.element.TimeCandy;
import game.backend.element.TimeBonusCandy;

public class Level3 extends TimeLevel {

   public static final int  MAX_SPECIAL_CANDY = 5, INIT_TIME = 60;

   public Level3(){
       super( MAX_SPECIAL_CANDY );
   }

    @Override
    public void initialize() {
        super.initialize();
        ((Level3.Level3State)state()).resetSpecialsLeft();
        ((Level3.Level3State)state()).updateCountdown();
    }

    public int getAndDecCountdown(){
       return ((Level3State)state()).getAndDecCountdown();
    }

    @Override
    protected GameState newState() {
        return new Level3State( getQuota() );
    }

    @Override
    protected Cell getCandyGenerator(){
       return new L3CandyGeneratorCell( this );
    }

    protected class Level3State extends SpecialLevelGameState{

       public Level3State( int candyGoal ) {
           super(candyGoal);
           setCountdown(INIT_TIME);
       }

        public int getAndDecCountdown(){
            int aux = getCountdown();
            if(aux == 0)
                return aux;

            setCountdown(aux - 1);
            return getCountdown();
        }

       private void incCountdown( int time ){
           setCountdown( getCountdown() + time );
       }

       @Override
       public void removeSpecial( TimeCandy candy ){
           decSpecialsLeft();
           removeTimeBonus( (TimeBonusCandy) candy );
       }

       private void removeTimeBonus( TimeBonusCandy candy ){
           incCountdown( candy.getTimer() );
       }

        @Override
        protected void updateCountdown() {
            setCountdown(INIT_TIME);
        }
    }
}
