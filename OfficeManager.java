/**
 * Created by dumin on 8/2/2017.
 */
public class OfficeManager extends Staff{
    private String password;

    //Default constructor
    public OfficeManager(){
        super();
        password = "";
    }

    // Constructor with passing arguments
    public OfficeManager(int idNumber, String firstName, String lastName, String address, String phone, String password){
        super(idNumber, firstName, lastName,address,phone);
        this.password = password;
    }

    //setter methods
    public void setPassword(String password){
        password = password;
    }

    //getter methods
    public String getPassword(){
        return password;
    }
}

