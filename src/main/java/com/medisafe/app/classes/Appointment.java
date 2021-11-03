package com.medisafe.app.classes;

public class Appointment
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    private int idPatient;
    private int idMedic;
    private int day;
    private int month;
    private int year;
    
    //constructors
    public Appointment(int idPatient, int idMedic, int year, int month, int day)
    {
        this.idPatient = idPatient;
        this.idMedic = idMedic;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //get, set, toString, equals methods
    public int getIdPatient()
    {
        return idPatient;
    }

    public void setIdPatient(int idPatient)
    {
        this.idPatient = idPatient;
    }

    public int getIdMedic()
    {
        return idMedic;
    }

    public void setIdMedic(int idMedic)
    {
        this.idMedic = idMedic;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "idPatient=" + idPatient +
            ", idMedic=" + idMedic +
            ", day=" + day +
            ", month=" + month +
            ", year=" + year +
            '}';
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Appointment)
        {
            Appointment tmp = (Appointment)o;
            if(tmp.getIdPatient() != idPatient || tmp.getIdMedic() != idMedic || tmp.getDay() != day || tmp.getMonth() != month
            || tmp.getYear() != year)
                return false;
            return true;
        }
        return false;
    }
}
