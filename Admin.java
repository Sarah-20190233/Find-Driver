package software2;

import java.util.ArrayList;

public class Admin {
    
    private User user ;
    //Driver driver;
    private boolean isVerified = false;
    
    ArrayList<String> drivers = new ArrayList<String>();
    ArrayList<String> customers = new ArrayList<String>();
    ArrayList<User> pendings = new ArrayList<User>();
           
    public Admin()
    {
        if(isVerified)
        {
            pendings.add(user);
        }
    }
    
    public void Verify(String user_name)
    {
        drivers.add(user_name);
        isVerified = true;  
              
    }

    public void Suspend_drivers(String user_name)
    {
        boolean status = false;
    
        drivers.remove(user_name);
        status = true;
    
    }
    
    public void Suspend_customers(String user_name)
    {
        boolean status = false;
    
        customers.remove(user_name);
        status = true;
    
    }
          
    
    public ArrayList<User> list_Pendings()
    {
        if(pendings.isEmpty())
        {
            System.out.println("there's no pending drivers");
        }
        else
        {
            System.out.println("pending drivers are : ");
        }
        return pendings;
        
    }
    
    public ArrayList<String> list_drivers()
    {
        return drivers; 
    }
     
    
    
}
