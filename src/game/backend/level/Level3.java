package game.backend.level;

import game.backend.GameState;
import game.backend.element.TimeCandy;
import game.backend.element.TimeBonusCandy;

public class Level3 extends TimeLevel {

   public static final int  MAX_SPECIAL_CANDY = 7, INIT_TIME = 60;

   public Level3(){
       super( MAX_SPECIAL_CANDY );
   }

   public void removeSpecial( TimeCandy candy ){
       ((Level3State)state()).decSpecialsLeft();
       ((Level3State)state()).removeTimeBonus( (TimeBonusCandy) candy );
   }

    @Override
    protected GameState newState() {
        return new Level3State( quota );
    }

    protected class Level3State extends SpecialLevelGameState{

       public Level3State( int candyGoal ) {
           super(candyGoal);
           setCountdown(INIT_TIME);
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
        public int getCountdown() {
           int aux = super.getCountdown();
           if(aux == 0)
               return aux;

           setCountdown(super.getCountdown() - 1);
           return super.getCountdown();
        }
    }
}
