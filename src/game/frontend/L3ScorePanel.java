package game.frontend;

import game.backend.level.Level3;
import game.backend.level.TimeLevel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class L3ScorePanel extends SpecialScorePanel {

    private Label timerLabel;
    public L3ScorePanel()
    {
        super();
        setStyle("-fx-background-color: #5490ff");
        timerLabel = new Label();
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
                        if (game.isFinished()) {
                            System.out.println("mbeh");
                            timer.cancel();
                            timer.purge();
                            timerLabel.setText("");
                            if (!game.playerWon()) {
                                updateData(" Finished - Loser !" + game.getScore() );
                            }
                        } else {
                            updateTime(getTime());
                        }
                    }
                });
            }
        }, 0, 1000);
        TimerManager.setTimer(timer);
    }

    private void updateTime( String time ){
        timerLabel.setText( time );
    }

    private String getTime(){
        return getMinuteSecondTime( ((Level3)game.getGrid()).getAndDecCountdown() );
    }

    private String getMinuteSecondTime(int time){
        String min, sec;
        int minutes = time / 60;
        int seconds = time % 60;
        min = String.valueOf(minutes);
        if(seconds < 10) {
          sec = "0" + seconds;
        } else {
          sec = String.valueOf(seconds);
        }
        return min + ":" + sec;
    }


}
