/**
 * Class Main with main method, which generates a new email for a new worker and print out the information about that company email.
 * @author HaiNguyen
 */
public class Main {
    public static void main(String[] args) {
        // Create an email for a new worker Albert Einstein
        Email em1 = new Email("Albert", "Einstein");
        // Shows the information of that email
        em1.displayInfo();
    }
}
