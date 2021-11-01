package com.medisafe.app.threads;

import javax.swing.*;
import java.util.Calendar;

public class HourThread extends Thread
{
    private JLabel label;

    private int second = Calendar.getInstance().get(Calendar.SECOND);
    private int minute = Calendar.getInstance().get(Calendar.MINUTE);
    private int hour = Calendar.getInstance().get(Calendar.HOUR);

    public HourThread(JLabel label)
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
                second = Calendar.getInstance().get(Calendar.SECOND);
                minute = Calendar.getInstance().get(Calendar.MINUTE);
                hour = Calendar.getInstance().get(Calendar.HOUR);
                
                label.setText("Time: " + hour + ": " + minute + ": " + second);
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
