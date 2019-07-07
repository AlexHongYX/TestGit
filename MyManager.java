package com.fehead.pair3;

public class MyManager extends MyEmployee
{
    private double bonus;

    public MyManager()
    {
        super();
        bonus = 0;
    }
    public MyManager(String name,double salary,int year,int month,int day)
    {
        super(name,salary,year,month,day);
        bonus = 0;
    }

    public double getBonus()
    {
        return bonus;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary+bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }

    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject))
        {
            return false;
        }
        MyManager other = (MyManager)otherObject;
        //super.equals checked that this and other belong to the same class
        return bonus == other.bonus;
    }

    public int hashCode()
    {
        return super.hashCode() + 17*new Double(bonus).hashCode();
    }

    public String toString()
    {
        return super.toString() + "[bonus=" + bonus +"]";
    }
}
