package com.medisafe.app.gui.user;

import com.medisafe.app.classes.MedicPatientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateAppointmentLabel extends JLabel implements MouseListener {
    
    public CreateAppointmentLabel(){
        this.setOpaque(true);
        this.setBackground(UserFrame.Colors.INNERBACKGROUND);
        this.setFont(new Font("Arial", Font.PLAIN, 18));
        this.setForeground(Color.white);
        this.setText("   Create appointment");    
        this.setBounds(430, 145, 800, 50);
        this.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        CreateAppointmentFrame.createAppointmentFrame = new CreateAppointmentFrame();
        CreateAppointmentFrame.createAppointmentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                UserFrame.appointmentsList.setListData(MedicPatientList.getCurrentPatient().getAppointments().toArray());
            }
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
