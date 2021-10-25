package com.medisafe.app.classes;

public class Application {
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
    public void run()
    {
        System.out.println("Hello world!");
    }

    /**
     * Private properties
     */
    private MySQL connection; // Used to create a connection to MariaDB
}
