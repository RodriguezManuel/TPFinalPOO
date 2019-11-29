package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.level.SpecialLevel;

public abstract class SpecialCandyGeneratorCell extends CandyGeneratorCell {
    private static final int N = 5; //Determina la frecuencia de generación de caramelos con propiedades especiales (números encima)
                                    //Mientras mayor el N, menos frecuente es la generación con el pasar de los turnos

    protected SpecialCandyGeneratorCell( SpecialLevel lvl ){
        super( lvl );
    }

    @Override
    public Element getContent(){
        Element ret = super.getContent();
        if( !((SpecialLevel)grid).quotaExceeded() && ( 0 == (int)(Math.random() * N) ) ){ //si todavía se pueden generar caramelos especiales
            Element aux = getSpecialCandy( ((Candy)ret).getColor() );                                       //y el número generado da 0, se devuelve un caramelo especial
            ((SpecialLevel)grid).addSpecial();
        }
        return ret;
    }

    protected abstract Element getSpecialCandy( CandyColor base );

}
