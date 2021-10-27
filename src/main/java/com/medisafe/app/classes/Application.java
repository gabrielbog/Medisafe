package com.medisafe.app.classes;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
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
    
    public void insert_user(String username, String email, String password) throws SQLException 
    {
        Statement statement = this.connection.getConn().createStatement();
        statement.executeUpdate("INSERT INTO `users` (`id`, `username`, `email`, `fname`, `lname`, `password`, `medic`) VALUES (NULL, '"+ username +"', '"+ email +"', NULL, NULL, '"+ password +"', '0')");
    }
    
    /**
     * Main loop
     */
    public void run() throws SQLException 
    {
        this.display_users();
        // this.insert_user("Test", "Test", "Test");
    }

    /**
     * Private properties
     */
    private MySQL connection; // Used to create a connection to MariaDB
}
