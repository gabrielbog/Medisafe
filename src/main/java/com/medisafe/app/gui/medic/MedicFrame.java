package com.medisafe.app.gui.medic;

import com.medisafe.app.classes.MedicPatientList;
import com.medisafe.app.gui.user.CreateAppointmentLabel;
import com.medisafe.app.gui.user.UserFrame;
import com.medisafe.app.gui.user.UserInfoFrame;
import com.medisafe.app.threads.HourThread;
import com.medisafe.app.threads.TimerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicFrame extends JFrame {
    public static MedicFrame medicFrame;

    JLabel medicLabel;

    JLabel topLabel;

    JLabel titleLabel;
    MedicInfoLabel medicInfoLabel;
    
    JLabel text1Label;
    public static JList appointmentsList;
    JScrollPane appointmentsScroll;

    CreateMedicAppointmentLabel createAppointmentLabel;

    JLabel text2Label;
    JLabel feedLabel;
    
    JLabel text3Label;
    public static JList patientAppointmentsList;
    JScrollPane patientAppointmentsScroll;

    private static JLabel timerLabel;
    private static JLabel hourLabel;

    public MedicFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Medisafe");
        this.setResizable(false);

        medicLabel = new JLabel();
        medicLabel.setLayout(null);
        medicLabel.setOpaque(true);
        medicLabel.setBackground(new Color(28, 30, 33));
        medicLabel.setPreferredSize(new Dimension(1245, 750));

        topLabel = new JLabel();
        topLabel.setBounds(0, 0, 1245, 50);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(36, 37, 38));

        titleLabel = new JLabel("MEDISAFE");
        titleLabel.setForeground(new Color(204, 44, 44));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(15, 15, 320, 20);

        medicInfoLabel = new MedicInfoLabel();

        topLabel.add(titleLabel);
        topLabel.add(medicInfoLabel);

        text1Label = new JLabel("My Appointments");
        text1Label.setForeground(Color.white);
        text1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        text1Label.setBounds(15, 125, 400, 15);
        
        appointmentsList = new JList(MedicPatientList.getCurrentMedic().getAppointments().toArray());
        appointmentsList.setOpaque(true);
        appointmentsList.setBackground(new Color(36, 37, 38));
        appointmentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentsList.setForeground(Color.WHITE);

        appointmentsScroll = new JScrollPane(appointmentsList);
        appointmentsScroll.setBounds(15, 145, 400, 340);

        createAppointmentLabel = new CreateMedicAppointmentLabel();

        text2Label = new JLabel("Feed");
        text2Label.setForeground(Color.white);
        text2Label.setFont(new Font("Arial", Font.PLAIN, 18));
        text2Label.setBounds(430, 220, 800, 15);

        feedLabel = new JLabel();
        feedLabel.setOpaque(true);
        feedLabel.setBackground(new Color(36, 37, 38));
        feedLabel.setBounds(430, 240, 800, 245);

        text3Label = new JLabel("Patient appointments");
        text3Label.setForeground(Color.white);
        text3Label.setFont(new Font("Arial", Font.PLAIN, 18));
        text3Label.setBounds(15, 505, 800, 15);

        patientAppointmentsList = new JList(MedicPatientList.getCurrentMedic().getPatientAppointments().toArray());
        patientAppointmentsList.setOpaque(true);
        patientAppointmentsList.setBackground(new Color(36, 37, 38));
        patientAppointmentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patientAppointmentsList.setForeground(Color.WHITE);

        patientAppointmentsScroll = new JScrollPane(patientAppointmentsList);
        patientAppointmentsScroll.setBounds(15, 525, 1210, 185);

        timerLabel = new JLabel();
        timerLabel.setForeground(Color.white);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        timerLabel.setBounds(15, 730, 800, 15);

        hourLabel = new JLabel();
        hourLabel.setForeground(Color.white);
        hourLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        hourLabel.setBounds(155, 730, 800, 15);

        HourThread hourThread = new HourThread(hourLabel);
        TimerThread timerThread = new TimerThread(timerLabel);

        hourThread.start();
        timerThread.start();

        medicLabel.add(topLabel);
        medicLabel.add(text1Label);
        medicLabel.add(appointmentsScroll);
        medicLabel.add(createAppointmentLabel);
        medicLabel.add(text2Label);
        medicLabel.add(feedLabel);
        medicLabel.add(text3Label);
        medicLabel.add(patientAppointmentsScroll);
        medicLabel.add(timerLabel);
        medicLabel.add(hourLabel);

        System.out.println();

        this.add(medicLabel);
        this.pack();
        this.setVisible(true);
    }
}
