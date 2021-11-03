package com.medisafe.app.gui.user;

import com.medisafe.app.classes.Medic;
import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserInfoLabel extends JLabel implements MouseListener {
    UserInfoLabel(){
        this.setText("!");
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 32));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setBounds(1200, 10, 30, 30);
        this.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("test");
        UserInfoFrame.userInfoFrame = new UserInfoFrame();
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
