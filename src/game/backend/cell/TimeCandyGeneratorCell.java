package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.level.TimeLevel;

public abstract class TimeCandyGeneratorCell extends CandyGeneratorCell {
    private static final int N = 40; //Determina la frecuencia de generación de caramelos con propiedades especiales (números encima)
                                    //Mientras mayor el N, menos frecuente es la generación con el pasar de los turnos

    protected TimeCandyGeneratorCell(TimeLevel lvl ){
        super( lvl );
    }

    @Override
    public Element getContent(){
        Element ret = super.getContent();
        if( !((TimeLevel)grid).quotaExceeded() && (0*(int)(Math.random() * N )) == 0 ){ //si todavía se pueden generar caramelos especiales
            ((TimeLevel)grid).incSpecial();                    //y el número generado da 0, se devuelve un caramelo especial
            return getSpecialCandy( ((Candy)ret) );
        }
        return ret;
    }

    protected abstract Element getSpecialCandy( Candy base );

}
