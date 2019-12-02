package game.frontend;

import game.backend.CandyGame;
import game.backend.Grid;
import game.backend.level.TimeLevel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class L2ScorePanel extends ScorePanel
{
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
    }

    @Override
    public void setGame(CandyGame game) {
        super.setGame(game);
        updateCountdown();
    }

    public void updateCountdown() {
        countdownLabel.setText(String.valueOf( ((TimeLevel)game.getGrid()).getCountdown()) );
    }

}