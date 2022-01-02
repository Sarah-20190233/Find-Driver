package sprint2;

public class Customer_controller {

    private Customer customer = new Customer();
    private DataBase dataBase = new DataBase();

    public void add_customer(Customer customer) {
        dataBase.list_customers.add(customer);
    }

    public boolean search(String userName, String password) {
        boolean flag = false;
        for (Customer c : dataBase.list_customers) {
            if (c.getUserName().equals(userName) && c.getPassword().equals(password)) {
                flag = true;
            }
        }
        if (flag) {
            return true;
        } else {
            System.out.println("you aren't registered to the system");
            return false;
        }
    }
}
