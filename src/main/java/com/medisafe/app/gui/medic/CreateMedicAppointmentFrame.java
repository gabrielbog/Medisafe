package com.medisafe.app.gui.medic;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.InvalidMedicException;
import com.medisafe.app.exceptions.MedicException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMedicAppointmentFrame extends JFrame {
    public static CreateMedicAppointmentFrame createAppointmentFrame;
    
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
    
    CreateMedicAppointmentFrame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Medisafe");

        mainLabel = new JLabel();
        mainLabel.setLayout(null);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(28, 30, 33));
        mainLabel.setPreferredSize(new Dimension(500, 300));

        
        medicList = new JList(MedicPatientList.getMedicVector().toArray());
        medicList.setOpaque(true);
        medicList.setBackground(new Color(36, 37, 38));
        medicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicList.setForeground(Color.WHITE);

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
                if(yearTextField.getText().equals("") || monthTextField.getText().equals("") || dayTextField.getText().equals("") || medicList.getSelectedIndex() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please introduce details", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else
                {
                    try
                    {
                        MedicPatientList.getCurrentMedic().createAppointment(MedicPatientList.getMedicElement(medicList.getSelectedIndex()).getId(), Integer.parseInt(yearTextField.getText()), Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()));

                        JOptionPane.showMessageDialog(null, "Appointment successfully created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                        //add appointment in the database

                        createAppointmentFrame.dispose();
                    }
                    catch (DateException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                    catch (InvalidMedicException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Medic", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                    catch (MedicException ex)
                    {
                        JOptionPane.showMessageDialog(null, "You can't create an appointment with yourself", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
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
