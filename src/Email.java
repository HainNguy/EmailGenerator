import java.util.Random;
import java.util.Scanner;

/** This class represents and generates a company email for a new employee
 * @author HaiNguyen
 * @version 1.1
 */
public class Email {
    /**
     * Data field: the first name of the worker
     */
    private String firstName;
    /**
     * Data field: the last name of the worker
     */
    private String lastName;
    /**
     * Data field: the department of the worker
     */
    private String department;
    /**
     * Data field: the password of the company email
     */
    private String password;
    /**
     * Data field: the mailbox capacity for the company email
     */
    private int mailboxCapacity = 500;
    /**
     * Data field: the alternate email address of the worker
     */
    private String alternateEmail;
    /**
     * Data field: the company email address of the worker
     */
    private String email;
    /**
     * Data Field: the company suffix for the email syntax
     */
    private String companySuffix = "spaceX.com";
    /**
     * Data field: the default lenght of a random password
     */
    private int defaultPasswordLength = 12;


    // Constructor
    /**
     * Generates an email with given first name and last name
     * @param firstName the first name of an employee
     * @param lastName the last name of an employee
     */
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

    /**
     * Creates a random password with given length
     * @param length the length of the password
     * @return a random password of the given length.
     */
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

    /**
     * Determines the department of a worker
     * @return department name of the worker
     */
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

    /**
     * Prints out the optional departments
     */
    private static void printDepartmentOptions(){
        System.out.println("""
                Choose the following department:
                  0. Sales
                  1. Development
                  2. Accounting
                  3. None
                  """);
    }

    /**
     * Checks, whether the given department number is valid
     * @param departmentNr the department number
     * @return true, if it is a valid department number
     *         false, otherwise
     */
    private static boolean isValidDepartment(int departmentNr) {
        return departmentNr >= 0 && departmentNr <= 3;
    }

    /**
     * Gets the name of the department with given department number
     * @param departmentNr the department number
     * @return the name of the department
     */
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

    /**
     * Shows the information about the company email of the employee
     */
    public void displayInfo() {
        System.out.printf("DISPLAY NAME: %s %s\nCOMPANY EMAIL: %s\nMAILBOX CAPACITY: %d MB\n", this.firstName, this.lastName, this.email, this.mailboxCapacity);
    }

    /**
     * Sets the password for the email
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the mailbox capacity for the email
     * @param capacity the capacity
     */
    public void setCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    /**
     * Gets the department
     * @return the department name
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets the password for the email
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the mailbox capacity of the email
     * @return the mailbox capacity
     */
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    /**
     * Gets the alternate email
     * @return the alternate email
     */
    public String getAlternateEmail() {
        return alternateEmail;
    }

    /**
     * Gets the company email of the worker
     * @return the company email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the alternate email of the worker
     * @param alternateEmail the alternate email
     */
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
}
