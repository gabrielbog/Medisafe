package com.medisafe.app.gui.user;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserInfoFrame extends JFrame {
    public static UserInfoFrame userInfoFrame;
    
    JLabel userInfoLabel;
    
    JLabel firstNameLabel;
    JButton addFirstNameButton;

    JLabel lastNameLabel;
    JButton addLastNameButton;
    
    JLabel emailLabel;
    
    private static boolean modified = false;
    
    UserInfoFrame(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);
        
        userInfoLabel = new JLabel();
        userInfoLabel.setLayout(null);
        userInfoLabel.setPreferredSize(new Dimension(350, 280));
        userInfoLabel.setOpaque(true);
        userInfoLabel.setBackground(new Color(28, 30, 33));
        
        if (MedicPatientList.getCurrentPatient().getFname() == null){
            firstNameLabel = new JLabel("First name: ");
            firstNameLabel.setForeground(Color.white);
            firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            firstNameLabel.setBounds(15, 15, 120, 15);

            addFirstNameButton = new JButton();
            addFirstNameButton.setText("Add first name");
            addFirstNameButton.setBackground(new Color(204, 44, 44));
            addFirstNameButton.setForeground(Color.white);
            addFirstNameButton.setFont(new Font("Arial", Font.BOLD, 16));
            addFirstNameButton.setBounds(135, 15, 185, 15);
            addFirstNameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String firstName = JOptionPane.showInputDialog("Please insert your first name.");
                    MedicPatientList.getCurrentPatient().setFname(firstName);

                    modified = true;
                    
                    UserInfoFrame.userInfoFrame.dispose();
                    UserInfoFrame.userInfoFrame = new UserInfoFrame();                    
                }
            });
            
            userInfoLabel.add(firstNameLabel);
            userInfoLabel.add(addFirstNameButton);
        }else{
            firstNameLabel = new JLabel("First name: " + MedicPatientList.getCurrentPatient().getFname());
            firstNameLabel.setForeground(Color.white);
            firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            firstNameLabel.setBounds(15, 15, 120, 15);

            userInfoLabel.add(firstNameLabel);
        }

        if (MedicPatientList.getCurrentPatient().getLname() == null){
            lastNameLabel = new JLabel("Last name: ");
            lastNameLabel.setForeground(Color.white);
            lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            lastNameLabel.setBounds(15, 45, 120, 15);

            addLastNameButton = new JButton();
            addLastNameButton.setText("Add last name");
            addLastNameButton.setBackground(new Color(204, 44, 44));
            addLastNameButton.setForeground(Color.white);
            addLastNameButton.setFont(new Font("Arial", Font.BOLD, 16));
            addLastNameButton.setBounds(135, 45, 185, 15);
            addLastNameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String lastName = JOptionPane.showInputDialog("Please insert your last name.");
                    MedicPatientList.getCurrentPatient().setLname(lastName);

                    modified = true;

                    UserInfoFrame.userInfoFrame.dispose();
                    UserInfoFrame.userInfoFrame = new UserInfoFrame();
                }
            });

            userInfoLabel.add(lastNameLabel);
            userInfoLabel.add(addLastNameButton);
        }else{
            firstNameLabel = new JLabel("Last name: " + MedicPatientList.getCurrentPatient().getLname());
            firstNameLabel.setForeground(Color.white);
            firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            firstNameLabel.setBounds(15, 45, 120, 15);

            userInfoLabel.add(firstNameLabel);
        }
        
        emailLabel = new JLabel("Email: " + MedicPatientList.getCurrentPatient().getEmail());
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setBounds(15, 75, 320, 15);
        
        userInfoLabel.add(emailLabel);
        
        this.add(userInfoLabel);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (modified == true){
                    modified = false;
                    UserInfoFrame.userInfoFrame.dispose();
                    UserFrame.userFrame.dispose();
                    UserFrame.userFrame = new UserFrame();
                }else{
                    UserInfoFrame.userInfoFrame.dispose();
                }
                
            }
        });
        
        this.pack();
        this.setLocationRelativeTo(UserFrame.userFrame);
        this.setVisible(true);
    }
}
