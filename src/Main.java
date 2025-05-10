import java.util.Date;
import java.util.Scanner;

public class Main extends Exception {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Date now = new Date();
        System.out.print("Enter User ID: ");
        String ID = sc.next();
        now = new Date();
        Logger.log(now + "            User " + ID + " entered the system...");
        int mode=3;

        while (true) {
            System.out.println("Choose the option.");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.println("3. Exit");

            try {
                mode = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid entry!");
                mode=3;
                now = new Date();
                Logger.log(now + "            Error:"+e);
            }
            sc.nextLine();

            now = new Date();
            Logger.log(now + "            Option " + mode + " selected...");

            try {
                switch (mode) {
                    case 1:
                        Encryption enc = new Encryption();
                        enc.imageEncryptor();
                        now = new Date();
                        Logger.log(now + "            Image Encrypted Successfully...");
                        break;
                    case 2:
                        Decryption dec = new Decryption();
                        String decryptedMessage = dec.getHiddenMessage();
                        System.out.println("Decrypted Message: " + decryptedMessage);
                        now = new Date();
                        Logger.log(now + "            Image Decrypted Successfully...");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        now = new Date();
                        Logger.log(now + "            User " + ID + " exited the system...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select 1, 2 or 3.");
                        now = new Date();
                        Logger.log(now + "            Invalid input...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                now = new Date();
                Logger.log(now + "            Error: " + e.getMessage());
            }
        }
    }
}
