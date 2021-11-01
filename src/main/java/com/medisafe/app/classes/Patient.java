package com.medisafe.app.classes;

import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.MedicException;
import com.medisafe.app.exceptions.InvalidMedicException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Patient extends User
{
    //Author: Bogoslov Ion-Gabriel

    //variables
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    
    //constructors
    public Patient(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        //used for loading the database in an object

        super(id, username, email, fname, lname, password, medic);
    }

    public Patient(int id, String username, String email, String password)
    {
        //used when creating a new account

        super(id, username, email, password);
    }
    
    //get, set, toString, equals
    public ArrayList<Appointment> getAppointments()
    {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments)
    {
        this.appointments = appointments;
    }
    
    public Appointment getAppointmentElement(int i)
    {
        return appointments.get(i);
    }
    
    public void setAppointmentElement(Appointment appointment, int i)
    {
        appointments.set(i, appointment);
    }

    @Override
    public String toString()
    {
        return "Patient{" +
            "username='" + getUsername() + '\'' +
            ", email='" + getEmail() + '\'' +
            ", fname='" + getFname() + '\'' +
            ", lname='" + getLname() + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Patient)
        {
            Patient tmp = (Patient)o;
            if(tmp.getId() != getId() || !tmp.getUsername().equals(getUsername()) || !tmp.getEmail().equals(getEmail())
                || !tmp.getFname().equals(getFname()) || !tmp.getLname().equals(getLname()) || !tmp.getPassword().equals(getPassword())
                || tmp.isMedic() != isMedic()
                || tmp.getAppointments() == appointments)
                return false;
            return true;
        }
        return false;
    }

    //other methods
    public void createAppointment(int mid, int year, int day, int month) throws DateException, InvalidMedicException
    {
        Medic selection = null;
        boolean ok = false;
        
        //check if medic id is valid
        for(int i = 0; i < MedicPatientList.getMedicVector().size(); ++i)
            if(mid == MedicPatientList.getMedicElement(i).getId())
            {
                ok = true;
                selection = MedicPatientList.getMedicElement(i);
                break;
            }
        
        if(!ok)
            throw new InvalidMedicException();
        
        Calendar date = new GregorianCalendar();
        date.set(year, day, month);
        
        ArrayList<Appointment> list = selection.getPatientAppointments();
        
        //check if date is actually valid
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            if(day < 0 || day > 31)
                throw new DateException();
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            if(day < 0 || day > 30)
                throw new DateException();
        }
        else if(month == 2)
        {
            if((year % 4 == 0 && year % 100 != 0) && (day < 0 || day > 29))
                throw new DateException();
            else if(year % 400 == 0 && (day < 0 || day > 29))
                throw new DateException();
            else if(day < 0 || day > 28)
                throw new DateException();
        }
        else
            throw new DateException();
        
        //check if medic has no set appointment for that date
        for(int i = 0; i < list.size(); ++i)
        {
            if(list.get(i).getDay() == day && list.get(i).getMonth() == month)
            {
                throw new DateException();
            }
        }
        
        //create appointment if medic is free, set it in his patient appointment list
        list.add(new Appointment(getId(), selection.getId(), year, month, day));
        selection.setAppointments(list);
        
        //set the appointment for the patient aswell
        appointments.add(list.get(list.size() - 1));
    }
}
