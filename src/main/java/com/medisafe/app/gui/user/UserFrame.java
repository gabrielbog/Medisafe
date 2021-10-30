package com.medisafe.app.gui.user;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    public static UserFrame userFrame;
    
    JLabel userLabel;
    
    JLabel topLabel;
    
    JLabel titleLabel;
    UserInfoLabel userInfoLabel;
    
    JLabel warningLabel;
    
    JLabel text1Label;
    JLabel appointmentsLabel;
    
    CreateAppointmentLabel createAppointmentLabel;
    
    JLabel text2Label;
    
    JLabel feedLabel;
    
    public UserFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);
        
        userLabel = new JLabel();
        userLabel.setLayout(null);
        userLabel.setOpaque(true);
        userLabel.setBackground(new Color(28, 30, 33));
        userLabel.setPreferredSize(new Dimension(1245, 700));
        
        topLabel = new JLabel();
        topLabel.setBounds(0, 0, 1245, 50);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(36, 37, 38));
        
        titleLabel = new JLabel("MEDISAFE");
        titleLabel.setForeground(new Color(204, 44, 44));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(15, 15, 320, 20);
        
        userInfoLabel = new UserInfoLabel();
        
        topLabel.add(titleLabel);
        topLabel.add(userInfoLabel);
        
        warningLabel = new JLabel("    WARNING: We need more informations about you. Complete your registration now");
        warningLabel.setOpaque(true);
        warningLabel.setBackground(new Color(152, 100, 0));
        warningLabel.setForeground(Color.WHITE);
        warningLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        warningLabel.setBounds(15, 60, 1215, 50);
        
        text1Label = new JLabel("My Appointments");
        text1Label.setForeground(Color.white);
        text1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        text1Label.setBounds(15, 125, 400, 15);
        
        appointmentsLabel = new JLabel();
        appointmentsLabel.setOpaque(true);
        appointmentsLabel.setBackground(new Color(36, 37, 38));
        appointmentsLabel.setBounds(15, 145, 400, 540);
        
        createAppointmentLabel = new CreateAppointmentLabel();

        text2Label = new JLabel("Feed");
        text2Label.setForeground(Color.white);
        text2Label.setFont(new Font("Arial", Font.PLAIN, 18));
        text2Label.setBounds(430, 220, 800, 15);

        feedLabel = new JLabel();
        feedLabel.setOpaque(true);
        feedLabel.setBackground(new Color(36, 37, 38));
        feedLabel.setBounds(430, 240, 800, 445);
        
        userLabel.add(topLabel);
        userLabel.add(warningLabel);
        userLabel.add(text1Label);
        userLabel.add(appointmentsLabel);
        userLabel.add(createAppointmentLabel);
        userLabel.add(text2Label);
        userLabel.add(feedLabel);
        
        this.add(userLabel);
        this.pack();
        this.setVisible(true);
    }
}
