/**
 * Created by IT21503680 on 8/3/2017.
 */
public class Insurance {

    private int Id;
   private String companyName;
    private String Address;
   private String billingContactPerson;
    private String phoneContact;



    public Insurance(){
        Id=0;
        companyName="";
        Address="";
        billingContactPerson="";
        phoneContact="";


    }


    public Insurance(int Id,String companyName,String Address, String billingContactPerson, String phoneContact){

        this.Id=Id;
        this.companyName=companyName;
        this.Address=Address;
        this.billingContactPerson=billingContactPerson;
        this.phoneContact=phoneContact;

    }


    public void setId(int Id){
        this.Id=Id;

    }

    public void setCompanyName(String companyName){

        this.companyName=companyName;
    }
    public void setAddress(String address){

        this.Address=address;
    }
    public void setBillingContactPersone(String billingContactPerson){

        this.billingContactPerson=billingContactPerson;
    }
    public void setPhoneContact(String phoneContact){

        this.phoneContact=phoneContact;
    }




    public int getId(){

        return  Id;
    }

    public String getCompanyName(){

        return companyName;
    }

    public String getAddress(){

        return Address;
    }
    public String getBillingContactPerson(){

        return billingContactPerson;
    }
    public String getPhoneContact(){

        return phoneContact;
    }

}
