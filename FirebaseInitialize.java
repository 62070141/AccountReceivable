import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirebaseInitialize {

    public void initialize(){
        try(FileInputStream serviceAccount =
                new FileInputStream("src/serviceAccountKey.json")) {

            /*
             * จำเป็นต้องใช้ library ของ firebase
             * แทนการเชื่อมต่อ TCP Socket และต่อด้วย FileInputStream, InputStreamReader และ BufferedReader
             * เพราะ Firebase จะมีการส่ง Credentials เพื่อยืนยันตัวตนก่อนอณุญาติให้ทำงานเชื่อมต่อกับฐานข้อมูล
             * */

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://accre-ebbe5.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
