package game.backend.cell;

import game.backend.Grid;
import game.backend.element.TimeCandy;
import game.backend.level.Level2;

public class TimeCell extends Cell {
    public TimeCell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(getContent().isSpecial())
            ((Level2)grid).removeSpecial((TimeCandy) getContent());

        super.clearContent();
    }
}
