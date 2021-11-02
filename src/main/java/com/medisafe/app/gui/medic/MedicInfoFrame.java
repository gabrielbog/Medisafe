package com.medisafe.app.gui.medic;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.gui.user.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MedicInfoFrame extends JFrame {
    public static MedicInfoFrame medicInfoFrame;
    
    JLabel medicInfoLabel;
    
    JLabel firstNameLabel;

    JLabel lastNameLabel;
    
    JLabel emailLabel;
    
    MedicInfoFrame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);
        
        medicInfoLabel = new JLabel();
        medicInfoLabel.setLayout(null);
        medicInfoLabel.setPreferredSize(new Dimension(350, 280));
        medicInfoLabel.setOpaque(true);
        medicInfoLabel.setBackground(UserFrame.Colors.BACKGROUND);
        
        firstNameLabel = new JLabel("First name: " + MedicPatientList.getCurrentMedic().getFname());
        firstNameLabel.setForeground(Color.white);
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        firstNameLabel.setBounds(15, 15, 320, 15);
        medicInfoLabel.add(firstNameLabel);

        lastNameLabel = new JLabel("Last name: " + MedicPatientList.getCurrentMedic().getLname());
        lastNameLabel.setForeground(Color.white);
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lastNameLabel.setBounds(15, 45, 320, 15);

        medicInfoLabel.add(lastNameLabel);

        
        emailLabel = new JLabel("Email: " + MedicPatientList.getCurrentMedic().getEmail());
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setBounds(15, 75, 320, 15);
        
        medicInfoLabel.add(emailLabel);
        
        this.add(medicInfoLabel);        
        this.pack();
        this.setLocationRelativeTo(UserFrame.userFrame);
        this.setVisible(true);
    }
}
