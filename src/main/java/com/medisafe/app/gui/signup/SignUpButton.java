package com.medisafe.app.gui.signup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButton extends JButton implements ActionListener {
    public SignUpButton(){
        this.setText("Sign up");
        this.setBackground(new Color(204, 44, 44));
        this.setForeground(Color.white);
        this.setFont(new Font("Arial", Font.PLAIN, 14));
        this.setBounds(15, 270, 320, 30);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("test");
    }
}
