package com.medisafe.app.gui.medic;

import com.medisafe.app.classes.Appointment;
import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.gui.medic.MedicFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateMedicAppointmentLabel extends JLabel implements MouseListener {
    
    public CreateMedicAppointmentLabel(){
        this.setOpaque(true);
        this.setBackground(new Color(36, 37, 38));
        this.setFont(new Font("Arial", Font.PLAIN, 18));
        this.setForeground(Color.white);
        this.setText("   Create appointment");    
        this.setBounds(430, 145, 800, 50);
        this.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        CreateMedicAppointmentFrame.createAppointmentFrame = new CreateMedicAppointmentFrame();
        CreateMedicAppointmentFrame.createAppointmentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                MedicFrame.appointmentsList.setListData(MedicPatientList.getCurrentMedic().getAppointments().toArray());
                MedicFrame.patientAppointmentsList.setListData(MedicPatientList.getCurrentMedic().getPatientAppointments().toArray());
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
