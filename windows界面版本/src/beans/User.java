package beans;

public class User {
    private String name="";
    private String id="";
    private String password="";
    private double balance=0;

    public User(){
        super();
    }
    public User(String name, String id, String password, double balance){
        super();
        this.name=name;
        this.id=id;
        this.password=password;
        this.balance=balance;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name){
        this.name=name;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
