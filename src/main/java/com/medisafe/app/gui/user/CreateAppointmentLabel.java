package com.medisafe.app.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateAppointmentLabel extends JLabel implements MouseListener {
    
    CreateAppointmentLabel(){
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
        System.out.println("Create appointment");
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
