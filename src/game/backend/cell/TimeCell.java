package game.backend.cell;

import game.backend.Grid;
import game.backend.element.TimeCandy;
import game.backend.level.TimeLevel;

public class TimeCell extends Cell {
    public TimeCell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(getContent().isSpecial())
            ((TimeLevel)getGrid()).removeSpecial((TimeCandy) getContent());

        super.clearContent();
    }
}
