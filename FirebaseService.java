import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import java.util.concurrent.ExecutionException;

public class FirebaseService {

    public static boolean setCustomer(Customer cus){
        try {
            CustomerFirebase cusF = new CustomerFirebase(cus);
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> future = dbFirestore.collection("Customers").document(cusF.ID).set(cusF);
            //while (!future.isDone()){}
            return true;
        }
        catch (Exception ex){
            //System.out.println(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public static Customer getCustomerByID(String ID){
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            DocumentReference documentReference = dbFirestore.collection("Customers").document(ID);
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot doc = future.get();
            long start = System.currentTimeMillis();
            Customer cus = null;

            /*หากโหลดช้าจะรอ 5 วินาที ไม่งั้นจะถือว่าไม่ได้รับข้อมูล*/
            while (!doc.exists()){
                long now = System.currentTimeMillis();

                if(doc.exists()){

                    /*หากไม่ใช้ toObject สามารถเปลี่ยน doc เป็น HashMap หรือ JSON แล้วเลือก attribute ทีละตัว
                    *เนื่องจากข้อมูลที่รับมาจาก Firebase นั้นอยู่ในรูปแบบของ JSON
                    **/

                    cus = new Customer(doc.toObject(CustomerFirebase.class));
                    break;
                }

                if(now - start >= 5000)
                    break;
            }
            if(doc.exists())
                cus = new Customer(doc.toObject(CustomerFirebase.class));
            return cus;
        }
        catch (InterruptedException ex){
            System.out.println(ex);
            return null;
        }
        catch (ExecutionException ex){
            ex.printStackTrace();
            return null;
        }

    }

    public static boolean deleteCustomerByID(String ID){
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> future = dbFirestore.collection("Customers").document(ID).delete();
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public static Iterable<DocumentReference> getRef(){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        return dbFirestore.collection("Customers").listDocuments();
    }
}
