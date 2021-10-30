package com.medisafe.app.gui.login;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInFrame extends JFrame {
    public static LogInFrame logInFrame;
    
    JPanel logInPanel;
    
    JLabel titleLabel;
    JLabel logInLabel;
    JLabel lineLabel;
    
    JLabel usernameLabel;
    JTextField usernameField;
    
    JLabel passwordLabel;
    JPasswordField passwordField;
    
    LogInButton logInButton;
    
    JLabel textLabel;
    
    SignUpButtonLink signUpButton;
    
    
    public LogInFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);
        
        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setPreferredSize(new Dimension(350, 280));
        logInPanel.setBackground(new Color(28, 30, 33));
        
        titleLabel = new JLabel("MEDISAFE");
        titleLabel.setForeground(new Color(204, 44, 44));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(15, 15, 320, 20);
        
        logInLabel = new JLabel("Log In Form");
        logInLabel.setForeground(Color.white);
        logInLabel.setFont(new Font("Arial", Font.BOLD, 18));
        logInLabel.setBounds(15, 50, 320, 20);   
        
        lineLabel = new JLabel();
        lineLabel.setOpaque(true);
        lineLabel.setBackground(Color.white);
        lineLabel.setBounds(15, 75, 320, 2);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setBounds(15, 90, 320, 15);
        
        usernameField = new JTextField();
        usernameField.setBounds(15, 110, 320, 30);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setBounds(15, 150, 320, 15);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 170, 320, 30);
        
        logInButton = new LogInButton();
        
        textLabel = new JLabel("Are you new?");
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        textLabel.setBounds(95, 245, 80, 15);  
        
        signUpButton = new SignUpButtonLink();
        
        logInPanel.add(titleLabel);
        logInPanel.add(logInLabel);
        logInPanel.add(lineLabel);
        logInPanel.add(usernameLabel);
        logInPanel.add(usernameField);
        logInPanel.add(passwordLabel);
        logInPanel.add(passwordField);
        logInPanel.add(logInButton);
        logInPanel.add(textLabel);
        logInPanel.add(signUpButton);
        
        this.add(logInPanel);
        this.pack();
        this.setVisible(true);
    }
}
