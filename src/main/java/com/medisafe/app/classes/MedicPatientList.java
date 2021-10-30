package com.medisafe.app.classes;

public abstract class MedicPatientList
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    private static Patient patientVector[] = new Patient[256];
    private static Medic medicVector[] = new Medic[256];
    
    //methods
    public void addPatient(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        patientVector[patientVector.length] = new Patient(id, username, email, fname, lname, password, medic);
    }
    
    public void addPatient(int id, String username, String email, String password)
    {
        patientVector[patientVector.length] = new Patient(id, username, email, password);
    }
    
    public void addMedic(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        medicVector[medicVector.length] = new Medic(id, username, email, fname, lname, password, medic);
    }
    
    public void addMedic(int id, String username, String email, String password)
    {
        medicVector[medicVector.length] = new Medic(id, username, email, password);
    }
}
