package com.medisafe.app.classes;

import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.InvalidMedicException;
import com.medisafe.app.exceptions.MedicException;
import com.medisafe.app.interfaces.IMedic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Medic extends User implements IMedic
{
    //Author: Bogoslov Ion-Gabriel

    //variables
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    private ArrayList<Appointment> patientAppointments = new ArrayList<Appointment>();

    //notificarile ar trebui sa fie aici eventual
    //private LinkedBlockingQueue<String> notifications = new LinkedBlockingQueue<String>();

    //constructors
    public Medic(int id, String username, String email, String fname, String lname, boolean medic)
    {
        //used for loading the database in an object

        super(id, username, email, fname, lname, medic);
    }

    public Medic(int id, String username, String email)
    {
        //used when creating a new account

        super(id, username, email);
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

    // ------------------------------------------- //
    
    public ArrayList<Appointment> getPatientAppointments()
    {
        return patientAppointments;
    }

    public void setPatientAppointments(ArrayList<Appointment> patientAppointments)
    {
        this.patientAppointments = patientAppointments;
    }

    public Appointment getPatientAppointmentElement(int i)
    {
        return patientAppointments.get(i);
    }

    public void setPatientAppointmentElement(Appointment appointment, int i)
    {
        patientAppointments.set(i, appointment);
    }
    
    @Override
    public String toString()
    {
        return "id=" + getId() +
            ", username ='" + getUsername() +'\'' +
            ", fname='" + getFname() + '\'' +
            ", lname='" + getLname() + '\'' +
            ", email='" + getEmail();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Medic)
        {
            Medic tmp = (Medic)o;
            if(tmp.getId() != getId() || !tmp.getUsername().equals(getUsername()) || !tmp.getEmail().equals(getEmail())
                || !tmp.getFname().equals(getFname()) || !tmp.getLname().equals(getLname()) || tmp.isMedic() != isMedic()
                || tmp.getAppointments() == appointments)
                return false;
            return true;
        }
        return false;
    }
    
    //other methods
    public void createAppointment(int mid, int year, int day, int month) throws DateException, MedicException, InvalidMedicException
    {
        Medic selection = null;
        boolean ok = false;

        //check if medic makes appointment with himself
        if(mid == getId())
            throw new MedicException();

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
    
    public void removeAppointment(int i)
    {
        patientAppointments.remove(i);
    }
}
