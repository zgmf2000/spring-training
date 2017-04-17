package com.mitrais.springtraining;

/**
 * Created by trainee on 17/04/2017.
 */
public class Employee {
    private String name;
    private String gender;

    public Employee() {}

    public Employee(String name, String gender)
    {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
}
