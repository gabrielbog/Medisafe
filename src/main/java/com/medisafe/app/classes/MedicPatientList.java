package com.medisafe.app.classes;

public abstract class MedicPatientList
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    private static Patient patientVector[] = new Patient[256];
    private static Medic medicVector[] = new Medic[256];
    
    private static int patientIndex = 0;
    private static int medicIndex = 0;
    
    private static Patient currentPatient = null;
    private static Medic currentMedic = null;
    
    //get, set
    public static Patient[] getPatientVector()
    {
        return patientVector;
    }

    public static void setPatientVector(Patient[] patientVector)
    {
        MedicPatientList.patientVector = patientVector;
    }

    public static Medic[] getMedicVector()
    {
        return medicVector;
    }

    public static void setMedicVector(Medic[] medicVector)
    {
        MedicPatientList.medicVector = medicVector;
    }

    public static int getPatientIndex()
    {
        return patientIndex;
    }

    public static void setPatientIndex(int patientIndex)
    {
        MedicPatientList.patientIndex = patientIndex;
    }

    public static int getMedicIndex()
    {
        return medicIndex;
    }

    public static void setMedicIndex(int medicIndex){
        
        MedicPatientList.medicIndex = medicIndex;
    }

    public static Patient getCurrentPatient()
    {
        return currentPatient;
    }

    public static void setCurrentPatient(Patient currentPatient)
    {
        MedicPatientList.currentPatient = currentPatient;
    }

    public static Medic getCurrentMedic()
    {
        return currentMedic;
    }

    public static void setCurrentMedic(Medic currentMedic)
    {
        MedicPatientList.currentMedic = currentMedic;
    }

    //other methods
    public static void addPatient(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        patientVector[patientIndex] = new Patient(id, username, email, fname, lname, password, medic);
        patientIndex++;
    }
    
    public static void addPatient(int id, String username, String email, String password)
    {
        patientVector[patientIndex] = new Patient(id, username, email, password);
        patientIndex++;
    }
    
    public static void addMedic(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        medicVector[medicIndex] = new Medic(id, username, email, fname, lname, password, medic);
        medicIndex++;
    }
    
    public static void addMedic(int id, String username, String email, String password)
    {
        medicVector[medicIndex] = new Medic(id, username, email, password);
        medicIndex++;
    }
    
    public static int verifyUser(String username, String password)
    {
        for(int i = 0; i < patientVector.length; ++i)
            if(patientVector[i] != null && username.equals(patientVector[i].getUsername()) && password.equals(patientVector[i].getPassword()))
            {
                currentPatient = patientVector[i];
                currentMedic = null;
                return 1;
            }

        for(int i = 0; i < medicVector.length; ++i)
            if(medicVector[i] != null && username.equals(medicVector[i].getUsername()) && password.equals(medicVector[i].getPassword()))
            {
                currentPatient = null;
                currentMedic = medicVector[i];
                return 2;
            }
            
        return 0;
    }
    
    public static int verifyNewUser(String username, String email)
    {
        for(int i = 0; i < patientVector.length; ++i)
            if(patientVector[i] != null && (username.equals(patientVector[i].getUsername()) || email.equals(patientVector[i].getEmail())))
                return 0;

        for(int i = 0; i < medicVector.length; ++i)
            if(medicVector[i] != null && (username.equals(medicVector[i].getUsername()) || email.equals(medicVector[i].getEmail())))
                return 0;

        return 1;
    }
    
    public static int getLatestPatientId()
    {
        int latestPatientId = 0;
        
        for(int i = 0; i < patientVector.length; ++i)
            if(patientVector[i] != null)
                latestPatientId = patientVector[i].getId();
            
        return latestPatientId;
    }

    public static int getLatestMedicId()
    {
        int latestMedicId = 0;
        
        for(int i = 0; i < medicVector.length; ++i)
            if(medicVector[i] != null)
                latestMedicId = medicVector[i].getId();
            
        return latestMedicId;
    }
    
    //debug stuff
    public static void patientShow()
    {
        for(int i = 0; i < patientVector.length; ++i)
        {
            if(patientVector[i] != null)
            {
                System.out.println(patientVector[i].toString());
            }
        }
    }

    public static void medicShow()
    {
        for(int i = 0; i < medicVector.length; ++i)
        {
            if(medicVector[i] != null)
            {
                System.out.println(medicVector[i].toString());
            }
        }
    }
}
