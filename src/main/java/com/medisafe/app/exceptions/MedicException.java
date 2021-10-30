package com.medisafe.app.exceptions;

public class MedicException extends Exception
{
    public MedicException()
    {
        System.out.println("Cannot make appointment for the same medic");
    }
}
