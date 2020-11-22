public class CustomerFirebase {
    public String ID;
    public String name;
    public double amountDue;
    public double advancePayment;
    public String details;
    public long dueDate;
    public long lastPaid;
    public long joinedDate;

    public CustomerFirebase(){

    }
    public CustomerFirebase(Customer cus){
        this.ID = cus.getID();
        this.name = cus.getName();
        this.amountDue = cus.getAmountDue();
        this.advancePayment = cus.getAdvancePayment();
        this.details = cus.getDetails();
        this.dueDate = cus.getDueDate().getTime();
        this.joinedDate = cus.getJoinedDate().getTime();
        if(cus.getLastPaid() != null){
            this.lastPaid = cus.getLastPaid().getTime();
        }
    }
}
