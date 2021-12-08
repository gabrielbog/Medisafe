package com.medisafe.app.gui.signup;

import com.medisafe.app.classes.Application;
import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.classes.Patient;
import com.medisafe.app.gui.login.LogInFrame;
import com.medisafe.app.gui.user.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUpFrame extends JFrame {
    public static SignUpFrame signUpFrame;

    JPanel logInPanel;

    JLabel titleLabel;
    JLabel logInLabel;
    JLabel lineLabel;

    JLabel usernameLabel;
    JTextField usernameField;
    
    JLabel emailLabel;
    JTextField emailField;

    JLabel passwordLabel;
    JPasswordField passwordField;
    
    //SignUpButton signUpButton;
    JButton signUpButton;
    
    JButton backButton;

    public SignUpFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);

        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setPreferredSize(new Dimension(350, 340));
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
        
        emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setBounds(15, 150, 320, 15);
        
        emailField = new JTextField();
        emailField.setBounds(15, 170, 320, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setBounds(15, 210, 320, 15);

        passwordField = new JPasswordField();
        passwordField.setBounds(15, 230, 320, 30);
        
        signUpButton = new JButton();
        signUpButton.setText("Sign up");
        signUpButton.setBackground(UserFrame.Colors.RED);
        signUpButton.setForeground(Color.white);
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpButton.setBounds(15, 270, 320, 30);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if(username.equals("") || password.equals("") || email.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please introduce details", "Error", JOptionPane.ERROR_MESSAGE);
                    username = null;
                    password = null;
                    email = null;
                    passwordField.setText("");
                    emailField.setText("");
                }

                else
                {
                    try
                    {
                        boolean verify = Application.verify_newUser(username, email);
                        if(verify == true)
                        {
                            MedicPatientList.setCurrentPatient(new Patient(MedicPatientList.getLatestDatabaseId(), username, email));

                            //save on database in case

                            username = null;
                            password = null;
                            email = null;
                            passwordField.setText("");
                            emailField.setText("");
                            signUpFrame.dispose();
                            UserFrame.userFrame = new UserFrame();
                        }

                        else
                        {
                            JOptionPane.showMessageDialog(null, "Username/Email is already used by another user", "Error", JOptionPane.ERROR_MESSAGE);
                            username = null;
                            password = null;
                            email = null;
                            passwordField.setText("");
                            emailField.setText("");
                        }
                    }
                    catch(SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        backButton = new JButton("Back");
        backButton.setBackground(UserFrame.Colors.RED);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBounds(135, 310, 80, 15);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpFrame.signUpFrame.dispose();
                LogInFrame.logInFrame = new LogInFrame();
            }
        });

        logInPanel.add(titleLabel);
        logInPanel.add(logInLabel);
        logInPanel.add(lineLabel);
        logInPanel.add(usernameLabel);
        logInPanel.add(usernameField);
        logInPanel.add(emailLabel);
        logInPanel.add(emailField);
        logInPanel.add(passwordLabel);
        logInPanel.add(passwordField);
        logInPanel.add(signUpButton);
        logInPanel.add(backButton);

        this.add(logInPanel);
        this.pack();
        this.setVisible(true);
    }
}