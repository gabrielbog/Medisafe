package com.medisafe.app.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserInfoLabel extends JLabel implements MouseListener {
    UserInfoLabel(){
        //ImageIcon userLogo = new ImageIcon(getClass().getResource("/userlogo.jpg"));
        //this.setIcon(userLogo);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setBounds(1200, 10, 30, 30);
        this.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click test");
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
