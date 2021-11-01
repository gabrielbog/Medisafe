package com.medisafe.app.classes;

import com.medisafe.app.classes.MedicPatientList;

import com.medisafe.app.gui.login.LogInFrame;
import com.medisafe.app.gui.signup.SignUpFrame;
import com.medisafe.app.gui.user.UserFrame;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application 
{
    /**
     * Life cycle
     */
    public Application()
    {
        this.connection = MySQL.createConnection("jdbc:mysql://localhost:3306/medisafe", "root", "");
    }

    /**
     * Public methods
     */
    
    public void display_users() throws SQLException 
    {
        Statement statement = this.connection.getConn().createStatement();
        ResultSet users = statement.executeQuery("SELECT * FROM users");
        
        System.out.println("User table:");
        
        while (users.next())
        {
            System.out.println (
                users.getInt("id") + " " + users.getString("username") + " " +
                users.getString("email") + " " + users.getString("password") + " " +  users.getBoolean("medic")
            );
        }
    }
    
    public static void insert_user(String username, String email, String password) throws SQLException 
    {
        Statement statement = connection.getConn().createStatement();
        statement.executeUpdate("INSERT INTO `users` (`id`, `username`, `email`, `fname`, `lname`, `password`, `medic`) VALUES (NULL, '"+ username +"', '"+ email +"', NULL, NULL, '"+ password +"', '0')");
        
        /*
        MedicPatientList.addPatient(id, username, email, password);
        */
    }
    
    public static void insert_appointments(int mid, int uid, int day, int mounth, int year) throws SQLException 
    {
        Statement statement = connection.getConn().createStatement();
        statement.executeUpdate("INSERT INTO `appointments` (`id`, `mid`, `uid`, `day`, `mounth`, `year`) VALUES (NULL, '" + mid+ "', '"+ uid +"', '" + day + "', '" + mounth + "', '" + year + "');");
    }
    
    public static void load_appointments() throws SQLException 
    {
        Statement statement = connection.getConn().createStatement();
        ResultSet appointments = statement.executeQuery("SELECT * FROM appointments");
        
        while (appointments.next())
        {
            int id     = appointments.getInt("id");
            int mid    = appointments.getInt("mid");
            int uid    = appointments.getInt("uid");
            int day    = appointments.getInt("day");
            int mounth = appointments.getInt("mounth");
            int year   = appointments.getInt("year");
            
            System.out.println(id + " " + mid + " " + uid + " " + day + " " + mounth + " " + year);
            
            // Insert in vector
        }
    }
    
    public void load_users() throws SQLException
    {
        Statement statement = this.connection.getConn().createStatement();
        ResultSet users = statement.executeQuery("SELECT * FROM users");

        while (users.next())
        {
            int patientIndex = 0;
            int medicIndex = 0;
            
            int id = users.getInt("id");
            String username = users.getString("username");
            String email = users.getString("email");
            String fname = users.getString("fname");
            String lname = users.getString("lname");
            String password = users.getString("password");
            boolean medic = users.getBoolean("medic");
            
            if(medic == false)
            {
                MedicPatientList.addPatient(id, username, email, fname, lname, password, medic);
                statement = this.connection.getConn().createStatement();
                ResultSet appointments = statement.executeQuery("SELECT * FROM appointments");

                while (appointments.next())
                {
                    int appointmentsId     = appointments.getInt("id");
                    int mid    = appointments.getInt("mid");
                    int uid    = appointments.getInt("uid");
                    int day    = appointments.getInt("day");
                    int mounth = appointments.getInt("mounth");
                    int year   = appointments.getInt("year");

                    if(uid == id)
                    {
                        //System.out.println(MedicPatientList.getPatientElement(patientIndex));
                            
                        Appointment tmp = new Appointment(uid, mid, day, mounth, year);
                        MedicPatientList.getPatientElement(patientIndex).getAppointments().add(tmp);
                    }
                    
                    System.out.println(patientIndex);
                }
                
                patientIndex++;
            }
            
            else
            {
                MedicPatientList.addMedic(id, username, email, fname, lname, password, medic);
                statement = this.connection.getConn().createStatement();
                ResultSet appointments = statement.executeQuery("SELECT * FROM appointments");

                while (appointments.next())
                {
                    int appointmentsId     = appointments.getInt("id");
                    int mid    = appointments.getInt("mid");
                    int uid    = appointments.getInt("uid");
                    int day    = appointments.getInt("day");
                    int mounth = appointments.getInt("mounth");
                    int year   = appointments.getInt("year");
                    
                    if(uid == id)
                    {
                        //System.out.println(MedicPatientList.getMedicElement(medicIndex));
                        
                        //medic's own appointments
                        Appointment tmp = new Appointment(uid, mid, day, mounth, year);
                        MedicPatientList.getMedicElement(medicIndex).getAppointments().add(tmp);
                    }
                    if(mid == id)
                    {
                        //System.out.println(MedicPatientList.getMedicElement(medicIndex));
                        
                        //appointments created by other patients with the same medic
                        Appointment tmp = new Appointment(uid, mid, day, mounth, year);
                        MedicPatientList.getMedicElement(medicIndex).getPatientAppointments().add(tmp);
                    }
                    
                    System.out.println(medicIndex);
                }
                
                medicIndex++;
            }
        }
        
        System.out.println("Database loaded!");
        //MedicPatientList.patientShow();
        //MedicPatientList.medicShow();
    }
    
    /**
     * Main loop
     */
    public void run() throws SQLException 
    {
        this.load_users();
        this.display_users();
        // this.insert_user("Test", "Test", "Test");
        LogInFrame.logInFrame = new LogInFrame();
        //SignUpFrame.signUpFrame = new SignUpFrame();
        //UserFrame.userFrame = new UserFrame();
        //insert_appointments(1, 4, 1, 1, 2001);
        //load_appointments();
    }

    /**
     * Private properties
     */
    private static MySQL connection; // Used to create a connection to MariaDB
}
