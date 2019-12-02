package game.frontend;

import game.backend.level.Level3;
import game.backend.level.TimeLevel;
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
        timerLabel = new Label("");
        timerLabel.setAlignment(Pos.TOP_RIGHT);
        timerLabel.setStyle("-fx-font-size: 24");
        setRight(timerLabel);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new TimerTask() {
                    @Override
                    public void run() {
                        updateTime( getTime() );
                    }
                });
            }
        }, 0, 1000);
    }

    private void updateTime( String time ){
        timerLabel.setText( time );
    }

    private String getTime(){
        return Integer.toString( ((Level3)grid).getAndDecCountdown() );
    }

}
