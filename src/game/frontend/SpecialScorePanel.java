package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.TimeLevel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public abstract class SpecialScorePanel extends ScorePanel
{
    private final String SPECIALSLEFTTEXT= "Specials left: ";
    private Label specialsLeftLabel;

    protected SpecialScorePanel()
    {
        super();
        setStyle("-fx-background-color: #5490ff");
        specialsLeftLabel = new Label();
        specialsLeftLabel.setAlignment(Pos.TOP_LEFT);
        specialsLeftLabel.setStyle("-fx-font-size: 24");
        setLeft(specialsLeftLabel);
    }

    @Override
    public void setGame(CandyGame game)
    {
        super.setGame(game);
        updateSpecialsLeft();
    }

    private void updateSpecialsLeft()
    {
        int specialsLeft= ((TimeLevel)game.getGrid()).getSpecialsLeft();
        specialsLeftLabel.setText(SPECIALSLEFTTEXT+specialsLeft);
    }

    @Override
    public void updateData(String text)
    {
        super.updateData(text);
        updateSpecialsLeft();
        if(game.isFinished())
        {
            specialsLeftLabel.setText("");
        }
    }
}
