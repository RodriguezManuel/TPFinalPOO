package game.backend.cell;

import game.backend.Grid;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level2;

public class Level2Cell extends Cell {
    public Level2Cell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(getContent().isSpecial())
            ((Level2)grid).removeSpecial((TimeBombCandy) getContent());

        super.clearContent();
    }
}
