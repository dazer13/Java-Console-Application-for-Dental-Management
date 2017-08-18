/**
 * Created by dumin on 8/3/2017.
 */
public class DentalStaff extends Staff{
   // private String password;

    //Default constructor
    public DentalStaff(){
        super();
       // password = "";
    }

    // Constructor with passing arguments
    public DentalStaff(int idNumber, String firstName, String lastName, String address, String phone){
        super(idNumber, firstName, lastName,address,phone);
        //this.password = password;
    }

    //setter methods
   /* public void setPassword(String password){
        password = password;
    }

    //getter methods
    public String getPassword(){
        return password;
    }*/
}