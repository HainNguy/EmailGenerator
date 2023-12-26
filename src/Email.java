import java.util.Random;
import java.util.Scanner;

/**
 * @author HaiNguyen
 */
public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private String companySuffix = "spaceX.com";
    private int defaultPasswordLength = 12;
    // Constructor

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.printf("NEW EMPLOYEE : %s %s\n", this.firstName, this.lastName);
        // Determine department
        this.department = determineDepartment();
        System.out.printf("Your department: %s\n", this.department);
        // Generate email
        this.email = String.format("%s.%s@%s.%s", firstName.toLowerCase(), lastName.toLowerCase(), department, companySuffix);
        System.out.printf("Your company email is: %s\n", this.email);
        // Generate password
        this.password = generatePassword(defaultPasswordLength);
        System.out.printf("Your password is: %s\n", this.password);


    }

    private String generatePassword(int length) {
        String allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        char[] password = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password[i] = allCharacters.charAt(randomIndex);
        }
        return new String(password);
    }

    private String determineDepartment() {
        Scanner input = new Scanner(System.in);
        while(true){
            try {
                printDepartmentOptions();
                int departmentNr = input.nextInt();
                if(isValidDepartment(departmentNr)){
                    return getDepartmentName(departmentNr);
                } else {System.out.println("Try again. An integer number from 0 to 3 is required.");}
            } catch (Exception ex){
                System.out.println("Try again. An integer number from 0 to 3 is required.");
                input.nextLine(); // Clear the input buffer
            }
        }
    }
    private static void printDepartmentOptions(){
        System.out.println("""
                Choose the following department:
                  0. Sales
                  1. Development
                  2. Accounting
                  3. None
                  """);
    }
    private static boolean isValidDepartment(int departmentNr) {
        return departmentNr >= 0 && departmentNr <= 3;
    }
    private static String getDepartmentName(int departmentNr) {
        switch (departmentNr) {
            case 0:
                return "sales";
            case 1:
                return "development";
            case 2:
                return "accounting";
            case 3:
                return "";
            default:
                throw new IllegalArgumentException("Invalid department number");
        }
    }

    public void displayInfo() {
        System.out.printf("DISPLAY NAME: %s %s\nCOMPANY EMAIL: %s\nMAILBOX CAPACITY: %d MB\n", this.firstName, this.lastName, this.email, this.mailboxCapacity);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
}
