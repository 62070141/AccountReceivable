import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class FakeModel {
    private static int customerNum;
    private HashMap<String, Customer> cusMap;
    private ArrayList<String> cusID;

    public FakeModel(){
        cusMap = new HashMap<String, Customer>();
        cusID = new ArrayList<String>();
        generateCus(50);
    }

    public Customer getCustomerByID(String ID){
        if(!cusID.contains(ID) || !cusMap.containsKey(ID)) {
            Customer tempCus = new Customer(ID, "Customer N" + ID, (double) (int) (Math.random() * 10000));
            tempCus.setLastPaid( new Timestamp(tempCus.getJoinedDate().getTime() + (int)(Math.random() * 1000L*3600*24*15)));
            cusMap.put(ID, tempCus);
            cusID.add(ID);
        }
        return cusMap.get(ID);
    }

    public void setCustomer(Customer cus){
        cusMap.put(cus.getID(), cus);
        if(!cusID.contains(cus.getID())) cusID.add(cus.getID());
    }

    public ArrayList<Customer> getSummary(int months){
        if(months*20 > customerNum) generateCus(months * 5);
        ArrayList<Customer> temp = new ArrayList<Customer>(cusMap.values());
        temp.sort((cus1, cus2) -> cus1.getLastPaid().compareTo(cus2.getLastPaid()));
        return temp;
    }

    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> temp = new ArrayList<Customer>(cusMap.values());
        temp.sort((cus1, cus2) -> cus1.getID().compareTo(cus2.getID()));
        return temp;
    }

    private void generateCus(int num){
        num += customerNum;
        while (customerNum < num){
            Customer tempCus = new Customer(String.format("%04d", customerNum), "Customer N" + customerNum, (double)(int)(Math.random() * 10000),
                    new Timestamp(System.currentTimeMillis() - 1000L*3600*24*60), new Timestamp(System.currentTimeMillis() + 1000L*3600*24*30));
            tempCus.setLastPaid( new Timestamp(tempCus.getJoinedDate().getTime() + (int)(Math.random() * 1000L*3600*24*15)));
            setCustomer(tempCus);
            customerNum++;
        }
    }
}
