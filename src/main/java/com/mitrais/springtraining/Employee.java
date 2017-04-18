package com.mitrais.springtraining;

/**
 * Created by trainee on 17/04/2017.
 */
public class Employee {
    private String name;
    private String gender;
    private int id;

    public Employee() {}

    public Employee(int id, String name, String gender)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

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
