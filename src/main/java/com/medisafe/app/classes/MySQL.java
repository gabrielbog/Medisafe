package com.medisafe.app.classes;

import java.sql.*;

public class MySQL
{
    /**
     * Class constructor
     * @param DB_PATH DB Path     - Path to MySQL Database
     * @param DB_USER DB Username - Database username
     * @param DB_PASS DB Password - Database password
     */
    private MySQL(String DB_PATH, String DB_USER, String DB_PASS)
    {
        this.DB_PATH = DB_PATH;
        this.DB_USER = DB_USER;
        this.DB_PASS = DB_PASS;

        System.out.println("Trying to connect to MySQL database ...");

        try {
            conn = DriverManager.getConnection(this.DB_PATH, this.DB_USER, this.DB_PASS);
            System.out.println("Connection was established with success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create only one connection to the database
     * @param DB_PATH DB Path     - Path to MySQL Database
     * @param DB_USER DB Username - Database username
     * @param DB_PASS DB Password - Database password
     * @return Returns a MySQL object
     */
    public static MySQL createConnection(String DB_PATH, String DB_USER, String DB_PASS)
    {
        if (MySQL.connection == null)
        {
            MySQL.connection = new MySQL(DB_PATH, DB_USER, DB_PASS);
        }

        return MySQL.connection;
    }

    /**
     * Public methods
     */
    /**
     * Get access to the private property conn
     * @return Return an object
     */
    public Connection getConn()
    {
        return this.conn;
    }

    /**
     * Private properties
     */
    private String DB_PATH;
    private String DB_USER;
    private String DB_PASS;

    private static MySQL connection = null;
    private Connection conn;
}