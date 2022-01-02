package com.example.demo.Domain;

import java.util.Scanner;

@Entity
@Table(name = "Customer")

public class Customer implements User {

    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )

	private String userName;
    private String email;
    private String phone;
    private String password;
    private int birthdate_day;
    private int birthdate_month;
    private int rate_value;
    private Ride ride = new Ride();
    //String source;
    //String destination;
   
    private DataBase dataBase = new DataBase();
    Scanner input = new Scanner(System.in);



	public void setUserName(String userName) {
		this.userName = userName;
	}
        
        public void setPassword(String password) {
		this.password = password;
	}
    public void Register(String userName, String email, String password, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        
    }
    
    public void set_birthdate(int birthdate_day , int birthdate_month)
    {
        this.birthdate_day = birthdate_day;
        this.birthdate_month = birthdate_month;
    }
    
    public int get_birthdate_day()
    {
        return birthdate_day; 
    }

    public int get_birthdate_month()
    {
        return birthdate_month;
    }
    
    public void Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    /*public boolean search(String userName, String password)
        {
        boolean flag = false;
        for (Customer c : dataBase.list_customers)
                {   
                    if (this.userName.equals(userName) && this.password.equals(password))
                        flag = true;
                }
        if (flag)
        {
            return true;
        }
        else
        {
            System.out.println("you aren't logged in");
            return false;
        }
       }*/
 /*public void set_trip_source(String source) {
		this.source = source;
	}*/
  

}
