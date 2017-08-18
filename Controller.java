import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dumin on 8/3/2017.
 */
public class Controller {

    //declare authentication variables
   // private String administratorID = "";
    private int managerID = 0;
    private int dentistId = 0;
    private int hrManagerId = 0;
    private OfficeManager officeManager;
    private DentalStaff dentalStaff;
    private HRManager hrManager;
    private Patient patient;
    private Insurance insurance;

    //declare other variables
    //private DVDRecord theDVDRecord;
    //private HireDetail theHireDetail;
    //private OverDueRecord theOverDueRecord;
    //private HireHistory theHireHistory;

    //declare Arraylist
    private ArrayList dentistlist = new ArrayList();
    private ArrayList staffManagerList = new ArrayList();
    private ArrayList hrManagerList = new ArrayList();
    private ArrayList patientList = new ArrayList();
    private ArrayList insuranceList = new ArrayList();
    //private ArrayList overDueList = new ArrayList();
    //private ArrayList hireHistoryList = new ArrayList();

    //declare files as constants(final)
    private final File dentistFile = new File("dentist.txt");
    private final File staffManagerFile = new File("staffManager.txt");
    private final File hrManagerFile = new File("hrManager.txt");
    private final File patientFile = new File("patient.txt");
    private final File insuranceFile = new File("insurance.txt");
  //  private final File hireFile = new File("hireDetails");
    //private final File overDueFile = new File("overDueRecord");
    //private final File hireHistoryFile = new File("hireHistory");

    //declare BufferedReader/Writer
    private BufferedWriter writer;
    private BufferedReader reader;
    private Formatter output;
    private Formatter output1;



    //returns all the administrator data list
    public ArrayList getAllDentist(){
        return dentistlist;
    }

    //returns all the administrator data list
    public ArrayList getAllPatients(){
        return patientList;
    }

    public ArrayList getAllInsurance(){
        return insuranceList;
    }
    //clear the screen
    public void clearScreen(){
        System.out.println('\u000c');
    }

    //create pause for some seconds
    public void pause(long secs){
        try{
            Thread.currentThread().sleep(secs*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //show the menu for login as admin or manager
    public void showChooseMenu() throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("***********************************************************");
        System.out.println("*                    [DCMS System]                    *");
        System.out.println("***********************************************************");
        System.out.println("");

        System.out.println("Please choose from ---(A]D)Dentist | (SM)StaffManager |(HR)HRManager|(P)Patient (Q)uit: ");
        String choice = console.nextLine();

        //login as admin or manager or quit the program
        if(choice.equalsIgnoreCase("a")){
           // clearScreen();
            authenticateHRManager();
        }else if(choice.equalsIgnoreCase("m")){
            clearScreen();
            authenticateHRManager();
        }else if(choice.equalsIgnoreCase("q")){
            System.out.println("");
            System.out.println("                   =====Program Ended=====                   ");
            System.exit(1);
        }else{
            System.out.println("Your choice is not applicable. Please try again!");
            pause(2);
            clearScreen();
            showChooseMenu();
        }
    }

    //================================================================================================

    //Authenticate Dentist

    public void authenticateHRManager() throws Exception {
        Scanner console = new Scanner(System.in);
        int failedLogin = 0;
        boolean authenticate = false;

        if(failedLogin<3){
            HRManager a = null;
            boolean found = false;
            hrManagerList = getAllDentist();
            Iterator it = hrManagerList.iterator();

            int idNumber = 0;
            String password = "";
            System.out.println("Please enter your Administrator ID:");
            idNumber = console.nextInt();
            System.out.println("Please enter your Password:");
            password = console.nextLine();

            while(it.hasNext() && !found){
                a = (HRManager) it.next();

                if(a.getIdNumber()==idNumber && a.getPassword().equalsIgnoreCase(password)){
                    authenticate = true;
                    hrManagerId = a.getIdNumber();
                    found = true;
                }
            }

            if(authenticate == true){
                System.out.println("Login successful! Please make a selection.");
                pause(1);
                clearScreen();
                showHRManagerMenu();
            }else{
                authenticate = false;
                failedLogin = failedLogin+1;

                System.out.println("Login failed. Please try again!!!");
                pause(1);
                clearScreen();
                authenticateHRManager();
            }
        }else{
            System.out.println("You have violated the login rule: \"3 failed login attempted!!!\"");
            pause(1);
            System.out.println("System will shutdown now!!!");
            System.exit(1);
        }
    }


    //shows the administrator menu for selection
    public int showHRManagerMenu() throws Exception {
        Scanner console = new Scanner(System.in);
        int selection = 0;

        System.out.println("***********************************************************");
        System.out.println("*                    [DCMS System]                    *");
        System.out.println("*                   HR Menu                   *");
        System.out.println("***********************************************************");
        System.out.println("");

        System.out.println("What do you want to do?");
        //System.out.println("[1]:\t ------");
        //System.out.println("[2]:\t -------");
        System.out.println("[3]:\t Add a new Dental Staff");
        System.out.println("[4]:\t Update Dental Staff");
        System.out.println("[5]:\t Delete Dental Staff details");
        System.out.println("[6]:\t Search Dental Staff Member");
        System.out.println("[7]:\t View a member's hire statement");
        System.out.println("[8]:\t Add New Insurance Details");
        System.out.println("[9]:\t Update Insurance Detais");
        System.out.println("[10]:\t Delete Insurance Details");
        System.out.println("[11]:\t Search Insurance Details");
        System.out.println("[12]:\t List All Insurance Details");
        System.out.println("[0]:\t Quit");
        System.out.println("");

        System.out.println("Please enter the menu code: >");
        try{
            selection = console.nextInt();
        }catch(Exception e){
            System.out.println("Please enter the number listed on the menu.");
            System.out.println(e.toString()+": " + e.getMessage());
            pause(2);
            clearScreen();
            showHRManagerMenu();
        }

        switch(selection){
            case 0:
               // adminQuitProgram();
                break;

            case 1:
                clearScreen();
                try{
                   // HireMovie();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                   // showAdminMenu();
                }
                break;

            case 2:
               // ReturnMovie();
               // showAdminMenu();
                break;

            case 3:
                addNewDentist();
                showHRManagerMenu();
                break;

            case 4:
                clearScreen();
                try{
                    updateDentist();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                  //  showAdminMenu();
                }
               // showAdminMenu();
                break;

            case 5:
                try{
                   deleteDentist();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                    showHRManagerMenu();
                }
                showHRManagerMenu();
                break;

            case 6:
                SearchDentist();
               showHRManagerMenu();
                break;

            case 7:
               // showHireStatementAdmin();
               // showAdminMenu();
                break;

            case 8:
                clearScreen();
               addNewInsurance();
               showHRManagerMenu();
                break;

              case 9:
                clearScreen();
                  try {
                      updateInsurance();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
                  showHRManagerMenu();
                break;
            case 10:
                clearScreen();

                      deleteInsurance();

                showHRManagerMenu();
                break;


            case 11:
               SearchInsurance();
                break;

              case 12:
               loadInsuranceFile();
                break;

            default:
                System.out.println("Please enter the number listed on the menu.");
                pause(2);
                clearScreen();
                 showHRManagerMenu();
                break;
        }
        return selection;
    }

    //=================================================================================================

    //add a new member
    public void addNewDentist(){
        clearScreen();
        Scanner console = new Scanner(System.in);
       Iterator it = dentistlist.iterator();
        boolean loop = false;
        int tempID = 0;
        while(it.hasNext()){
            DentalStaff m = (DentalStaff) it.next();
            tempID = m.getIdNumber();
        }
        tempID++;
        int memID = tempID;
        System.out.println("Please enter member's First Name: ");
        String name = console.nextLine();
        System.out.println("Please enter member's Last Name: ");
        String name2 = console.nextLine();
        System.out.println("Please enter member's Address: ");
        String address = console.nextLine();
        while(loop == false){
            System.out.println("Please enter member's phone number: (XXx-XXXXXXX)");
            String phone = console.nextLine();
            Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()){
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter(dentistFile, true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                clearScreen();
                System.out.println("Member added successfully");
                output.format("%s,%s,%s,%s,%s\r\n", memID, name,name2, address, phone);
                output.close();
                loop = true;
            }else{
                System.out.println("Phone Number must be in the form XX-XXXXXXX");
            }
        }
        System.out.println("=======================================================================");
        dentistlist.clear();
        loadDentistFile();
    }

    //================================================================================================

    //delete member detail
    public void deleteDentist() throws Exception{
        clearScreen();
        Scanner console = new Scanner(System.in);

        boolean done = false;
        Writer writer = new BufferedWriter(new FileWriter("dentistChanged.txt"));

        System.out.println("Member ID\tMember Name");
        System.out.println("---------------------------------------------");
        Iterator it1 = getAllDentist().iterator();

        while(it1.hasNext()){
            DentalStaff m = (DentalStaff) it1.next();
            System.out.println(m.getIdNumber() + "\t\t" + m.getFirstName());
        }
        System.out.println();
        //delete a record from the text file based on the memberID
        System.out.println("Please enter the member's ID number to delete the member: ");
        int memID = console.nextInt();
        // String memId=Integer.toString(memID);
        Iterator it =getAllDentist().iterator();
        while(it.hasNext()){
            DentalStaff m = (DentalStaff) it.next();
            if(!(m.getIdNumber() == memID)){
                writer.write(m.getIdNumber() + ","+ m.getFirstName()+ "," + m.getLastName() + "," + m.getAddress() +
                        "," + m.getPhone() + "\r\n");

                done = true;
            }
        }

        writer.flush();
        writer.close();
        if(done == true){
            clearScreen();
            System.out.println("Member deleted successfully");

            //deletes old file
            File fileToDelete = new File("dentist.txt");
            boolean delete = fileToDelete.delete();

            //renames memberChanged.txt to member.txt
            File fileToRename = new File("dentistChanged.txt");
            File renamedFile = new File("dentist.txt");
            boolean rename = fileToRename.renameTo(renamedFile);
            dentistlist.clear();
            loadDentistFile();
        }else{
            System.out.println("Member not found!!!");
        }
    }

    //=================================================================================================

    //update the member detail
    public void updateDentist()throws IOException{
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the Member ID that you wish to update: ");
        int memID = console.nextInt();
        System.out.println();

        Iterator it = getAllDentist().iterator();
        while(it.hasNext()){
            DentalStaff m = (DentalStaff) it.next();
            if((m.getIdNumber() == memID)){
                Scanner s = new Scanner(System.in);
                System.out.println("--------------------------------------------------");
                System.out.println("[0]\t Member First Name");
                System.out.println("[1]\t Member Last Name");
                System.out.println("[2]\t Member Address");
                System.out.println("[3]\t Member Phone");
                System.out.println("--------------------------------------------------");
                System.out.println();
                System.out.println("Please select the record that you wish to update. ");
                int selection = console.nextInt();
                if(selection == 0){
                    System.out.println("Please enter the name to change from " + m.getFirstName() + " to: ");
                    String nameChange = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("dentistChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getIdNumber(), nameChange,m.getLastName(), m.getAddress(), m.getPhone());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }
                else if(selection == 1){
                    System.out.println("Please enter the name to change from " + m.getLastName() + " to: ");
                    String nameChange2 = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("dentistChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getIdNumber(), m.getFirstName(),nameChange2, m.getAddress(), m.getPhone());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 2){
                    System.out.println("Please enter the address to change from " + m.getAddress() + " to: ");
                    String addressChange = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("dentistChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getIdNumber(), m.getFirstName(),m.getLastName(), addressChange, m.getPhone());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 3){
                    boolean loop = false;
                    while(loop == false){
                        System.out.println("Please enter the phone number to change from " + m.getPhone() + " to: (XX-XXXXXXX)");
                        String phoneChange = s.nextLine();

                        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
                        Matcher matcher = pattern.matcher(phoneChange);

                        if (matcher.matches()){
                            try{
                                //the true indicates you want to append
                                output = new Formatter(new FileWriter("dentistChanged.txt", true));
                            }catch(Exception e){
                                System.out.println(e.toString() + ": " + e.getMessage());
                            }

                            output.format("%s,%s,%s,%s,%s\r\n", m.getIdNumber(), m.getFirstName(), m.getLastName(),m.getAddress(), phoneChange);
                            output.close();
                            clearScreen();
                            System.out.println("Update successfully!! ");
                            System.out.println();
                            loop = true;
                        }else{
                            System.out.println("Phone Number must be in the form XX-XXXXXXX");
                        }
                    }
                }else{
                    System.out.println();
                    System.out.println("Input incorrect! Please try again.");
                    //deletes incorrect file
                    File fileToDelete = new File("dentistChanged.txt");
                    boolean delete = fileToDelete.delete();
                    updateDentist();
                }
            }else{
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter("dentistChanged.txt", true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                output.format("%s,%s,%s,%s,%s\r\n", m.getIdNumber(), m.getFirstName(),m.getLastName(), m.getAddress(), m.getPhone());
                output.close();
            }
        }
        //deletes old file
        File fileToDelete = new File("dentist.txt");
        boolean delete = fileToDelete.delete();

        //renames memberChanged.txt to member.txt
        File fileToRename = new File("dentistChanged.txt");
        File renamedFile = new File("dentist.txt");
        boolean rename = fileToRename.renameTo(renamedFile);
        dentistlist.clear();
        loadDentistFile();
    }

    //=================================================================================================

    public void SearchDentist(){


        clearScreen();
        Scanner console = new Scanner(System.in);
        Iterator it1 = getAllDentist().iterator();
        System.out.println("Please enter the Dentist Id you want to search ");
        int memID = console.nextInt();
        while(it1.hasNext()){
            DentalStaff m = (DentalStaff) it1.next();
            if(m.getIdNumber()==memID)
                System.out.println(m.getIdNumber() + "\t\t" + m.getFirstName() + "\t\t" +m.getLastName() + "\t\t" +m.getAddress() + "\t\t" +m.getPhone());
        }
    }

    //=================================================================================================

    //load Dentist file
    public boolean loadDentistFile(){
        try{
            reader = new BufferedReader(new FileReader(dentistFile));
            String line = reader.readLine();

            while(line != null){
                String[] record = line.split(",");
                String memberID = record[0].trim();
               int mid = Integer.parseInt(memberID);
                String memberName = record[1].trim();
                String memberName2 = record[2].trim();
                String memberAddress = record[3].trim();
                String memberPhone = record[4].trim();

                //add the data from file to the course array list
                dentalStaff = new DentalStaff(mid, memberName,memberName2, memberAddress, memberPhone);
                dentistlist.add(dentalStaff);
                line = reader.readLine();
            }

            reader.close();
            return true;
        }catch(IOException e){
            System.out.println(e.toString()+": "+e.getMessage());
            return false;
        }
    }

    //=================================================================================================




                         //==========Office Manager=================


    public int showOfficeManagerMenu(){
        Scanner console = new Scanner(System.in);
        int selection = 0;

        System.out.println("***********************************************************");
        System.out.println("*                    [DCMS System]                    *");
        System.out.println("*                   Office Manager Menu                   *");
        System.out.println("***********************************************************");
        System.out.println("");

        System.out.println("What do you want to do?");
        //System.out.println("[1]:\t ------");
        //System.out.println("[2]:\t -------");
        System.out.println("[3]:\t Add new Patient");
        System.out.println("[4]:\t Update Patient");
        System.out.println("[5]:\t Delete Patient details");
        System.out.println("[6]:\t Search Patients");
        // System.out.println("[7]:\t View a member's hire statement");
        // System.out.println("[8]:\t View all movie list");
        System.out.println("[0]:\t Quit");
        System.out.println("");

        System.out.println("Please enter the menu code: >");
        try{
            selection = console.nextInt();
        }catch(Exception e){
            System.out.println("Please enter the number listed on the menu.");
            System.out.println(e.toString()+": " + e.getMessage());
            pause(2);
            clearScreen();
            showOfficeManagerMenu();
        }

        switch(selection){
            case 0:
                // adminQuitProgram();
                break;

            case 1:
                clearScreen();
                try{
                    // HireMovie();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                    // showAdminMenu();
                }
                break;

            case 2:
                // ReturnMovie();
                // showAdminMenu();
                break;

            case 3:
                addNewPatient();
                showOfficeManagerMenu();
                break;

            case 4:
                clearScreen();
                try{
                    updatePatient();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                    //  showAdminMenu();
                }
                // showAdminMenu();
                break;

            case 5:
                try{
                    deletePatient();
                }catch(Exception e){
                    System.out.println(e.toString()+": "+e.getMessage());
                    showOfficeManagerMenu();
                }
                showOfficeManagerMenu();
                break;

            case 6:
                SearchPatient();
                showOfficeManagerMenu();
                break;

            case 7:
                // showHireStatementAdmin();
                // showAdminMenu();
                break;

            case 8:
                clearScreen();
                // showDVD();
                // showAdminMenu();
                break;


            case 11:
                // adminMenu();
                //howAdminMenu();
                break;

            default:
                System.out.println("Please enter the number listed on the menu.");
                pause(2);
                clearScreen();
                showOfficeManagerMenu();
                break;
        }
        return selection;
    }


    //load Dentist file
    public boolean loadPatientFile(){
        try{
            reader = new BufferedReader(new FileReader(patientFile));
            String line = reader.readLine();

            while(line != null){
                String[] record = line.split(",");
                String memberID = record[0].trim();
                int mid = Integer.parseInt(memberID);
                String memberName = record[1].trim();
                String memberName2 = record[2].trim();
                String memberAddress = record[3].trim();
                String memberDateofBirth = record[4].trim();
                String memberFirstVisit = record[5].trim();
                String memberLastVisit = record[6].trim();

                //add the data from file to the course array list
                patient = new Patient(mid, memberName,memberName2, memberAddress, memberDateofBirth,memberFirstVisit,memberLastVisit);
                patientList.add(patient);
                line = reader.readLine();
            }

            reader.close();
            return true;
        }catch(IOException e){
            System.out.println(e.toString()+": "+e.getMessage());
            return false;
        }
    }

    //=================================================================================================

    //add a new member
    public void addNewPatient(){
        clearScreen();
        Scanner console = new Scanner(System.in);
        Iterator it = patientList.iterator();
        boolean loop = false;
        int tempID = 0;
        while(it.hasNext()){
            Patient m = (Patient) it.next();
            tempID = m.getId();
        }
        tempID++;
        int memID = tempID;
        System.out.println("Please enter member's First Name: ");
        String name = console.nextLine();
        System.out.println("Please enter member's Last Name: ");
        String name2 = console.nextLine();
        System.out.println("Please enter member's Address: ");
        String address = console.nextLine();
        System.out.println("Please enter member's Date of Birth: ");
        String dob = console.nextLine();
        System.out.println("Please enter member's firts visit: ");
        String firstVisit = console.nextLine();
        System.out.println("Please enter member's last visit: ");
        String lastVisit = console.nextLine();
        while(loop == false){
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter(patientFile, true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                clearScreen();
                System.out.println("Patient added successfully");
                output.format("%s,%s,%s,%s,%s,%s,%s\r\n", memID, name,name2, address, dob,firstVisit,lastVisit);
                output.close();
                loop = true;

        }
        System.out.println("=======================================================================");
        dentistlist.clear();
        loadPatientFile();
    }

    //================================================================================================


    //delete member detail
    public void deletePatient() throws Exception{
        clearScreen();
        Scanner console = new Scanner(System.in);

        boolean done = false;
        Writer writer = new BufferedWriter(new FileWriter("patientChanged.txt"));

        System.out.println("Member ID\tMember Name");
        System.out.println("---------------------------------------------");
        Iterator it1 = getAllPatients().iterator();

        while(it1.hasNext()){
            Patient m = (Patient) it1.next();
            System.out.println(m.getId() + "\t\t" + m.getFirstName());
        }
        System.out.println();
        //delete a record from the text file based on the memberID
        System.out.println("Please enter the member's ID number to delete the member: ");
        int memID = console.nextInt();
        // String memId=Integer.toString(memID);
        Iterator it =getAllPatients().iterator();
        while(it.hasNext()){
            Patient m = (Patient) it.next();
            if(!(m.getId() == memID)){
                writer.write(m.getId() + ","+ m.getFirstName()+ "," + m.getlasttName() + "," + m.getAddress() +
                        "," + m.getDateOfBirth() + "," + m.getFirstVisit() +  "," + m.getLastVisit() +"\r\n");

                done = true;
            }
        }

        writer.flush();
        writer.close();
        if(done == true){
            clearScreen();
            System.out.println("Patient deleted successfully");

            //deletes old file
            File fileToDelete = new File("patient.txt");
            boolean delete = fileToDelete.delete();

            //renames memberChanged.txt to member.txt
            File fileToRename = new File("patientChanged.txt");
            File renamedFile = new File("patient.txt");
            boolean rename = fileToRename.renameTo(renamedFile);
            dentistlist.clear();
            loadPatientFile();
        }else{
            System.out.println("patient not found!!!");
        }
    }

    //=================================================================================================

    //update the member detail
    public void updatePatient()throws IOException{
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the Member ID that you wish to update: ");
        int memID = console.nextInt();
        System.out.println();

        Iterator it = getAllPatients().iterator();
        while(it.hasNext()){
            Patient m = (Patient) it.next();
            if((m.getId() == memID)){
                Scanner s = new Scanner(System.in);
                System.out.println("--------------------------------------------------");
                System.out.println("[0]\t Member First Name");
                System.out.println("[1]\t Member Last Name");
                System.out.println("[2]\t Member Address");
                System.out.println("[3]\t Member Date of Birth");
                System.out.println("[4]\t Member First Visit");
                System.out.println("[5]\t Member Last Visit");

                System.out.println("--------------------------------------------------");
                System.out.println();
                System.out.println("Please select the record that you wish to update. ");
                int selection = console.nextInt();
                if(selection == 0){
                    System.out.println("Please enter the name to change from " + m.getFirstName() + " to: ");
                    String nameChange = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("patientChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), nameChange,m.getlasttName(), m.getAddress(), m.getDateOfBirth(),m.getFirstVisit(),m.getLastVisit());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }
                else if(selection == 1){
                    System.out.println("Please enter the name to change from " + m.getlasttName() + " to: ");
                    String nameChange2 = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("patientChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(),nameChange2, m.getAddress(), m.getDateOfBirth(),m.getFirstVisit(),m.getLastVisit());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 2){
                    System.out.println("Please enter the address to change from " + m.getAddress() + " to: ");
                    String addressChange = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("patientChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(),m.getlasttName(), addressChange, m.getDateOfBirth(),m.getFirstVisit(),m.getLastVisit());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 3){

                        System.out.println("Please enter the date of birth to change from " + m.getDateOfBirth() + " ");
                        String dob = s.nextLine();
                            try{
                                //the true indicates you want to append
                                output = new Formatter(new FileWriter("patientChanged.txt", true));
                            }catch(Exception e){
                                System.out.println(e.toString() + ": " + e.getMessage());
                            }

                            output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(), m.getlasttName(),m.getAddress(), dob,m.getFirstVisit(),m.getLastVisit());
                            output.close();
                            clearScreen();
                            System.out.println("Update successfully!! ");
                            System.out.println();

                }
                else if(selection == 4){

                    System.out.println("Please enter the date of birth to change from " + m.getFirstVisit() + " ");
                    String firstVisit = s.nextLine();
                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("patientChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(), m.getlasttName(),m.getAddress(), m.getDateOfBirth(),firstVisit,m.getLastVisit());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();

                }
                else if(selection == 5){

                    System.out.println("Please enter the date of birth to change from " + m.getDateOfBirth() + " ");
                    String lastVisit = s.nextLine();
                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("patientChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(), m.getlasttName(),m.getAddress(),m.getDateOfBirth(),m.getFirstVisit(),lastVisit);
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();

                }
                else{
                    System.out.println();
                    System.out.println("Input incorrect! Please try again.");
                    //deletes incorrect file
                    File fileToDelete = new File("patientChanged.txt");
                    boolean delete = fileToDelete.delete();
                    updatePatient();
                }
            }else{
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter("patientChanged.txt", true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                output.format("%s,%s,%s,%s,%s,%s,%s\r\n", m.getId(), m.getFirstName(),m.getlasttName(), m.getAddress(), m.getDateOfBirth(),m.getFirstVisit(),m.getLastVisit());
                output.close();
            }
        }
        //deletes old file
        File fileToDelete = new File("patient.txt");
        boolean delete = fileToDelete.delete();

        //renames memberChanged.txt to member.txt
        File fileToRename = new File("patientChanged.txt");
        File renamedFile = new File("patient.txt");
        boolean rename = fileToRename.renameTo(renamedFile);
        dentistlist.clear();
        loadDentistFile();
    }

    //=================================================================================================


    public void SearchPatient(){


        clearScreen();
        Scanner console = new Scanner(System.in);
        Iterator it1 = getAllPatients().iterator();
        System.out.println("Please enter the Patient Id you want to search ");
        int memID = console.nextInt();
        while(it1.hasNext()){
            Patient m = (Patient) it1.next();
            if(m.getId()==memID)
                System.out.println(m.getId() + "\t\t" + m.getFirstName() + "\t\t"
                        +m.getlasttName() + "\t\t" +m.getAddress() + "\t\t" +m.getDateOfBirth()+
                        "\t\t" +m.getFirstVisit()+ "\t\t" +m.getLastVisit());
        }
    }

    //=================================================================================================




    //=============================================================INSURANCE=======================
    //=============================================================================================
    //=============================================================================================

    //load Dentist file
    public boolean loadInsuranceFile(){
        try{
            reader = new BufferedReader(new FileReader(insuranceFile));
            String line = reader.readLine();

            while(line != null){
                String[] record = line.split(",");
                String memberID = record[0].trim();
                int mid = Integer.parseInt(memberID);
                String companyName = record[1].trim();
                String Address = record[2].trim();
                String billingContactPerson = record[3].trim();
                String phoneContact = record[4].trim();


                //add the data from file to the course array list
                insurance = new Insurance(mid, companyName,Address, billingContactPerson, phoneContact);
                insuranceList.add(insurance);
                line = reader.readLine();
            }

            reader.close();
            return true;
        }catch(IOException e){
            System.out.println(e.toString()+": "+e.getMessage());
            return false;
        }
    }

    //=================================================================================================

    //add a new member
    public void addNewInsurance(){
        clearScreen();
        Scanner console = new Scanner(System.in);
        Iterator it = insuranceList.iterator();
        boolean loop = false;
        int tempID = 0;
        while(it.hasNext()){
            Insurance m = (Insurance) it.next();
            tempID = m.getId();
        }
        tempID++;
        int memID = tempID;
        System.out.println("Please enter Insurance Company Name: ");
        String companyName = console.nextLine();
        System.out.println("Please enter Address: ");
        String address = console.nextLine();
        System.out.println("Please enter billing Conatct Person: ");
        String billing = console.nextLine();


        while(loop == false){
            System.out.println("Please enter Insurance company phone number: (XXx-XXXXXXX)");
            String phone = console.nextLine();
            Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()){
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter(insuranceFile, true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                clearScreen();
                System.out.println("Insurance Details added successfully");
                output.format("%s,%s,%s,%s,%s\r\n", memID, companyName,address, billing, phone);
                output.close();
                loop = true;
            }else{
                System.out.println("Phone Number must be in the form XX-XXXXXXX");
            }
        }
        System.out.println("=======================================================================");
        insuranceList.clear();
        loadInsuranceFile();
    }

    //================================================================================================


    //delete member detail
    public void deleteInsurance() throws Exception{
        clearScreen();
        Scanner console = new Scanner(System.in);

        boolean done = false;
        Writer writer = new BufferedWriter(new FileWriter("insuranceChanged.txt"));

        System.out.println("Member ID\tMember Name");
        System.out.println("---------------------------------------------");
        Iterator it1 = getAllInsurance().iterator();

        while(it1.hasNext()){
            Insurance m = (Insurance) it1.next();
            System.out.println(m.getId() + "\t\t" + m.getCompanyName());
        }
        System.out.println();
        //delete a record from the text file based on the memberID
        System.out.println("Please enter the member's ID number to delete the member: ");
        int memID = console.nextInt();
        // String memId=Integer.toString(memID);
        Iterator it =getAllInsurance().iterator();
        while(it.hasNext()){
            Insurance m = (Insurance) it.next();
            if(!(m.getId() == memID)){
                writer.write(m.getId() + ","+ m.getCompanyName()+ "," + m.getAddress() + "," + m.getBillingContactPerson() +
                        "," + m.getPhoneContact() +"\r\n");

                done = true;
            }
        }

        writer.flush();
        writer.close();
        if(done == true){
            clearScreen();
            System.out.println("Insurance deleted successfully");

            //deletes old file
            File fileToDelete = new File("insurance.txt");
            boolean delete = fileToDelete.delete();

            //renames memberChanged.txt to member.txt
            File fileToRename = new File("insuranceChanged.txt");
            File renamedFile = new File("insurance.txt");
            boolean rename = fileToRename.renameTo(renamedFile);
            insuranceList.clear();
            loadInsuranceFile();
        }else{
            System.out.println("Insurance not found!!!");
        }
    }

    //=================================================================================================

    //update the Insurance
    public void updateInsurance()throws IOException{
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the Member ID that you wish to update: ");
        int memID = console.nextInt();
        System.out.println();

        Iterator it = getAllInsurance().iterator();
        while(it.hasNext()){
            Insurance m = (Insurance) it.next();
            if((m.getId() == memID)){
                Scanner s = new Scanner(System.in);
                System.out.println("--------------------------------------------------");
                System.out.println("[0]\t Company Name");
                System.out.println("[1]\t Address");
                System.out.println("[2]\t Billing Contact Person");
                System.out.println("[3]\t Phone Contact");

                System.out.println("--------------------------------------------------");
                System.out.println();
                System.out.println("Please select the record that you wish to update. ");
                int selection = console.nextInt();
                if(selection == 0){
                    System.out.println("Please enter the Company Name to change from " + m.getCompanyName() + " to: ");
                    String nameChange = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("insuranceChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getId(), nameChange, m.getAddress(), m.getBillingContactPerson(),m.getPhoneContact());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }
                else if(selection == 1){
                    System.out.println("Please enter the Address to change from " + m.getAddress() + " to: ");
                    String address = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("insuranceChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getId(), m.getCompanyName(),address, m.getBillingContactPerson(),m.getPhoneContact());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 2){
                    System.out.println("Please enter the billing Contact to change from " + m.getBillingContactPerson() + " to: ");
                    String billContact = s.nextLine();

                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("insuranceChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,,%s\r\n", m.getId(), m.getCompanyName(), m.getAddress(), billContact,m.getPhoneContact());
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();
                }else if(selection == 3){

                    System.out.println("Please enter the phone contact to change from " + m.getPhoneContact() + " ");
                    String phone = s.nextLine();
                    try{
                        //the true indicates you want to append
                        output = new Formatter(new FileWriter("insuranceChanged.txt", true));
                    }catch(Exception e){
                        System.out.println(e.toString() + ": " + e.getMessage());
                    }

                    output.format("%s,%s,%s,%s,%s\r\n", m.getId(), m.getCompanyName(), m.getAddress(), m.getBillingContactPerson(),phone);
                    output.close();
                    clearScreen();
                    System.out.println("Update successfully!! ");
                    System.out.println();

                }

                else{
                    System.out.println();
                    System.out.println("Input incorrect! Please try again.");
                    //deletes incorrect file
                    File fileToDelete = new File("insuranceChanged.txt");
                    boolean delete = fileToDelete.delete();
                    updatePatient();
                }
            }else{
                try{
                    //the true indicates you want to append
                    output = new Formatter(new FileWriter("insuranceChanged.txt", true));
                }catch(Exception e){
                    System.out.println(e.toString() + ": " + e.getMessage());
                }

                output.format("%s,%s,%s,%s,,%s\r\n", m.getId(), m.getCompanyName(), m.getAddress(), m.getBillingContactPerson(),m.getPhoneContact());
                output.close();
            }
        }
        //deletes old file
        File fileToDelete = new File("insurance.txt");
        boolean delete = fileToDelete.delete();

        //renames memberChanged.txt to member.txt
        File fileToRename = new File("insuranceChanged.txt");
        File renamedFile = new File("insurance.txt");
        boolean rename = fileToRename.renameTo(renamedFile);
        insuranceList.clear();
        loadInsuranceFile();
    }

    //=================================================================================================


    public void SearchInsurance(){


        clearScreen();
        Scanner console = new Scanner(System.in);
        Iterator it1 = getAllInsurance().iterator();
        System.out.println("Please enter the Insurance Id you want to search ");
        int memID = console.nextInt();
        while(it1.hasNext()){
            Insurance m = (Insurance) it1.next();
            if(m.getId()==memID)
                System.out.println(m.getId() + "\t\t" + m.getCompanyName() + "\t\t" +m.getAddress() + "\t\t" +m.getBillingContactPerson() + "\t\t" +m.getPhoneContact());
        }
    }

    //=================================================================================================




}
