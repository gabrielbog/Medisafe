package com.medisafe.app.interfaces;

import com.medisafe.app.exceptions.DateException;
import com.medisafe.app.exceptions.InvalidMedicException;
import com.medisafe.app.exceptions.MedicException;

public interface IMedic
{
    public abstract void createAppointment(int mid, int year, int day, int month) throws DateException, MedicException, InvalidMedicException;
    public abstract void removeAppointment(int i);
}
