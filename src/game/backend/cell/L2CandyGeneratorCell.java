package game.backend.cell;

import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level2;

public class L2CandyGeneratorCell extends SpecialCandyGeneratorCell {

    public L2CandyGeneratorCell(Level2 lvl){
        super( lvl );
    }

    @Override
    protected Element getSpecialCandy( CandyColor color ){
        return new TimeBombCandy( color );
    }

}
