import com.google.cloud.firestore.DocumentReference;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AccountModel {
    private FirebaseInitialize connection;
    private HashMap<String, Customer> cusMap;
    private ArrayList<String> IDList;
    private int cusNum;
    private boolean loading = false;

    public AccountModel(){
        connection = new FirebaseInitialize();
        connection.initialize();
        cusMap = new HashMap<String, Customer>();
        IDList = new ArrayList<String>();
        loadAll();
    }

    public ArrayList<Customer> getAllCustomerByDueDate(){
        while (loading){}
        ArrayList<Customer> temp = new ArrayList<Customer>(cusMap.values());
        temp.sort((cus1, cus2) -> cus1.getDueDate().compareTo(cus2.getDueDate()));
        return temp;
    }

    public ArrayList<Customer> getAllCustomerByLastPaid(){
        while (loading){}
        ArrayList<Customer> temp = new ArrayList<Customer>(cusMap.values());
        temp.sort((cus1, cus2) -> cus1.getLastPaid().compareTo(cus2.getLastPaid()));
        return temp;
    }

    public ArrayList<Customer> getSummary(){
        while (loading){}
        ArrayList<Customer> temp = new ArrayList<Customer>(cusMap.values());
        temp.removeIf(cus -> (cus.getAmountDue() <= 0));
        temp.sort((cus1, cus2) -> cus1.getDueDate().compareTo(cus2.getDueDate()));
        return temp;
    }

    public ArrayList<Customer> getAllCustomer(){
        while (loading){}
        ArrayList<Customer> tempArr = new ArrayList<Customer>(cusMap.values());
        tempArr.sort((cus1, cus2) -> cus1.getID().compareTo(cus2.getID()));
        return tempArr;
    }

    public Customer getCustomer(String ID){
        if(cusMap.containsKey(ID)){
            return cusMap.get(ID);
        }
        Customer tempCus = FirebaseService.getCustomerByID(ID);
        if(tempCus != null){
            cusMap.put(ID, tempCus);
            IDList.add(ID);
        }
        return tempCus;

    }

    public Customer createNewCustomer(String name, double amountDue, Timestamp joinedDate, Timestamp dueDate, String details){
        Customer cus = new Customer(String.format("%04d", cusNum++), name, amountDue, joinedDate, dueDate, details);
        setCustomer(cus);
        cusMap.put(cus.getID(), cus);
        IDList.add(cus.getID());
        return cus;
    }

    public Customer createNewCustomer(String name, double amountDue, String details){
        Customer cus = new Customer(String.format("%04d", cusNum++), name, amountDue, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + 1000L*3600*24*30), details);
        setCustomer(cus);
        cusMap.put(cus.getID(), cus);
        IDList.add(cus.getID());
        return cus;
    }

    public Customer createNewCustomer(String name, double amountDue, Timestamp dueDate, String details){
        Customer cus = new Customer(String.format("%04d", cusNum++), name, amountDue, new Timestamp(System.currentTimeMillis()), dueDate, details);
        setCustomer(cus);
        cusMap.put(cus.getID(), cus);
        IDList.add(cus.getID());
        return cus;
    }

    public Customer createNewCustomer(String name, double amountDue, Timestamp dueDate){
        Customer cus = new Customer(String.format("%04d", cusNum++), name, amountDue, new Timestamp(System.currentTimeMillis()), dueDate, "");
        setCustomer(cus);
        cusMap.put(cus.getID(), cus);
        IDList.add(cus.getID());
        return cus;
    }

    public void setCustomer(String ID){
        FirebaseService.setCustomer(cusMap.get(ID));
    }

    public void setCustomer(Customer cus){
        FirebaseService.setCustomer(cus);
    }

    public int getCustomerNum(){
        return cusNum;
    }

    public boolean delCustomer(Customer cus){
        cusMap.remove(cus.getID());
        IDList.remove(cus.getID());
        return FirebaseService.deleteCustomerByID(cus.getID());
    }

    public boolean delCustomer(String ID){
        cusMap.remove(ID);
        IDList.remove(ID);
        return FirebaseService.deleteCustomerByID(ID);
    }

    public ArrayList<String> getIDList(){
        Collections.sort(IDList);
        return IDList;
    }

    public boolean changeID(String from, String to){
            delCustomer(to);
            Customer temp = getCustomer(from);
            temp.setID(to);
            cusMap.put(to, temp);
            delCustomer(from);
            IDList.add(to);
            return FirebaseService.setCustomer(temp);
    }

    private void loadAll(){
        loading = true;
        for(DocumentReference doc: FirebaseService.getRef()){
            getCustomer(doc.getId());
            cusNum++;
        }
        loading = false;
    }
}
