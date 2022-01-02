package sprint2;

import java.util.Scanner;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class Transportation {

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
        Ride ride3 = new Ride();
        Customer_controller customer_controller = new Customer_controller();
        Driver_controller driver_controller = new Driver_controller();
        DataBase dataBase = new DataBase();

        String Source;
        String destination;
        String userName;
        String email;
        String password;
        String phone;
        String nationalid;
        String license;
        int birthdate_day;
        int birthdate_month;
        do {
            System.out.println("please enter a choice from 0 to 5");
            System.out.println("0. enter as an admin");
            System.out.println("1. Register as a customer");
            System.out.println("2. Register as a driver");
            System.out.println("3. Login as a customer");
            System.out.println("4. Login as a driver");
            System.out.println("5. Exit");

            choice = input.nextInt();

            if (choice == 0) {
                int answer;
                System.out.println("Please enter admin password");
                password = input.next();
                if (password.equals("123")) {
                    do {
                        System.out.println("please enter a choice from 1 to 3");
                        System.out.println("1. verify a driver");
                        System.out.println("2. Suspend a driver");
                        System.out.println("3. Suspend a customer");
                        System.out.println("4. List all pendings drivers");
                        System.out.println("5. add discount on a specific area");
                        System.out.println("6. List all Rides in the system");
                        System.out.println("7. exit");
                        answer = input.nextInt();

                        if (answer == 1) {
                            System.out.println("Enter the name of driver you want to verify");
                            String verified;
                            verified = input.next();
                            driver.set_name(verified);
                            admin.Verify(driver);
                            admin.dataBase.drivers.add(verified);
                            admin.dataBase.pendings.remove(verified);
                            System.out.println("verifying has been done successfully");
                        } else if (answer == 2) {
                            System.out.println("Enter the name of driver you want to suspend");
                            String suspended;
                            suspended = input.next();
                            admin.Suspend_drivers(suspended);
                            admin.dataBase.drivers.remove(suspended);
                            System.out.println("Susbending has been successfully");
                        }
                        if (answer == 3) {
                            System.out.println("Enter the name of customer you want to suspend");
                            String suspended;
                            suspended = input.next();
                            admin.Suspend_customers(suspended);
                            dataBase.customers.remove(suspended);
                            System.out.println("Susbending has been successfully");
                        } else if (answer == 4) {
                            System.out.println(admin.list_Pendings());
                        } else if (answer == 5) {
                            System.out.println("Enter the areas that have offer");
                            String area = input.next();
                            ride.set_Admin_Area(area);
                        } else if (answer == 6) {

                            Ride r = new Ride();;

                            ride.display();

                        }

                    } while (answer != 7);
                } else {
                    System.out.println("You aren't admin");
                }
            } else if (choice == 1) {
                System.out.println("Please enter your user name without space: ");
                userName = input.next();
                System.out.println("Please enter your email: ");
                email = input.next();
                if (email.contains("@")) {
                    System.out.println("Please enter your password: ");
                    password = input.next();
                    System.out.println("Please enter your phone number: ");
                    phone = input.next();
                    System.out.println("Please enter your birthDate in day and month: ");
                    birthdate_day = input.nextInt();
                    birthdate_month = input.nextInt();
                    customer.Register(userName, email, password, phone);
                    ride.set_customer_birthdate(birthdate_day, birthdate_month);
                    customer.set_birthdate(birthdate_day, birthdate_month);
                    customer.set_birthdate(birthdate_day, birthdate_month);
                    customer_controller.add_customer(customer);
                    //saraessam
                    customer_controller.add_customer(customer);
                    dataBase.customers.add(userName);
                    System.out.println("You are registered now..");
                } else {
                    System.out.println("invalid email, your email should contain @  register again");
                }
            } else if (choice == 2) {
                System.out.println("Please enter your user name without space:");
                userName = input.next();
                System.out.println("Please enter your email: ");
                email = input.next();
                if (email.contains("@")) {
                    System.out.println("Please enter your password: ");
                    password = input.next();
                    System.out.println("Please enter your phone number: ");
                    phone = input.next();
                    System.out.println("Please enter your national id: ");
                    nationalid = input.next();
                    if (nationalid.length() == 14) {
                        System.out.println("Please enter your license");
                        license = input.next();
                        Driver d = new Driver(userName, license);

                        if (license.length() == 14) {
                            admin.dataBase.pendings.add(d);
                            if (driver.satatus == true) {
                                driver.Register(userName, email, password, phone);
                                driver_controller.add_driver(driver);
                                admin.dataBase.drivers.add(userName);
                                System.out.println("You are registered now..");
                            } else {
                                System.out.println("you can't register to the system, please wait until admin verifies you...");
                            }

                        } else {
                            System.out.println("invalid license number, license number should be of length 14 .register again");
                        }
                    } else {
                        System.out.println("invalid national id your id should be of length 14 .register again");
                    }
                } else {
                    System.out.println("invalid email, your email should contain @ register again");
                }
            } else if (choice == 3) {
                int answer;
                System.out.println("Please enter user name");
                userName = input.next();
                System.out.println("Please enter user password");
                password = input.next();
                if (customer_controller.search(userName, password)) {
                    customer.Login(userName, password);
                    if (dataBase.customers.contains(userName)) {
                        System.out.println("you are logged in successfully");
                        System.out.println("");
                        do {

                            System.out.println("please enter a choice from 1 to 4");
                            System.out.println("1. request a ride");
                            System.out.println("2. rate any driver");
                            System.out.println("3. show average ratings");
                            System.out.println("4. exit");
                            answer = input.nextInt();

                            if (answer == 1) {
                                System.out.println("please enter ride source and destination");
                                Source = input.next();
                                destination = input.next();
                                ride.setSource(Source);
                                ride.List_Sources(Source);
                                ride.setDestination(destination);
                                dataBase.map2.put(customer.getUserName(), Source);
                                Ride Ride = new Ride(Source, destination);
                                String day;
                                int number_of_day;
                                int month;
                                System.out.println("Please enter the date of the ride you want (enter the day , day number and the month): ");
                                day = input.next();
                                number_of_day = input.nextInt();
                                month = input.nextInt();
                                ride.set_date(day, number_of_day, month);
                                System.out.println("Your ride with the source" + " " + Source + " " + "and destination" + " " + destination + " " + "is requested");
                                System.out.println("Please enter number of passengers you want");
                                int num_passengers = input.nextInt();
                                ride.set_numberOfPassengers(num_passengers);
                                System.out.println("The number of passengers you have selected" + " " + num_passengers);
                                while (true) {
                                    System.out.println("do you want to show list of available drivers for your destination with their ride price ? (yes/no)");
                                    String ans = input.next();
                                    int flag = 0;
                                    if (ans.equalsIgnoreCase("yes")) {
                                        for (Ride r : ride.dataBase.rides) {
                                            if (r.getSource().equalsIgnoreCase(Ride.getSource()) && r.getDestination().equalsIgnoreCase(Ride.getDestination())) {
                                                System.out.println("there's a ride with " + r.getPrice() + "$");
                                                ride.getdiscount(r.getPrice());
                                                System.out.println("and the driver will come at" + r.getTime() + r.getState());
                                                flag = 1;
                                            }
                                        }
                                        if (flag == 0) {
                                            System.out.println("there's no offer on this ride");
                                            break;
                                        }
                                        flag = 0;
                                        System.out.println("do you want to request one of this rides ? (yes/no)");
                                        ans = input.next();
                                        if (ans.equalsIgnoreCase("yes")) {
                                            System.out.println("please enter price you want **before discount**");
                                            double Input = input.nextDouble();
                                            Ride.setPrice(Input);
                                            for (Ride r : ride.dataBase.rides) {
                                                if (r.getPrice() == Input && r.getSource().equalsIgnoreCase(Ride.getSource()) && r.getDestination().equalsIgnoreCase(Ride.getDestination())) {
                                                    System.out.println("this ride now for you with price " + r.getPrice() + "$");
                                                    ride.getdiscount(r.getPrice());
                                                    System.out.println("and your driver name: " + r.getDriver() + " and the driver will come to your location at: " + r.getTime() + r.getState());
                                                    r.setCustomer(customer);
                                                    r.setCustomer_name(customer.getUserName());
                                                    flag = 1;
                                                }
                                            }
                                            if (flag == 0) {
                                                System.out.println("there's no ride with this price");
                                                break;
                                            }
                                        } else if (ans.equalsIgnoreCase("no")) {
                                            break;
                                        }

                                    } else if (ans.equalsIgnoreCase("no")) {
                                        break;
                                    } else {
                                        System.out.println("please enter a valid choice (yes or no)");
                                    }

                                    System.out.println("do you want to show offers for this ride ? (yes/no)");
                                    ans = input.next();
                                    int bool = 0;
                                    if (ans.equalsIgnoreCase("yes")) {
                                        if (ride.getSource().equalsIgnoreCase(ride2.getSource()) && ride.getDestination().equalsIgnoreCase(ride2.getDestination()) && ride.getDestination().equalsIgnoreCase(ride3.getDestination())) {
                                            double price = ride2.getPrice();
                                            price -= 0.1 * price;
                                            ride2.setPrice(price);
                                            System.out.println("there's an offer on this ride with 10% discount your cost now is: " + ride2.getPrice() + " $");
                                            bool = 1;
                                        } else if (ride.getDestination().equalsIgnoreCase(ride3.getDestination()) && bool == 0) {
                                            double price = ride.getPrice();
                                            price -= 0.1 * price;
                                            ride.setPrice(price);
                                            System.out.println("there's an offer on this ride with 10% discount your cost now is: " + ride.getPrice() + " $");
                                        } else if (ride.getSource().equalsIgnoreCase(ride2.getSource()) && ride.getDestination().equalsIgnoreCase(ride2.getDestination()) && bool == 0) {
                                            System.out.println("there's an offer on this ride with " + ride2.getPrice() + " $");
                                        } else {
                                            System.out.println("there's no offer on this ride");
                                        }
                                        break;
                                    } else if (ans.equalsIgnoreCase("no")) {
                                        break;
                                    } else {
                                        System.out.println("please enter a valid choice (yes or no)");
                                    }

                                }
                            } else if (answer == 2) {
                                System.out.println("please enter a driver name");
                                String name = input.next();
                                System.out.println("please enter rate from 1 to 5");
                                int rate_value = input.nextInt();
                                dataBase.map.put(name, rate_value);
                                System.out.println("rating done");
                            } else if (answer == 3) {
                                for (Map.Entry m : dataBase.map.entrySet()) {
                                    System.out.println(m.getKey() + " " + m.getValue());
                                }
                            }

                        } while (answer != 4);
                    } else {
                        System.out.println("sorry...you are suspended");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Please enter user name");
                userName = input.next();
                System.out.println("Please enter user password");
                password = input.next();
                if (driver_controller.search(userName, password)) {
                    driver.Login(userName, password);
                    if (admin.dataBase.drivers.contains(userName)) {
                        System.out.println("you are logged in successfully");
                        System.out.println("");
                        do {
                            System.out.println("1. Enter your favourite area");
                            System.out.println("2. Show rates");
                            System.out.println("3. Show your favourite areas");
                            System.out.println("4. Requests for my favourite area");
                            System.out.println("5. Notifications for a rides");
                            System.out.println("6. Suggest a price for a ride");
                            System.out.println("7. Add your source area");
                            System.out.println("8. Exit");
                            ch = input.nextInt();
                            if (ch == 1) {
                                System.out.println("Enter your favourite area");
                                String area;
                                area = input.next();
                                driver_controller.add_favourite_area(area);
                                dataBase.favouriteArea.add(area);
                                System.out.println("Your favourite area ia added");

                            } else if (ch == 2) {
                                boolean flag = false;

                                System.out.println("show rates");
                                for (Map.Entry m : dataBase.map.entrySet()) {
                                    if (m.getKey().equals(driver.get_name())) {
                                        System.out.println(m.getKey() + " " + m.getValue());
                                        flag = true;
                                    }
                                }
                                if (!flag) {
                                    System.out.println("there is no rating for this user");
                                }
                            } else if (ch == 3) {
                                System.out.println("Your favourite area:");
                                System.out.println(driver_controller.get_favourite_area());
                            } else if (ch == 4) {

                                boolean flag = false;
                                for (Map.Entry m : dataBase.map2.entrySet()) {
                                    if (dataBase.favouriteArea.contains(m.getValue())) {
                                        System.out.println("there is a ride its source " + m.getValue() + " and its customer name " + m.getKey());
                                        flag = true;
                                    }
                                }
                                if (!flag) {
                                    System.out.println("there is no ride until now for your favorite areas");
                                }
                            } else if (ch == 5) {
                                System.out.println("Enter yes if you are available and no if you are not available: ");
                                String answer = input.next();
                                boolean flag = false;
                                if (answer.equals("yes")) {
                                    for (Map.Entry m : dataBase.map2.entrySet()) {
                                        if (dataBase.Drivers_sources.contains(m.getValue())) {
                                            System.out.println("there is a ride its source " + m.getValue() + " and its customer name " + m.getKey());

                                            flag = true;
                                        }
                                    }
                                    if (!flag) {
                                        System.out.println("there is no ride until now for your source areas");
                                    }
                                } else {
                                    break;
                                }
                            } else if (ch == 6) {
                                System.out.println("please enter the ride source and destination");
                                String source = input.next();
                                String Destination = input.next();
                                System.out.println("please enter the suggested price");
                                double price = input.nextDouble();
                                driver.suggest_price(ride2, source, Destination, price);
                                System.out.println("please enter the time  in 24h format");
                                double Time = input.nextDouble();
                                String Customer = "null";
                                Ride ride4 = new Ride(source, Destination, price, driver);
                                ride4.time_handling(Time);
                                ride4.setPrice_before(price);
                                ride.add_ride(ride4);

                            } else if (ch == 7) {
                                System.out.println("Enter your source");
                                String name = input.next();
                                dataBase.Drivers_sources.add(name);
                                for (Map.Entry m : dataBase.map2.entrySet()) {
                                    if (dataBase.Drivers_sources.contains(m.getValue())) {

                                    }

                                }
                            }

                        } while (ch != 8);
                    } else {
                        System.out.println("sorry...you are suspended");
                    }
                }
            }
        } while (choice != 5);

    }
}
