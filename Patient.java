public class Patient {

    private int Id;
    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;
    private String firstVisit;
    private String lastVisit;



    public  Patient(){

        Id=0;
        firstName="";
        lastName="";
        address="";
        dateOfBirth="";
        firstVisit="";
        lastVisit="";
    }

    public Patient(int Id, String firstName, String lastName, String address,String dateOfBirth,String firstVisit,String lastVisit){

        this.Id=Id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.dateOfBirth=dateOfBirth;
        this.firstVisit=firstVisit;
        this.lastVisit=lastVisit;
    }


    public void setFirstName(int Id){

        this.Id=Id;
    }

    public void setFirstName(String firstName){

        this.firstName=firstName;
    }

    public void setLastName(String lastName){

        this.lastName=lastName;
    }

    public void setAddress(String address){

        this.address=address;
    }

    public void setDateOfBirth(String dateOfBirth){

        this.dateOfBirth=dateOfBirth;
    }

    public void setFirstVisit(String firstVisit){

        this.firstVisit=firstVisit;
    }
    public void setLastVisit(String lastVisit){

        this.lastVisit=lastVisit;
    }



    public int getId(){

        return Id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getlasttName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getFirstVisit(){
        return firstVisit;
    }
    public String getLastVisit(){
        return lastVisit;
    }
}
