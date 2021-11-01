package com.medisafe.app.gui.user;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.exceptions.DateException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAppointmentFrame extends JFrame {
    public static CreateAppointmentFrame createAppointmentFrame;
    
    JLabel mainLabel;
    
    JList medicList;
    JScrollPane medicScroll;
    
    JLabel yearLabel;
    JTextField yearTextField;
    JLabel monthLabel;
    JTextField monthTextField;
    JLabel dayLabel;
    JTextField dayTextField;
    
    JButton finishButton;
    
    CreateAppointmentFrame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Medisafe");

        mainLabel = new JLabel();
        mainLabel.setLayout(null);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(28, 30, 33));
        mainLabel.setPreferredSize(new Dimension(500, 300));

        
        medicList = new JList();
        medicList.setOpaque(true);
        medicList.setBackground(new Color(36, 37, 38));
        medicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        medicScroll = new JScrollPane(medicList);
        medicScroll.setBounds(15, 15, 285, 270);
        
        yearLabel = new JLabel("Year: ");
        yearLabel.setForeground(Color.white);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        yearLabel.setBounds(315, 15, 400, 15);
        
        yearTextField = new JTextField();
        yearTextField.setBounds(315, 45, 150, 30);

        monthLabel = new JLabel("Month: ");
        monthLabel.setForeground(Color.white);
        monthLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        monthLabel.setBounds(315, 90, 400, 15);

        monthTextField = new JTextField();
        monthTextField.setBounds(315, 120, 150, 30);

        dayLabel = new JLabel("Day: ");
        dayLabel.setForeground(Color.white);
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dayLabel.setBounds(315, 165, 400, 15);

        dayTextField = new JTextField();
        dayTextField.setBounds(315, 195, 150, 30);

        finishButton = new JButton();
        finishButton.setText("Create");
        finishButton.setBackground(new Color(204, 44, 44));
        finishButton.setForeground(Color.white);
        finishButton.setFont(new Font("Arial", Font.BOLD, 16));
        finishButton.setBounds(315, 250, 150, 35);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MedicPatientList.getCurrentPatient().createAppointment(MedicPatientList.getMedicVector()[medicList.getSelectedIndex()], Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
                } catch (DateException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        mainLabel.add(medicScroll);
        mainLabel.add(yearLabel);
        mainLabel.add(yearTextField);
        mainLabel.add(monthLabel);
        mainLabel.add(monthTextField);
        mainLabel.add(dayTextField);
        mainLabel.add(dayLabel);
        mainLabel.add(finishButton);
        
        this.add(mainLabel);
        
        this.pack();
        this.setVisible(true);
    }
}
