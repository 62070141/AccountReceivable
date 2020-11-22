import java.sql.Timestamp;

public class CustomerController {
    private FakeModel model;
    private informationView informationView;
    private newCustomerFormView customerForm;
    private View view;


    public CustomerController() {}

    public void NewCustomer(){
        Customer newModel = customerForm.UpdateCustomer(); //นำข้อมูลลูกค้ามา
        model.setCustomer(newModel); //เอาข้อมูลมาใส่ในโมเดล
        view.displayShow(); //อัพเดทลงview
    }

    public void SystemStart(){
        view.LoginInterface();
    }
}
