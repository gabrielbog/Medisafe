package com.medisafe.app.classes;

public class User
{
    //Author: Bogoslov Ion-Gabriel
    
    //variables
    private int id;
    private String username;
    private String email;
    
    private String fname = null;
    private String lname = null;
    private String password;
    private boolean medic = false;
    
    //constructors
    public User(int id, String username, String email, String fname, String lname, String password, boolean medic)
    {
        //used for loading the database in an object
        
        this.id = id;
        this.username = username;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.medic = medic;
    }
    
    public User(int id, String username, String email, String password)
    {
        //used when creating a new account

        this.id = id; //it should load the last id everytime
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //get, set, toString, equals methods
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isMedic()
    {
        return medic;
    }

    public void setMedic(boolean medic)
    {
        this.medic = medic;
    }

    @Override
    public String toString()
    {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", fname='" + fname + '\'' +
            ", lname='" + lname + '\'' +
            ", password='" + password + '\'' +
            ", medic=" + medic +
            '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof User)
        {
            User tmp = (User)o;
            if(tmp.getId() != id || !tmp.getUsername().equals(username) || !tmp.getEmail().equals(email)
                || !tmp.getFname().equals(fname) || !tmp.getLname().equals(lname) || !tmp.getPassword().equals(password)
                || tmp.isMedic() != medic)
                return false;
            return true;
        }
        return false;
    }
}
