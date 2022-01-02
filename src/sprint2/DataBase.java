package sprint2;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {

    public ArrayList<String> drivers = new ArrayList<String>();
    public ArrayList<String> customers = new ArrayList<String>();
    public ArrayList<User> pendings = new ArrayList<User>();
    public ArrayList<Customer> list_customers = new ArrayList<Customer>();
    public ArrayList<String> favouriteArea=new ArrayList<String>();
    public ArrayList<Driver> list_drivers = new ArrayList<Driver>();
    public HashMap<String,Integer> map=new HashMap<String,Integer>();
    public HashMap<String,String> map2=new HashMap<String,String>();
    public ArrayList<String> list_sources = new ArrayList<String>();
    public ArrayList<String> Drivers_sources = new ArrayList<String>();
    public ArrayList<Ride> rides = new ArrayList<Ride>();
    public ArrayList<String> avaiable_Drivers = new ArrayList<String>();
    public ArrayList<Ride> list_ride = new ArrayList<Ride>();
    public ArrayList<String> Customer_Destinations = new ArrayList<String>();
}
