package com.medisafe.app.classes;

import java.sql.SQLException;

public class EntryPoint
{
    public static void main( String[] args ) throws SQLException 
    {
        Application application = new Application();
        application.run();
    }
}
