package com.medisafe.app.classes;

public class CurrentAccount
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    private Patient patient = null;
    private Medic medic = null;
    private int index = -1;
    
    private static CurrentAccount instance = null;
    
    //constructors
    private CurrentAccount(Patient patient)
    {
        this.patient = patient;
    }
    
    private CurrentAccount(Medic medic)
    {
        this.medic = medic;
    }
    
    //methods
    public static CurrentAccount getInstance(Patient patient)
    {
        if(instance == null)
            instance = new CurrentAccount(patient);
        return instance;
    }

    public static CurrentAccount getInstance(Medic medic)
    {
        if(instance == null)
            instance = new CurrentAccount(medic);
        return instance;
    }
}
