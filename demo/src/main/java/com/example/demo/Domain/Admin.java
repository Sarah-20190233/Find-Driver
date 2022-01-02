package com.example.demo.Domain;

import java.util.ArrayList;
@Entity
@Table(name = "Admin")

public class Admin {

    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )
    private Driver driver = new Driver() ;
    public boolean isVerified = false;
    protected DataBase dataBase = new DataBase();
    private Ride ride = new Ride();
    private String area;

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void add_to_pendings(User user)
    {
        dataBase.pendings.add(user);
    }
    
    public void Verify(Driver driver)
    {
        dataBase.drivers.add(driver.get_name());
        dataBase.pendings.remove(driver.get_password());
        driver.satatus = true;
    }

    public void Suspend_drivers(String user_name)
    {

        dataBase.drivers.remove(user_name);

    }
    
    public void Suspend_customers(String user_name)
{

        dataBase.customers.remove(user_name);

    }
          
    
    public ArrayList<User> list_Pendings()
    {
        if(dataBase.pendings.isEmpty())
        {
            System.out.println("there's no pending drivers");
        }
        else
        {
            System.out.println("pending drivers are : ");
        }
        return dataBase.pendings;
        
    }
    
    public void add_discount_on_specific_area(Ride ride, String destination)          
    {
        ride.setDestination(destination);
    }

}
