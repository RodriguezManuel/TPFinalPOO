package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Level2ScorePanel extends ScorePanel
{
    private Label countdownLabel;
    private int countdown;

    public Level2ScorePanel( int countdown)
    {
        super();
        this.countdown= countdown;
        setStyle("-fx-background-color: #5490ff");
        countdownLabel = new Label(String.valueOf(countdown));
        countdownLabel.setAlignment(Pos.CENTER);
        countdownLabel.setStyle("-fx-font-size: 24");
        setRight(countdownLabel);
    }

    @Override
    public void updateScore(String text)
    {
        super.updateScore(text);
        countdownLabel.setText(String.valueOf(--countdown));
    }

    private void setCountdown(int countdown)
    {
        this.countdown=countdown;
    }


}
