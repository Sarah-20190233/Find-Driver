package software2;

import java.util.ArrayList;

public class Driver implements User {
    String userName;
    String email;
    String password;
    String phone;
    String nationalid;
    Ride ride;
    String liecence;
    ArrayList<String> favouriteArea=new ArrayList<String>();
    ArrayList<Integer> Driver_Ratings=new ArrayList<Integer>();
    ArrayList<Driver> list_drivers = new ArrayList<Driver>();

    public void Register(String name, String email, String password, String phone) {
        this.userName = name;
        this.email=email;
        this.phone = phone;
        this.password = password;
        this.liecence=liecence;
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

     public ArrayList<String> addarea(String area)   
    {
        favouriteArea.add(area);
        return favouriteArea;
    }
    public ArrayList<String> favouriteArea(String area)   
    {
        return favouriteArea;
    }
    public String getnotification()
     {
         int n=favouriteArea.size();
         for(int i=0;i<=n;i++){
             if(ride.getDestination()==favouriteArea.get(i))
             {
                 ride.setDestination(favouriteArea.get(i));
             }
         }     
        return null;
     }
      public void setoffer(double price)
     {
       price=price;
              
     }
     
     public void search(String userName, String password)
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
        }
        else
        {
            System.out.println("you aren't registered to the system");
        }
        
    }
     
     public ArrayList<Integer> list_customers_rating_for_this_driver()
     {
         return Driver_Ratings;
     }
    
}


