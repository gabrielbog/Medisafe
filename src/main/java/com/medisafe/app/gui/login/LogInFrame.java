package com.medisafe.app.gui.login;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.gui.medic.MedicFrame;
import com.medisafe.app.gui.user.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    //LogInButton logInButton;
    JButton logInButton;
    
    JLabel textLabel;
    
    SignUpButtonLink signUpButton;
    
    
    public LogInFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);
        
        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setPreferredSize(new Dimension(350, 280));
        logInPanel.setBackground(UserFrame.Colors.BACKGROUND);
        
        titleLabel = new JLabel("MEDISAFE");
        titleLabel.setForeground(UserFrame.Colors.RED);
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
        
        logInButton = new JButton();
        logInButton.setText("LOG IN");
        logInButton.setBackground(UserFrame.Colors.RED);
        logInButton.setForeground(Color.white);
        logInButton.setFont(new Font("Arial", Font.BOLD, 16));
        logInButton.setBounds(15, 210, 320, 30);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
        
                if(username.equals("") || password.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please introduce details", "Error", JOptionPane.ERROR_MESSAGE);
                    username = null;
                    password = null;
                    passwordField.setText("");
                }
        
                else
                {
                    int verify = MedicPatientList.verifyUser(username, password);
                    if(verify == 1)
                    {
                        username = null;
                        password = null;
                        passwordField.setText("");
                        logInFrame.dispose();
                        UserFrame.userFrame = new UserFrame();
                    }

                    else if(verify == 2)
                    {
                        username = null;
                        password = null;
                        passwordField.setText("");
                        LogInFrame.logInFrame.dispose();
                        MedicFrame.medicFrame = new MedicFrame();
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Creditentials!", "Error", JOptionPane.ERROR_MESSAGE);
                        username = null;
                        password = null;
                        passwordField.setText("");
                    }
                }
            }
        });
        
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
