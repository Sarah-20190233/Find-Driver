package sprint2;

enum holiday {
    FRIDAY, SATURDAY, chrithmis;
}

public class Ride {

    private String Source;
    private String Destination;
    private double Price_before;
    private double Price;
    protected DataBase dataBase = new DataBase();
    private Driver driver;
    private Customer customer;
    private int number_of_passengers;
    private int numofpassenger;
    private String date;
    public String day;
    public int number_of_day;
    public int month;
    public String area;
    public int customer_birthdate_day;
    public int customer_birthdate_month;
    private String state;
    private double time;
    private String customer_name = "null";

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Ride(String source, String destination) {
        super();
        Source = source;
        Destination = destination;
        this.number_of_passengers = 0;
    }

    public Ride(String source, String destination, double price, double time, Driver driver) {
        super();
        Source = source;
        Destination = destination;
        Price = price;
        this.time = time;
        this.driver = driver;
    }

    public double getPrice_before() {
        return Price_before;
    }

    public void setPrice_before(double price_before) {
        Price_before = price_before;
    }

    public Ride(String source, String destination, double price, Driver driver) {
        super();
        Source = source;
        Destination = destination;
        Price = price;
        this.driver = driver;

    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDriver() {
        return driver.get_name();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getCustomer() {
        return customer.getUserName();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void add_ride(Ride ride) {
        dataBase.rides.add(ride);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void time_handling(double Time) {

        if (Time <= 11.59) {
            this.state = "pm";
        } else {
            this.state = "am";
            Time = Time - 12;
        }
        this.time = Time;
    }

    public void display() {
        int i = 0;
        for (Ride r : dataBase.rides) {

            i++;
            System.out.println("Ride" + i);
            System.out.println("** Captain put a price to the ride**");
            System.out.println(" its Source: " + r.getSource() + "  its Destination: " + r.Destination + "   its Price:" + r.Price_before + "   its Time: " + r.time + r.state + "   its Driver Name: " + r.driver.get_name());
            if (r.customer_name != "null") {
                System.out.println(" **User accepts the captain price** ");

                System.out.println("  its Source: " + r.getSource() + "   its Destination: " + r.Destination + "   its Price:" + r.Price + "   its Time: " + (r.time + 0.5) + r.state + "   its Customer Name:" + r.customer_name);
                System.out.println("**Captain arrived to user location**");

                time_handling(r.time);
                System.out.println("  its Source: " + r.getSource() + "   its Destination: " + r.Destination + "   its Price:" + r.Price + "   the driver arrive to location at: " + (r.time + 0.5) + r.state + "   its Customer Name:" + r.customer_name);
                System.out.println("**Captain arrived to user destination**");
                System.out.println("  its Source: " + r.getSource() + "   its Destination: " + r.Destination + "   its Price:" + r.Price + "   the driver arrive to Destination at : " + (r.time + 1) + r.state + "   its Customer Name:" + r.customer_name);
            }

        }
    }

    public Ride() {
        this.Source = "";
        this.Destination = "";
        this.Price = 200;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getSource() {
        return this.Source;
    }

    public String getDestination() {
        return this.Destination;
    }

    public double getPrice() {
        return this.Price;
    }

    public void List_Sources(String source) {
        dataBase.list_sources.add(source);

    }

    public void List_ride(Ride ride) {
        dataBase.list_ride.add(ride);

    }

    public void set_date(String day, int number_of_day, int month) {
        this.day = day;
        this.number_of_day = number_of_day;
        this.month = month;
    }

    public void set_customer_birthdate(int customer_birthdate_day, int customer_birthdate_month) {
        this.customer_birthdate_day = customer_birthdate_day;
        this.customer_birthdate_month = customer_birthdate_month;
    }

    public void set_numberOfPassengers(int numofpassenger) {
        this.numofpassenger = numofpassenger;
    }

    public void set_Admin_Area(String area) {
        this.area = area;
    }

    public double getdiscount(double price) {
        double discount = 0.0;
        if (customer_birthdate_day == number_of_day && customer_birthdate_month == month) {
            discount = price - (price * 0.1);
            System.out.println("and after dicount it will be equal: " + discount + "$");
            System.out.println("Happy Birth Day to You");
        } else if (dataBase.list_sources.size() == 1) {
            discount = price - (price * 0.1);
            System.out.println("and after discount it will be equal: " + discount + "$");
        } else if (numofpassenger == 2) {
            discount = price - (price * 0.05);
            System.out.println("and after discount it will be equal: " + discount + "$");
        } else if (day.equals("Friday") || day.equals("Saturday")) {
            discount = price - (price * 0.05);
            System.out.println("and after discount it will be equal: " + discount + "$");
        } else {
            discount = price;

        }

        return discount;
    }

}
