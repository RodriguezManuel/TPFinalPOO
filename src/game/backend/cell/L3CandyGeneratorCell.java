package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBonusCandy;
import game.backend.level.Level3;

public class L3CandyGeneratorCell extends SpecialCandyGeneratorCell{

    public L3CandyGeneratorCell( Level3 lvl ){
        super( lvl );
    }

    @Override
    protected Element getSpecialCandy(Candy candy ){
        return new TimeBonusCandy( candy.getColor() );
    }
}
