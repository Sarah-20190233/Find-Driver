package software2;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver implements User {
    String userName;
    String email;
    String password;
    String phone;
    String nationalid;
    String license;
    Ride ride = new Ride();
    Ride ride2 = new Ride();
    ArrayList<String> favouriteArea=new ArrayList<String>();
    ArrayList<Integer> Driver_Ratings=new ArrayList<Integer>();
    ArrayList<Driver> list_drivers = new ArrayList<Driver>();

    public Driver()
    {
        
    }
    
    public Driver(String name, String license)
    {
        this.userName = name;
        this.license=license;
    }
    
    public void Register(String name, String email, String password, String phone) {
        this.userName = name;
        this.email=email;
        this.phone = phone;
        this.password = password;
        this.license=license;
        this.nationalid=nationalid;
    }
    public void Login(String email,String password)
    {
        this.email=email;
        this.password= password;
    }
    
    public void add_driver(Driver driver)
    {
        list_drivers.add(driver);
    }

    public String get_name()
    {
        return userName;
    }
    public void add_favourite_area(String fav)   
    {
        favouriteArea.add(fav);

    }
    public ArrayList<String> get_favourite_area()
    {
        return favouriteArea;
    }
    
    public String get_liecence()
    {
        return license;
    }
   
              
    public void get_notification(String source) {
     boolean flag = false;
     int count = 0;
  
                    if (favouriteArea.contains(source) );
                    { 
                     System.out.println("Your favourite area has been requested by someone");
                    }   
                    
     }
      public void suggest_price(String source, String destination, double price)
     {
         ride2.setSource(source);
         ride2.setDestination(destination);
         ride2.setPrice(price); 
     }
     
     public String toString()
    {
        return userName + " with license: " + license;
    }
      
     public boolean search(String userName, String password)
    {
        boolean flag = false;
        for (Driver d : list_drivers)
                {   
                    if (this.userName.equals(userName) && this.password.equals(password))
                        flag = true;
                }
        if (flag)
        {
            System.out.println("you are logged in successfully");
            return true;
        }
        else
        {
            System.out.println("you aren't registered to the system");
            return false;
        }
        
    }
     
     public ArrayList<Integer> list_customers_rating_for_this_driver()
     {
         return Driver_Ratings;
     }
    
}

