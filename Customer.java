//import org.springframework.stereotype.Component;

import java.sql.Timestamp;

//@Component
public class Customer{
    private String ID;
    private String name;
    private Double amountDue;
    private String details;
    private Timestamp dueDate;
    private Timestamp lastPaid;
    private Timestamp joinedDate;

    public Customer(String ID, String name, Double amountDue, Timestamp joinedDate, Timestamp dueDate, String details){
        this.ID = ID;
        this.name = name;
        this.amountDue = amountDue;
        this.joinedDate = joinedDate;
        this.dueDate = dueDate;
        this.details = details;
    }

    public Customer(String ID, String name, Double amountDue, Timestamp joinedDate, Timestamp dueDate){
        this(ID, name, amountDue, joinedDate, dueDate, "");
    }

    public Customer(String ID, String name, Double amountDue){
        this(ID, name, amountDue, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + 1000L*3600*24*30), "");
    }

    public Customer(){

    }


    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Double amountDue) {
        this.amountDue = amountDue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Timestamp getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(Timestamp lastPaid) {
        this.lastPaid = lastPaid;
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
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString(){
        return getName() + " owed us " + getAmountDue() + " due on " + getDueDate().toString() + " last paid on " + getLastPaid().toString();
    }

}
