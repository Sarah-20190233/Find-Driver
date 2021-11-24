package software2;

import java.util.Scanner;
import java.util.*;  
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
     
      int choice;
      int ch;
      Scanner input = new Scanner(System.in);
      
      Customer customer = new Customer();
      Driver driver = new Driver();
      Admin admin = new Admin();
      User user = new Driver();
      Ride ride = new Ride();
      Ride ride2 = new Ride();
      
      String Source;
      String destination;
      String userName;
      String email;
      String password;
      String phone;
      String nationalid;
      String license;
      HashMap<String,Integer> map=new HashMap<String,Integer>();//Creating HashMap 
      HashMap<String,String> map2=new HashMap<String,String>();
     
           
     do{
          System.out.println("please enter a choice from 0 to 5");
          System.out.println("0. enter as an admin");
          System.out.println("1. Register as a customer");
          System.out.println("2. Register as a driver");
          System.out.println("3. Login as a customer");
          System.out.println("4. Login as a driver");
          System.out.println("5. Exit");
           
           choice = input.nextInt();
           
           if(choice == 0)
           {
               int answer;
               System.out.println("Please enter admin password");
               password = input.next();
               if (password.equals("#admin#$$8@*&"))
               {
                   do{
                   System.out.println("please enter a choice from 1 to 3");
                   System.out.println("1. Suspend a driver");
                   System.out.println("2. Suspend a customer");
                   System.out.println("3. List all pendings drivers");
                   System.out.println("4. exit");
                   answer = input.nextInt();
                   
                   if(answer == 1)
                   {
                       System.out.println("Enter the name of driver you want to suspend him");
                       String suspended;
                       suspended = input.next();
                       admin.Suspend_drivers(suspended);
                       System.out.println("Susbending has been successfully");
                   }
                   if(answer == 2)
                   {
                       System.out.println("Enter the name of customer you want to suspend him");
                       String suspended;
                       suspended = input.next();
                       admin.Suspend_customers(suspended);
                       System.out.println("Susbending has been successfully");
                       

                   }
                   
                   else if (answer == 3)
                   {
                       System.out.println(admin.list_Pendings());
                   }
                   
                   }while(answer != 4);
               }
               else
               {
                   System.out.println("You aren't admin");
               }
           }
           
          else if(choice == 1)
          {
              System.out.println("Please enter your user name without space: ");
              userName = input.next();
              System.out.println("Please enter your email: ");
              email = input.next();
              if (email.contains("@")){
              System.out.println("Please enter your password: ");
              password = input.next();
              System.out.println("Please enter your phone number: ");
              phone = input.next();
  
            
              customer.Register(userName, email, password, phone);
              customer.add_customer(customer);
              System.out.println("You are registered now..");
              }
              else
              {
                  System.out.println("invalid email, your email should contain @  register again");
              }
          }
          else if(choice == 2)
          {
              System.out.println("Please enter your user name without space:");
              userName = input.next();
              System.out.println("Please enter your email: ");
              email = input.next();
              if (email.contains("@")){
              System.out.println("Please enter your password: ");
              password = input.next();
              System.out.println("Please enter your phone number: ");
              phone = input.next();             
              System.out.println("Please enter your national id: ");
              nationalid = input.next();
              if(nationalid.length() == 14){
              System.out.println("Please enter your license");
              license = input.next();
              Driver d = new Driver(userName,license);
              admin.pendings.add(d);
            if(license.length() == 14)
            {
              admin.Verify(userName);
              admin.pendings.remove(d);
              driver.Register(userName , email , password , phone);
              driver.add_driver(driver);
              System.out.println("You are registered now..");

            }
              
            else
            {
                System.out.println("Sorry, you can't register to the system, invalid license number");
            }
              }else {
            	  System.out.println("invalid national id your id should be of length 14 .register again");
              }
          }
          else
              {
                  System.out.println("invalid email, your email should contain @ register again");
              }
          }
          
          else if (choice == 3)
          {     
                int answer;
                System.out.println("Please enter user name");
                userName = input.next();
                System.out.println("Please enter user password");
                password = input.next();
                if(customer.search(userName, password)) {
                customer.setUserName(userName);
                do{
                
                System.out.println("please enter a choice from 1 to 4");
                System.out.println("1. request a ride");
                System.out.println("2. rate any driver");
                System.out.println("3. show average ratings");
                System.out.println("4. exit");
                answer = input.nextInt();
                
                if (answer == 1)
                {
                    System.out.println("please enter ride source and destination");
                    Source = input.next();
                    destination = input.next();
                    ride.setSource(Source);
                    ride.List_Sources(Source);
                    ride.setDestination(destination);
                    map2.put(customer.getUserName(), Source);
                    
                    System.out.println("Your ride with the source" + " " + Source + " " + "and destination" + " " + destination + " " + "is requested");
                    while (true){
                    System.out.println("do you want to show offers for this ride ? (yes/no)");                    
                    String ans = input.next();
                    
                    if(ans.equalsIgnoreCase("yes"))
                    {   
                        if(ride.getSource().equalsIgnoreCase(ride2.getSource()) && ride.getDestination().equalsIgnoreCase(ride2.getDestination()))
                        {
                            System.out.println("there's an offer on this ride with " + ride2.getPrice() + " $");   
                        }
                        else
                        {  
                            System.out.println("there's no offer on this ride");   
                        }
                        break;
                    }
                    else if (ans.equalsIgnoreCase("no"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("please enter a valid choice (yes or no)");
                    }
                    }
                }
                
                else if (answer == 2)
                {   
                      System.out.println("please enter a driver name");
                      String name = input.next();
                      System.out.println("please enter rate from 1 to 5");
                      int rate_value = input.nextInt();
                      map.put(name, rate_value);
                      System.out.println("rating done");
                }
                else if (answer == 3)
                {
                        for(Map.Entry m : map.entrySet()){    
                        System.out.println(m.getKey()+" "+m.getValue());    
                        }
                }
                 
                }while(answer != 4);
                }
                
          }
          else if (choice == 4)
          {
                System.out.println("Please enter user name");
                userName = input.next();
                System.out.println("Please enter user password");
                password = input.next();
               if( driver.search(userName, password)) {
            
                    do
                    {
                         System.out.println("1. enter your favourite area");
                         System.out.println("2. Show rates");
                         System.out.println("3. Show your favourite areas");
                         System.out.println("4. notifications for a rides");
                         System.out.println("5. suggest a price for a ride");
                         System.out.println("6. Exit");
                         ch = input.nextInt();
                         if(ch == 1)
                         {
                                System.out.println("Enter your favourite area");
                                String area;
                                area= input.next();
                                driver.add_favourite_area(area);
                                System.out.println("Your favourite area ia added");
                                 // driver.get_notification(Source);
                    
                         }
                         else if(ch == 2)
                         {
                            boolean flag = false;

                            System.out.println("show rates");
                            for (Map.Entry m : map.entrySet()) {
                                if (m.getKey().equals(driver.userName)) {
                                    System.out.println(m.getKey() + " " + m.getValue());
                                    flag = true;
                                }
                            }
                            if (!flag) {
                                System.out.println("there is no rating for this user");
                            }
                         } 
                         else if(ch == 3)
                         {
                              System.out.println("Your favourite area:");
                              System.out.println(driver.get_favourite_area()); 
                         }
                         else if(ch == 4)
                         {
                             boolean flag=false;
                        	
                             for (Map.Entry m : map2.entrySet()) {
                                 if(driver.favouriteArea.contains(m.getValue()))
                                 {
                                     System.out.println("there is a ride its source "+m.getValue()+" and its customer name "+m.getKey());
                                     flag=true;
                                 }
                             }
                        	  if (!flag) {
                                  System.out.println("there is no ride until now for your favorite areas");
                                  }
                         }
                         
                         else if(ch == 5)
                         {   System.out.println("please enter the ride source and destination");
                             String source = input.next();
                             String Destination = input.next();
                             System.out.println("please enter the suggested price");
                             double price = input.nextDouble();
                             ride2.setSource(source);
                             ride2.setDestination(Destination);
                             ride2.setPrice(price);
                         }
                         
                         
                         
                    }while(ch != 6);
               }
                
          }
     }
     
     while(choice != 5);
             
       
        /*Customer customer = new Customer();
        System.out.println("Please enter your name");
        String userName;
        String email;
        String password;
        String phone;
        Scanner input = new Scanner(System.in);
       */

        
    }
     }
     


        

     
