package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level2;

public class L2CandyGeneratorCell extends TimeCandyGeneratorCell {

    private boolean forceSpecial = false;
    private static boolean alreadyForcing = false;

    public L2CandyGeneratorCell(Level2 lvl){
        super( lvl );
    }

    public void enableForceSpecial(){
        if(alreadyForcing)
            return;

        forceSpecial = true;
        alreadyForcing = true;
    }

    @Override
    public Element getContent(){
        Element ret = super.getContent();
        if( forceSpecial ){
            if( !ret.isSpecial() ){
                ((Level2)grid).incSpecial();
            }
            alreadyForcing = false;
            forceSpecial = false;
            return getSpecialCandy( (Candy)ret );
        }
        return ret;
    }

    @Override
    protected Element getSpecialCandy( Candy candy ){
        TimeBombCandy ret = new TimeBombCandy( candy.getColor() );
        ((Level2)grid).addSpecial( ret );
        return ret;
    }

}
