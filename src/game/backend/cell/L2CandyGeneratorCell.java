package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level2;

public class L2CandyGeneratorCell extends SpecialCandyGeneratorCell {

    private boolean forceSpecial = false;

    public L2CandyGeneratorCell(Level2 lvl){
        super( lvl );
    }

    public void enableForceSpecial(){
        forceSpecial = true;
    }

    @Override
    public Element getContent(){
        Element ret = super.getContent();
        if( forceSpecial ){
            return getSpecialCandy( (Candy)ret );
        }
        forceSpecial = false;
        return ret;
    }

    @Override
    protected Element getSpecialCandy( Candy candy ){
        TimeBombCandy ret = new TimeBombCandy( candy.getColor() );
        ((Level2)grid).addSpecial( ret );
        return ret;
    }

}
