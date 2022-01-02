package com.example.demo.Domain;

@Entity
@Table(name = "Driver")

public class Driver implements User {
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String nationalid;
    private String license;
    private Ride ride = new Ride();
    private Ride ride2 = new Ride();
    private DataBase dataBase = new DataBase();

   @GeneratedValue(
           strategy= GenerationType.IDENTITY
   )

    public boolean satatus = false;
    
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
    public void Login(String userName,String password)
    {
        this.userName=userName;
        this.password= password;
    }
    
    public void set_name(String name)
    {
        this.userName = userName;
    }
    
    public String get_name()
    {
        return this.userName;
    }

    public void set_password(String password)
    {
        this.password = password;
    }

    public String get_password()
    {
        return this.password;
    }
    
    public String get_liecence()
    {
        return this.license;
    }
    
    public void add_favourite_area(String fav)
    {
        dataBase.favouriteArea.add(fav);
    }
              
    public void get_notification(String source) {
     boolean flag = false;
     int count = 0;
  
                    if (dataBase.favouriteArea.contains(source) );
                    { 
                     System.out.println("Your favourite area has been requested by someone");
                    }   
                    
     }
      public void suggest_price(Ride ride, String source, String destination, double price)
     {
         ride.setSource(source);
         ride.setDestination(destination);
         ride.setPrice(price); 
         //ride2.setPrice(price);
         
     }
     
     public String toString()
    {
        return userName + " with license: " + license;
    }
         
     /*public ArrayList<Integer> list_customers_rating_for_this_driver()
     {
         return dataBase.Driver_Ratings;
     }*/
    
}

