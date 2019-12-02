package game.frontend;

import game.backend.level.SpecialLevel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class L3ScorePanel extends ScorePanel {
    private Label timerLabel;

    public L3ScorePanel()
    {
        super();
        setStyle("-fx-background-color: #5490ff");
        timerLabel = new Label(getTime());
        timerLabel.setAlignment(Pos.TOP_LEFT);
        timerLabel.setStyle("-fx-font-size: 24");
        setLeft(timerLabel);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new TimerTask() {
                    @Override
                    public void run() {
                        updateScore( getTime() );
                    }
                });
            }
        }, 0, 1000);
    }

    private String getTime(){
        return Integer.toString( ((SpecialLevel)grid).getCountdown() );
    }

}
