package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Level3ScorePanel extends ScorePanel
{
    private Label timerLabel;
    private int seconds;
    private int minutes;

    public Level3ScorePanel( int minutes, int seconds)
    {
        super();
        this.seconds=seconds;
        this.minutes=minutes;
        setStyle("-fx-background-color: #5490ff");
        timerLabel = new Label(showTimerLabel());
        timerLabel.setAlignment(Pos.TOP_LEFT);
        timerLabel.setStyle("-fx-font-size: 24");
        setLeft(timerLabel);
    }

    private boolean isMoreThanMinutes()
    {
        return seconds>=60;
    }

    private String showTimerLabel()
    {
        String min=String.valueOf(minutes);
        String sec=String.valueOf(seconds);
        if(isMoreThanMinutes())
        {
            min=String.valueOf(minutes+seconds/60);
            sec=String.valueOf(seconds%60);
        }
        return min+":"+(seconds<10? "0" : "")+sec;

    }

    private void decrementTime()
    {
        if(seconds>0)
        {
            seconds--;
        }
        else if( minutes>0)
        {
            minutes--;
            seconds=59;
        }
    }

    @Override
    public void updateScore(String text)
    {
        super.updateScore(text);
        decrementTime();
        timerLabel.setText(showTimerLabel());
    }


}
