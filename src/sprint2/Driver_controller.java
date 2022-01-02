package sprint2;

import java.util.ArrayList;

public class Driver_controller {
    
    private Driver driver = new Driver();
    private DataBase dataBase = new DataBase();
    
    public void add_driver(Driver driver)
    {
        dataBase.list_drivers.add(driver);
    }
    
    public boolean search(String userName, String password)
    {
        boolean flag = false;
        for (Driver d : dataBase.list_drivers)
                {   
                    if (d.get_name().equals(userName) && d.get_password().equals(password))
                        flag = true;
                }
        if (flag)
        {
            return true;
        }
        else
        {
            System.out.println("you aren't registered to the system");
            return false;
        }
        
    }
    
    public void add_favourite_area(String fav)
    {
        dataBase.favouriteArea.add(fav);
    }
    
    public ArrayList<String> get_favourite_area()
    {
        return dataBase.favouriteArea;
    }
}
