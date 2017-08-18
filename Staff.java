/**
 * Created by dumin on 8/2/2017.
 */
public abstract class Staff {
    protected int idNumber;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phone;

    // default constructor
    public Staff(){
        // initialise instance variables with default values
        idNumber = 0;
        firstName = "";
        lastName = "";
        address = "";
        phone = "";
    }

    //Constructor with passing arguments
    public Staff(int idNumber, String firstName, String lastName,String address, String phone){
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    //setter methods
    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    // getter methods
    public int getIdNumber(){
        return idNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }
}

