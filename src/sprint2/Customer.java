package sprint2;

public class Customer implements User {

    private String userName;
    private String email;
    private String phone;
    private String password;
    private int birthdate_day;
    private int birthdate_month;
    private int rate_value;
    private Ride ride = new Ride();
    private DataBase dataBase = new DataBase();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void Register(String userName, String email, String password, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;

    }

    public void set_birthdate(int birthdate_day, int birthdate_month) {
        this.birthdate_day = birthdate_day;
        this.birthdate_month = birthdate_month;
    }

    public int get_birthdate_day() {
        return birthdate_day;
    }

    public int get_birthdate_month() {
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

}
