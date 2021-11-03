package com.medisafe.app.threads;

import javax.swing.*;

public class TimerThread extends Thread
{
    private JLabel label;

    private int second = 0;
    private int minute = 0;
    private int hour = 0;

    public TimerThread(JLabel label)
    {
        this.label = label;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                second++;
                if(second > 59)
                {
                    second = 0;
                    minute++;
                    if(minute > 59)
                    {
                        minute = 0;
                        hour++;
                        if(hour > 23)
                        {
                            hour = 0;
                        }
                    }
                }
                label.setText("Timer: " + hour + ": " + minute + ": " + second);
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
