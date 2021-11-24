package software2;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements User {
    private String userName;
    private String email;
    private String phone;
    private String password;
    int rate_value;
    Driver driver;
    Ride ride;
    String source;
    String destination;
    
    Scanner input = new Scanner(System.in);
    ArrayList<Customer> list_customers = new ArrayList<Customer>();
    ArrayList<Integer> customers_ratings_for_drivers = new ArrayList<Integer>();
    
        public void Register(String userName , String email , String password , String phone)
        {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.phone = phone;     
        }

        public void Login(String email , String password)
        {
            this.email = email;
            this.password = password;
        }

        public void add_customer(Customer customer)
        {
            list_customers.add(customer);
        }

        /*public void Request(Ride ride)
        {
            System.out.println("Request your trip");
        }*/

        public void add_rate(int rate_value)
        {
            customers_ratings_for_drivers.add(rate_value);
        }

        public boolean search(String userName, String password)
        {
        boolean flag = false;
        for (Customer c : list_customers)
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
            System.out.println("you aren't logged in");
            return false;
        }
       }
    
        public void setSource(String source) {
		this.source = source;
	}
    
        public ArrayList<Integer> list_drivers_rating()
        {
        return customers_ratings_for_drivers;
        }
   
        public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
