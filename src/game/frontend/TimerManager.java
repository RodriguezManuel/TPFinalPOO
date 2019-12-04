package game.frontend;

import java.util.Timer;

public class TimerManager
{
    public static Timer currentTimer;

    public static void setTimer(Timer timer)
    {
        currentTimer = timer;
        System.out.println("Timer seted");
    }

    public static void closeTimer()
    {
        if(currentTimer!=null)
        {
            currentTimer.cancel();
            currentTimer.purge();
            currentTimer=null;
        }
        System.out.println("Timer closed");
    }
}
