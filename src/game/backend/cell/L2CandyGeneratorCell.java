package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level2;

public class L2CandyGeneratorCell extends TimeCandyGeneratorCell {
    public L2CandyGeneratorCell(Level2 lvl){
        super( lvl );
    }

    @Override
    protected Element getSpecialCandy( Candy candy ){
        TimeBombCandy ret = new TimeBombCandy( candy.getColor() );
        ((Level2)getGrid()).addSpecial( ret );
        return ret;
    }

}
