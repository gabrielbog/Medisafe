package com.medisafe.app.interfaces;

import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.InvalidMedicException;

public interface IPatient
{
    public abstract void createAppointment(int mid, int year, int day, int month) throws DateException, InvalidMedicException;
}
