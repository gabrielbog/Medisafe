package com.medisafe.app.classes;

import java.util.ArrayList;

public abstract class MedicPatientList
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    
    /*
    private static Patient patientVector[] = new Patient[256];
    private static Medic medicVector[] = new Medic[256];
    */
    
    private static ArrayList<Patient> patientVector = new ArrayList<Patient>();
    private static ArrayList<Medic> medicVector = new ArrayList<Medic>();
    
    private static Patient currentPatient = null;
    private static Medic currentMedic = null;
    
    //get, set
    public static ArrayList<Patient> getPatientVector()
    {
        return patientVector;
    }

    public static void setPatientVector(ArrayList<Patient> patientVector)
    {
        MedicPatientList.patientVector = patientVector;
    }
    
    public static Patient getPatientElement(int i)
    {
        return patientVector.get(i);
    }
    
    public static void setPatientElement(Patient patient, int i)
    {
        MedicPatientList.patientVector.set(i, patient);
    }

    public static ArrayList<Medic> getMedicVector()
    {
        return medicVector;
    }

    public static void setMedicVector(ArrayList<Medic> medicVector)
    {
        MedicPatientList.medicVector = medicVector;
    }

    public static Medic getMedicElement(int i)
    {
        return medicVector.get(i);
    }

    public static void setMedicElement(Medic medic, int i)
    {
        MedicPatientList.medicVector.set(i, medic);
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
        patientVector.add(new Patient(id, username, email, fname, lname, password, medic));
    }
    
    public static void addPatient(int id, String username, String email, String password)
    {
        patientVector.add(new Patient(id, username, email, password));
    }
    
    public static void addMedic(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        medicVector.add(new Medic(id, username, email, fname, lname, password, medic));
    }
    
    public static void addMedic(int id, String username, String email, String password)
    {
        medicVector.add(new Medic(id, username, email, password));
    }
    
    public static int verifyUser(String username, String password)
    {
        for(int i = 0; i < patientVector.size(); ++i)
            if(patientVector.get(i) != null && username.equals(patientVector.get(i).getUsername()) && password.equals(patientVector.get(i).getPassword()))
            {
                currentPatient = patientVector.get(i);
                currentMedic = null;
                return 1;
            }

        for(int i = 0; i < medicVector.size(); ++i)
            if(medicVector.get(i) != null && username.equals(medicVector.get(i).getUsername()) && password.equals(medicVector.get(i).getPassword()))
            {
                currentPatient = null;
                currentMedic = medicVector.get(i);
                return 2;
            }
        
        return 0;
    }
    
    public static int verifyNewUser(String username, String email)
    {
        for(int i = 0; i < patientVector.size(); ++i)
            if(patientVector.get(i) != null && (username.equals(patientVector.get(i).getUsername()) || email.equals(patientVector.get(i).getEmail())))
                return 0;

        for(int i = 0; i < medicVector.size(); ++i)
            if(medicVector.get(i) != null && (username.equals(medicVector.get(i).getUsername()) || email.equals(medicVector.get(i).getEmail())))
                return 0;

        return 1;
    }
    
    public static int getLatestPatientId()
    {
        int latestPatientId = 0;
        
        for(int i = 0; i < patientVector.size(); ++i)
            if(patientVector.get(i) != null)
                latestPatientId = patientVector.get(i).getId();
            
        return latestPatientId;
    }

    public static int getLatestMedicId()
    {
        int latestMedicId = 0;
        
        for(int i = 0; i < medicVector.size(); ++i)
            if(medicVector.get(i) != null)
                latestMedicId = medicVector.get(i).getId();
            
        return latestMedicId;
    }
    
    public static void convertPatientToMedic()
    {
        //convert patient to medic
        currentMedic = new Medic(MedicPatientList.getLatestMedicId(), currentPatient.getUsername(), currentPatient.getEmail(),
                                currentPatient.getFname(), currentPatient.getLname(), currentPatient.getPassword(), true);
        currentMedic.setAppointments(currentPatient.getAppointments()); //dont forget to copy the appointments too
        medicVector.add(currentMedic);
        
        //remove patient from vector
        patientVector.remove(currentPatient);
        currentPatient.setAppointments(null);
        currentPatient = null;
        
        //remove said patient from the database, add the new medic in the database
        //here
    }
    
    //debug stuff
    public static void patientShow()
    {
        for(int i = 0; i < patientVector.size(); ++i)
        {
            if(patientVector.get(i) != null)
            {
                System.out.println(patientVector.get(i).toString());
            }
        }
    }

    public static void medicShow()
    {
        for(int i = 0; i < medicVector.size(); ++i)
        {
            if(medicVector.get(i) != null)
            {
                System.out.println(medicVector.get(i).toString());
            }
        }
    }
}
