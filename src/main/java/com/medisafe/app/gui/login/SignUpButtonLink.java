package com.medisafe.app.gui.login;

import com.medisafe.app.gui.signup.SignUpFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButtonLink extends JButton implements ActionListener {
    SignUpButtonLink(){
        this.setText("Sign up");
        this.setBackground(new Color(204, 44, 44));
        this.setForeground(Color.white);
        this.setFont(new Font("Arial", Font.PLAIN, 14));
        this.setBounds(175, 245, 100, 15);
        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        LogInFrame.logInFrame.dispose();
        SignUpFrame.signUpFrame = new SignUpFrame();
    }
}
