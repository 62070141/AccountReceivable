import java.sql.Timestamp;

public class Customer{
    private String ID;
    private String name;
    private double amountDue;
    private String details;
    private Timestamp dueDate;
    private Timestamp lastPaid;
    private Timestamp joinedDate;

    public Customer(String ID, String name, double amountDue, Timestamp joinedDate, Timestamp dueDate, String details){
        this.ID = ID;
        this.name = name;
        this.amountDue = amountDue;
        this.joinedDate = joinedDate;
        this.dueDate = dueDate;
        this.details = details;
    }

    public Customer(String ID, String name, double amountDue, Timestamp joinedDate, Timestamp dueDate){
        this(ID, name, amountDue, joinedDate, dueDate, "");
    }

    public Customer(String ID, String name, double amountDue){
        this(ID, name, amountDue, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + 1000L*3600*24*30), "");
    }

    public Customer(CustomerFirebase cus){
        this.ID = cus.ID;
        this.name = cus.name;
        this.amountDue = cus.amountDue;
        this.details = cus.details;
        this.dueDate = new Timestamp(cus.dueDate);
        this.lastPaid = new Timestamp(cus.lastPaid);
        this.joinedDate = new Timestamp(cus.joinedDate);
    }

    public Customer(){

    }


    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
        FirebaseService.setCustomer(this);
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        FirebaseService.setCustomer(this);
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
        FirebaseService.setCustomer(this);

    }

    public Timestamp getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(Timestamp lastPaid) {
        this.lastPaid = lastPaid;
        FirebaseService.setCustomer(this);
    }

    public Timestamp getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Timestamp joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        FirebaseService.setCustomer(this);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        FirebaseService.deleteCustomerByID(this.ID);
        this.ID = ID;
        FirebaseService.setCustomer(this);
    }

    public String toString(){
        return getName() + " owed us " + getAmountDue() + " due on " + getDueDate() + " last paid on " + getLastPaid();
    }

}