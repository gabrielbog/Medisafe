package com.medisafe.app.classes;

import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.MedicException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Medic extends User
{
    //Author: Bogoslov Ion-Gabriel

    //variables
    private Appointment appointments[] = new Appointment[256];

    //constructors
    public Medic(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        //used for loading the database in an object

        super(id, username, email, fname, lname, password, medic);
    }

    public Medic(int id, String username, String email, String password)
    {
        //used when creating a new account

        super(id, username, email, password);
    }
    
    //get, set, toString, equals
    public Appointment[] getAppointments()
    {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments)
    {
        this.appointments = appointments;
    }

    @Override
    public String toString()
    {
        return "Medic{" +
            "id=" + getId() +
            ", username='" + getUsername() + '\'' +
            ", email='" + getEmail() + '\'' +
            ", fname='" + getFname() + '\'' +
            ", lname='" + getLname() + '\'' +
            ", password='" + getPassword() + '\'' +
            ", medic=" + isMedic() +
            "appointments=" + Arrays.toString(appointments) +
            '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Medic)
        {
            Medic tmp = (Medic)o;
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
    public int createAppointment(Medic selection, int year, int day, int month) throws DateException, MedicException
    {
        Calendar date = new GregorianCalendar();
        date.set(year, day, month);

        Appointment list[] = selection.getAppointments();
        
        //check if medic makes appointment with himself
        if(equals(selection))
            throw new MedicException();

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

        //check if selected date is weekend
        if(date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            return 0;

        //check if medic has no set appointment for that date
        for(int i = 0; i < list.length; ++i)
        {
            if(list[i].getDay() == day && list[i].getMonth() == month)
            {
                return 0;
            }
        }

        //create appointment if medic is free
        list[list.length] = new Appointment(getId(), selection.getId(), year, month, day);
        selection.setAppointments(list);

        //set the appointment for the patient aswell
        appointments[appointments.length] = list[list.length - 1];

        return 1;
    }
    
    public void verifyAppointment(int i)
    {
        //deletes appointment
        for(int j = i; j < appointments.length; ++j)
        {
            appointments[j] = appointments[j + 1];
        }
    }
}
