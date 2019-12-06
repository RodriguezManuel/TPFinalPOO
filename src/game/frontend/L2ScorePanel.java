package game.frontend;

import game.backend.CandyGame;
import game.backend.level.TimeLevel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class L2ScorePanel extends SpecialScorePanel
{
    private static final String TEXT = "Moves Left: ";
    private Label countdownLabel;

    public L2ScorePanel()
    {
        super();
        setStyle("-fx-background-color: #5490ff");
        countdownLabel = new Label();
        countdownLabel.setAlignment(Pos.TOP_RIGHT);
        countdownLabel.setStyle("-fx-font-size: 24");
        setRight(countdownLabel);
    }

    @Override
    public void updateData(String text) {
        super.updateData(text);
        updateCountdown();
        if(game.isFinished())
        {
            countdownLabel.setText("");
        }
    }

    @Override
    public void setGame(CandyGame game) {
        super.setGame(game);
        updateCountdown();
    }

    public void updateCountdown() {
        int aux = ( (TimeLevel)game.getGrid() ).getCountdown();
        if(aux == -1)
            countdownLabel.setText("");
        else
            countdownLabel.setText(TEXT + aux);
    }

}