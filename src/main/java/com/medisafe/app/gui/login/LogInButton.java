package com.medisafe.app.gui.login;

import com.medisafe.app.classes.Application;
import com.medisafe.app.classes.EntryPoint;
import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.gui.user.UserFrame;
import com.medisafe.app.gui.login.LogInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class LogInButton extends JButton implements ActionListener {

    LogInButton(){
        this.setText("LOG IN");
        this.setBackground(new Color(204, 44, 44));
        this.setForeground(Color.white);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBounds(15, 210, 320, 30);
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        LogInFrame.logInFrame.dispose();
        UserFrame.userFrame = new UserFrame();
    }
}
